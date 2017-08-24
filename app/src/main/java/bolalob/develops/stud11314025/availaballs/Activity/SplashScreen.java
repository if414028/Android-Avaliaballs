package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.Kota;
import bolalob.develops.stud11314025.availaballs.Model.KotaResult;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.APIKota;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.SharePreferencesManager;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {

    public static final String USER = "userKey";
    public static final String PASS = "passKey";

    Realm realm;
    APIKota ApiKota;

    KotaResult kotaResult;

    private Context getContext() {
        return SplashScreen.this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Window window = SplashScreen.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        Context context = getApplicationContext();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrlinedark));
        }

        try{
            realm = Realm.getDefaultInstance();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        callListKota();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String user = SharePreferencesManager.getUser(getContext());
                String pass = SharePreferencesManager.getPass(getContext());

                if (user.isEmpty() && pass.isEmpty()) {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                } else {
                    finish();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }

            }
        }, 3000);
    }

    private void callListKota(){
        APIKota client = Service.createService(APIKota.class);
        Call<KotaResult> call = client.getListKota();
        call.enqueue(new Callback<KotaResult>() {
            @Override
            public void onResponse(Call<KotaResult> call, Response<KotaResult> response) {

                if (response.isSuccessful()){
                    kotaResult = response.body();
                    List<Kota> kotaList = kotaResult.getKotaList();
                    int jumlahKota = kotaList.size();
                    if (jumlahKota > 0){
                        for(int y = 0; y < jumlahKota; y++){
                            final Kota tmpListKota = kotaList.get(y);
                            try{
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {
                                        Log.d("Data Kota" , tmpListKota.getId() + " / " + tmpListKota.getLocation());
                                        Kota modelKota = realm.createObject(Kota.class, tmpListKota.getId());
                                        modelKota.setLocation(tmpListKota.getLocation());
                                    }
                                });
                            }catch (Exception e){
                                Log.e(String.valueOf(getApplicationContext()), "Code: " + e.getMessage() +" , Message: " + e.getMessage());
                            }
                        }
                    }else {
                        Toast. makeText(getApplicationContext(), "DATA SEDANG TIDAK TERSEDIA", Toast. LENGTH_LONG).show();
                    }
                }else {
                    Log. e("onResponse failure", "Code: " + response.code() +" , Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<KotaResult> call, Throwable t) {
                Toast. makeText(getApplicationContext(), "AKSES KE SERVER GAGAL"+t.getMessage(), Toast. LENGTH_LONG).show();
            }
        });

    }
}
