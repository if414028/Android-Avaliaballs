package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import java.util.ArrayList;
import java.util.List;

import bolalob.develops.stud11314025.availaballs.Model.Kota;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import bolalob.develops.stud11314025.availaballs.Widget.SharePreferencesManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;
import io.realm.Realm;
import io.realm.RealmResults;

public class TambahLapanganStepDuaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.eTlokasiLapangan)
    EditText etLokasi;
    @BindView(R.id.eTTelepon)
    EditText etTelepon;
    @BindView(R.id.iconTeleponAdd)
    CustomFontTextView addTlp;
    @BindView(R.id.eTTelepon2)
    EditText etTelepon2;
    @BindView(R.id.eTTelepon3)
    EditText etTelepon3;
    @BindView(R.id.lytlp)
    LinearLayout ly;
    @BindView(R.id.txtCoordinatUpdate)
    TextView textCoordinatUpdate;
    @BindView(R.id.spinnerJumlahLapangan)
    Spinner spinnerJumlahLapangan;
    @BindView(R.id.spinnerKota)
    Spinner spinnerKota;
    @BindView(R.id.layoutTelepon)
    LinearLayout layoutTelepon;
    @BindView(R.id.layoutTelepon2)
    LinearLayout layoutTelepon2;
    @BindView(R.id.layoutTelepon3)
    LinearLayout layoutTelepon3;


    int PLACE_PICKER_REQUEST = 1;

    private Context getContext() {
        return TambahLapanganStepDuaActivity.this;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan_step_dua);
        ButterKnife.bind(this);
        setStatusBarColor();
        addActionBar();

        List<String> location = new ArrayList<>();

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Kota> realmResults = realm.where(Kota.class).findAll();
        List<Kota> kotaResults = realm.copyFromRealm(realmResults);
        for (int i = 0; i<kotaResults.size(); i++){
            Kota tmpListKota = kotaResults.get(i);
            Log.d("Data Kota" , tmpListKota.getLocation());
            location.add(tmpListKota.getLocation());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, location);
        spinnerKota.setAdapter(adapter);

        spinnerJumlahLapangan.setOnItemSelectedListener(this);
    }

    private void setStatusBarColor() {
        Window window = TambahLapanganStepDuaActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    @OnClick(R.id.location_button)
    void onButtonClick() {
        try {
            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
            startActivityForResult(builder.build(TambahLapanganStepDuaActivity.this), PLACE_PICKER_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(data, this);
                String toastMsg = String.format("%s", place.getName());
                textCoordinatUpdate.setText(toastMsg);
                Toast.makeText(TambahLapanganStepDuaActivity.this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

    @OnTextChanged(value = R.id.eTlokasiLapangan, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeLokasiTextUpdateChanged() {
        final FrameLayout lllokasi = (FrameLayout) findViewById(R.id.layoutLokasiFrame);
        lllokasi.setAlpha(0.5f);
    }

    @OnTextChanged(value = R.id.eTlokasiLapangan, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onLokasiTextUpdateChanged() {
        final FrameLayout lllokasi = (FrameLayout) findViewById(R.id.layoutLokasiFrame);
        int length = etLokasi.getText().length();
        if (length == 0) {
            lllokasi.setAlpha(0.5f);
        } else lllokasi.setAlpha(1.0f);
    }

    @OnTextChanged(value = R.id.eTlokasiLapangan, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterLokasiTextUpdateChanged() {
        final FrameLayout lllokasi = (FrameLayout) findViewById(R.id.layoutLokasiFrame);
        final ImageView map = (ImageView) findViewById(R.id.location_button);

        int length = etLokasi.getText().length();
        if (length == 0) {
            lllokasi.setAlpha(0.5f);
        } else {
            lllokasi.setAlpha(1.0f);
        }
    }

    @OnFocusChange(value = R.id.eTlokasiLapangan)
    void onLokasiUpdateFocusChanged(boolean focused) {
        final View lllokasi = findViewById(R.id.layoutLokasiFrame);
        if (!focused) {
            lllokasi.setAlpha(0.5f);
        }
    }

//    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
//    void beforeTeleponTextChanged() {
//        final View lltelepon = findViewById(R.id.layoutTelepon);
//        lltelepon.setAlpha(0.5f);
//    }

//    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.TEXT_CHANGED)
//    void onTeleponTextChanged() {
//        final View lltelepon = findViewById(R.id.layoutTelepon);
//        int length = etTelepon.getText().length();
//        if (length == 0) {
//            lltelepon.setAlpha(0.5f);
//        } else lltelepon.setAlpha(1.0f);
//    }

//    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
//    void afterTeleponTextChanged() {
//        final View lltelepon = findViewById(R.id.layoutTelepon);
//        int length = etTelepon.getText().length();
//        if (length == 0) {
//            lltelepon.setAlpha(0.5f);
//        } else {
//            lltelepon.setAlpha(1.0f);
//        }
//    }

    public void addActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Daftarkan Lapangan");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void nextStep(View view) {
        String alamatLapangan = etLokasi.getText().toString();
        String coordinatLapangan = textCoordinatUpdate.getText().toString();
        String[] temp;
        String delimiter = " ";
        temp = coordinatLapangan.split(delimiter);
        String longitude = temp[0];
        String latitude = temp[1];
        String kota = spinnerKota.getSelectedItem().toString();
        String jumlahLapangan = spinnerJumlahLapangan.getSelectedItem().toString();
        String phone = etTelepon.getText().toString();
        String phone2 = etTelepon2.getText().toString();
        String phone3 = etTelepon3.getText().toString();

        String teleponResult = (phone + ", " + phone2 + ", " + phone3);
        System.out.println(teleponResult);

        Lapangan lapangan = new Lapangan();
        lapangan.setDetailLocation(alamatLapangan);
        lapangan.setLocation(kota);
        lapangan.setPhone(teleponResult);
        lapangan.setNumberOfField(jumlahLapangan);
        lapangan.setLongitude(longitude);
        lapangan.setLatitude(latitude);

        SharePreferencesManager.setSecondStepCreateLapagan(getContext(), lapangan);

        Intent intent = new Intent(TambahLapanganStepDuaActivity.this, TambahLapanganStepTigaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iconTeleponAdd)
    void addTelepon(){
        layoutTelepon2.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iconTeleponAdd2)
    void addTelepon2(){
        layoutTelepon3.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.iconTeleponRemove2)
    void removeTelepon2(){
        layoutTelepon2.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconTeleponRemove3)
    void removeTelepon3(){
        LinearLayout parent = (LinearLayout)findViewById(R.id.lytlp);
        int count = parent.getChildCount();
        int maxPhoneNumber = 3;
        if (count < 3){
            layoutTelepon3.setVisibility(View.GONE);
        }
        else {
            Toast.makeText(getApplicationContext(), "Maksimal 3 nomor telepon", Toast.LENGTH_SHORT).show();
        }

    }

}
