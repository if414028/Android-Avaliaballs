package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.Model.LapanganDetailResult;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.APICreateLapangan;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.NumberTextWatcher;
import bolalob.develops.stud11314025.availaballs.Widget.SharePreferencesManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahLapanganStepTigaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.checkBoxSenin)
    CheckBox chSenin;
    @BindView(R.id.checkBoxSelasa)
    CheckBox chSelasa;
    @BindView(R.id.checkBoxRabu)
    CheckBox chRabu;
    @BindView(R.id.checkBoxKamis)
    CheckBox chKamis;
    @BindView(R.id.checkBoxJumat)
    CheckBox chJumat;
    @BindView(R.id.checkBoxSabtu)
    CheckBox chSabtu;
    @BindView(R.id.checkBoxMinggu)
    CheckBox chMinggu;
    @BindView(R.id.eTHarga)
    EditText etHarga;
    @BindView(R.id.spinnerJamBuka)
    Spinner spinnerJamBuka;
    @BindView(R.id.spinnerJamTutup)
    Spinner spinnerJamTutup;

    private Context getContext() {
        return TambahLapanganStepTigaActivity.this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan_step_tiga);
        ButterKnife.bind(this);
        setStatusBarColor();
        addActionBar();

        EditText harga = (EditText) findViewById(R.id.eTHarga);
        harga.addTextChangedListener(new NumberTextWatcher(harga));

    }

    public String getSelectedHari() {
        String selectedHari = "";
        if (chSenin.isChecked()) {
            selectedHari = selectedHari + "senin";
        }
        if (chSelasa.isChecked()) {
            selectedHari = selectedHari + "," + "selasa";
        }
        if (chRabu.isChecked()) {
            selectedHari = selectedHari + "," + "rabu";
        }
        if (chKamis.isChecked()) {
            selectedHari = selectedHari + "," + "kamis";
        }
        if (chJumat.isChecked()) {
            selectedHari = selectedHari + "," + "jumat";
        }
        if (chSabtu.isChecked()) {
            selectedHari = selectedHari + "," + "sabtu";
        }
        if (chMinggu.isChecked()) {
            selectedHari = selectedHari + "," + "minggu";
        }

        return selectedHari;

    }

    private void setStatusBarColor() {
        Window window = TambahLapanganStepTigaActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

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

        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
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

    public void finishStep(View view) {

        Lapangan lapangan = new Lapangan();

        String selectingHariResult = getSelectedHari();

        String jamBuka = spinnerJamBuka.getSelectedItem().toString();
        String jamBukaResult = jamBuka + ":00";
        String jamTutup = spinnerJamTutup.getSelectedItem().toString();
        String jamTutupResult = jamTutup + ":00";
        String hargaLapangan = etHarga.getText().toString();

        lapangan.setDays(selectingHariResult);
        lapangan.setOpeningHours(jamBukaResult);
        lapangan.setClosingHours(jamTutupResult);
        lapangan.setPrice(hargaLapangan);

        SharePreferencesManager.setThirdStepCreateLapangan(getContext(), lapangan);

        createLapangan();

        Intent intent = new Intent(TambahLapanganStepTigaActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void createLapangan() {
        String account = "3";
        Lapangan result = SharePreferencesManager.getAllData(getContext());
        result.setAccount(account);
        System.out.println(result.toString());
        APICreateLapangan service = Service.createService(APICreateLapangan.class);
        Call<LapanganDetailResult> call = service.createLapangan(result.getFieldName(),
                result.getDetailLocation(),
                result.getPhone(),
                result.getNumberOfField(),
                result.getOpeningHours(),
                result.getClosingHours(),
                result.getPrice(),
                account,
                result.getLocation(),
                result.getDays(),
                result.getLongitude(),
                result.getLatitude());
        call.enqueue(new Callback<LapanganDetailResult>() {

            @Override
            public void onResponse(Call<LapanganDetailResult> call, Response<LapanganDetailResult> response) {

            }

            @Override
            public void onFailure(Call<LapanganDetailResult> call, Throwable t) {

            }
        });

    }
}
