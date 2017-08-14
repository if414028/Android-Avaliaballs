package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.SharePreferencesManager;

public class SplashScreen extends AppCompatActivity {

    public static final String USER = "userKey";
    public static final String PASS = "passKey";

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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrlinedark));
        }

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
                    Intent intent = new Intent(getApplicationContext(), DetailLapanganActivity.class);
                    startActivity(intent);
                }

            }
        }, 1000);
    }
}
