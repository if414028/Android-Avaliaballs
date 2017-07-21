package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
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

        addTextWatcher();

        spinnerJumlahLapangan.setOnItemSelectedListener(this);

    }

    @OnClick(R.id.eTLokasi)
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

    public void addTextWatcher() {

        final View lllokasi = findViewById(R.id.layoutLokasi);
        final View lltelepon = findViewById(R.id.layoutTelepon);

        TextWatcher lokasiWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lllokasi.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etLokasi.getText().length();
                if (length == 0) {
                    lllokasi.setAlpha(0.5f);
                } else lllokasi.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                int length = etLokasi.getText().length();
                if (length == 0) {
                    lllokasi.setAlpha(0.5f);
                } else lllokasi.setAlpha(1.0f);
            }
        };
        etLokasi.addTextChangedListener(lokasiWatcher);

        TextWatcher teleponWatcher = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                lltelepon.setAlpha(0.5f);
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int length = etTelepon.getText().length();
                if (length == 0) {
                    lltelepon.setAlpha(0.5f);
                } else lltelepon.setAlpha(1.0f);
            }

            public void afterTextChanged(Editable s) {
                int length = etTelepon.getText().length();
                if (length == 0) {
                    lltelepon.setAlpha(0.5f);
                } else lltelepon.setAlpha(1.0f);
            }
        };
        etTelepon.addTextChangedListener(teleponWatcher);
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
        LinearLayout ly = (LinearLayout) findViewById(R.id.lytlp);

        View tv = LayoutInflater.from(this).inflate(R.layout.listedittext_telepon, null);

        int count = ly.getChildCount();

        int maxPhoneNumber = 5;

        if (count < maxPhoneNumber) {
            ly.addView(tv);
        } else {
            Toast.makeText(ly.getContext(), "Hanya dapat menambahkan 5 nomor telepon.", Toast.LENGTH_LONG).show();
        }
    }

}
