package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

public class TambahLapanganStepDuaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.eTLokasi)
    EditText etLokasi;
    @BindView(R.id.eTTelepon)
    EditText etTelepon;
    @BindView(R.id.iconTeleponAdd)
    CustomFontTextView addTlp;
    @BindView(R.id.lytlp)
    LinearLayout ly;

    int PLACE_PICKER_REQUEST = 1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan_step_dua);
        ButterKnife.bind(this);

        addActionBar();

        spinnerJumlahLapangan.setOnItemSelectedListener(this);
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
                String toastMsg = String.format("%s", place.getName() + ",\n" + place.getAddress());
                etLokasi.setText(toastMsg);
                Toast.makeText(TambahLapanganStepDuaActivity.this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

    @BindView(R.id.spinnerJumlahLapangan)
    Spinner spinnerJumlahLapangan;

    @OnTextChanged(value = R.id.eTLokasi, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeLokasiTextChanged() {
        final View lllokasi = findViewById(R.id.layoutLokasi);
        lllokasi.setAlpha(0.5f);
    }

    @OnTextChanged(value = R.id.eTLokasi, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onLokasiTextChanged() {
        final View lllokasi = findViewById(R.id.layoutLokasi);
        int length = etLokasi.getText().length();
        if (length == 0) {
            lllokasi.setAlpha(0.5f);
        } else lllokasi.setAlpha(1.0f);
    }

    @OnTextChanged(value = R.id.eTLokasi, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterLokasiTextChanged() {
        final View lllokasi = findViewById(R.id.layoutLokasi);
        final ImageView map = (ImageView) findViewById(R.id.location_button);

        int length = etLokasi.getText().length();
        if (length == 0) {
            lllokasi.setAlpha(0.5f);
        } else {
            lllokasi.setAlpha(1.0f);
            map.setImageResource(R.drawable.map_color);
        }
    }

    @OnFocusChange(value = R.id.eTLokasi)
    void onLokasiFocusChanged(boolean focused) {
        final View lllokasi = findViewById(R.id.layoutLokasi);
        if (!focused) {
            lllokasi.setAlpha(0.5f);
        }
    }

    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTeleponTextChanged() {
        final View lltelepon = findViewById(R.id.layoutTelepon);
        lltelepon.setAlpha(0.5f);
    }

    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTeleponTextChanged() {
        final View lltelepon = findViewById(R.id.layoutTelepon);
        int length = etTelepon.getText().length();
        if (length == 0) {
            lltelepon.setAlpha(0.5f);
        } else lltelepon.setAlpha(1.0f);
    }

    @OnTextChanged(value = R.id.eTTelepon, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTeleponTextChanged() {
        final View lltelepon = findViewById(R.id.layoutTelepon);
        int length = etTelepon.getText().length();
        if (length == 0) {
            lltelepon.setAlpha(0.5f);
        } else lltelepon.setAlpha(1.0f);
    }

    @OnFocusChange(value = R.id.eTTelepon)
    void afterTeleponFocusChanged(boolean focused) {
        final View lltelepon = findViewById(R.id.layoutTelepon1);
        if (!focused) {
            lltelepon.setAlpha(0.5f);
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
        Intent intent = new Intent(TambahLapanganStepDuaActivity.this, TambahLapanganStepTigaActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.iconTeleponAdd)
    void addTelepon() {
        LinearLayout parent = (LinearLayout) findViewById(R.id.lytlp);

        View tv = LayoutInflater.from(this).inflate(R.layout.list_edittext_telepon, null);

        int count = parent.getChildCount();

        int maxPhoneNumber = 3;

        if (count < maxPhoneNumber) {
            parent.addView(tv);
        } else {
            Toast.makeText(ly.getContext(), "Hanya dapat menambahkan 3 nomor telepon.", Toast.LENGTH_LONG).show();
        }
    }

}
