package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateJamBukaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.spinnerJamBukaSenin)
    Spinner spinnerJmBkSenin;
    @BindView(R.id.spinnerJamBukaSelasa)
    Spinner spinnerJmBkSelasa;
    @BindView(R.id.spinnerJamBukaRabu)
    Spinner spinnerJmBkRabu;
    @BindView(R.id.spinnerJamBukaKamis)
    Spinner spinnerJmBkKamis;
    @BindView(R.id.spinnerJamBukaJumat)
    Spinner spinnerJmBkJumat;
    @BindView(R.id.spinnerJamBukaSabtu)
    Spinner spinnerJmBkSabtu;
    @BindView(R.id.spinnerJamBukaMinggu)
    Spinner spinnerJmBkMinggu;
    @BindView(R.id.spinnerJamTutupSenin)
    Spinner spinnerJmTpSenin;
    @BindView(R.id.spinnerJamTutupSelasa)
    Spinner spinnerJmTpSelasa;
    @BindView(R.id.spinnerJamTutupRabu)
    Spinner spinnerJmTpRabu;
    @BindView(R.id.spinnerJamTutupKamis)
    Spinner spinnerJmTpKamis;
    @BindView(R.id.spinnerJamTutupJumat)
    Spinner spinnerJmTpJumat;
    @BindView(R.id.spinnerJamTutupSabtu)
    Spinner spinnerJmTpSabtu;
    @BindView(R.id.spinnerJamTutupMinggu)
    Spinner spinnerJmTpMinggu;

    @OnClick(R.id.cbMinggu)
    void cbminggu(CheckBox checkbox) {
        if (spinnerJmBkMinggu.isClickable() == true && spinnerJmTpMinggu.isClickable() == true) {
            spinnerJmBkMinggu.setClickable(false);
            spinnerJmTpMinggu.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkMinggu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpMinggu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkMinggu.setAlpha(0.5f);
                spinnerJmTpMinggu.setAlpha(0.5f);
            }

        } else {
            spinnerJmBkMinggu.setClickable(true);
            spinnerJmTpMinggu.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkMinggu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpMinggu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkMinggu.setAlpha(1.0f);
                spinnerJmTpMinggu.setAlpha(1.0f);

            }
        }
    }

    @OnClick(R.id.cbSabtu)
    void cbsabtu(CheckBox checkbox) {
        if (spinnerJmBkSabtu.isClickable() == true && spinnerJmTpSabtu.isClickable() == true) {
            spinnerJmBkSabtu.setClickable(false);
            spinnerJmTpSabtu.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSabtu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpSabtu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkSabtu.setAlpha(0.5f);
                spinnerJmTpSabtu.setAlpha(0.5f);
            }


        } else {
            spinnerJmBkSabtu.setClickable(true);
            spinnerJmTpSabtu.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSabtu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpSabtu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkSabtu.setAlpha(1.0f);
                spinnerJmTpSabtu.setAlpha(1.0f);

            }
        }
    }

    @OnClick(R.id.cbJumat)
    void cbjumat(CheckBox checkbox) {
        if (spinnerJmBkJumat.isClickable() == true && spinnerJmTpJumat.isClickable() == true) {
            spinnerJmBkJumat.setClickable(false);
            spinnerJmTpJumat.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkJumat.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpJumat.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkJumat.setAlpha(0.5f);
                spinnerJmTpJumat.setAlpha(0.5f);
            }


        } else {
            spinnerJmBkJumat.setClickable(true);
            spinnerJmTpJumat.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkJumat.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpJumat.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkJumat.setAlpha(1.0f);
                spinnerJmTpJumat.setAlpha(1.0f);
            }
        }
    }

    @OnClick(R.id.cbKamis)
    void cbkamis(CheckBox checkbox) {
        if (spinnerJmBkKamis.isClickable() == true && spinnerJmTpKamis.isClickable() == true) {
            spinnerJmBkKamis.setClickable(false);
            spinnerJmTpKamis.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkKamis.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpKamis.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkKamis.setAlpha(0.5f);
                spinnerJmTpKamis.setAlpha(0.5f);
            }


        } else {
            spinnerJmBkKamis.setClickable(true);
            spinnerJmTpKamis.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkKamis.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpKamis.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkKamis.setAlpha(1.0f);
                spinnerJmTpKamis.setAlpha(1.0f);

            }
        }
    }

    @OnClick(R.id.cbRabu)
    void cbrabu(CheckBox checkbox) {
        if (spinnerJmBkRabu.isClickable() == true && spinnerJmTpRabu.isClickable() == true) {
            spinnerJmBkRabu.setClickable(false);
            spinnerJmTpRabu.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkRabu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpRabu.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkRabu.setAlpha(0.5f);
                spinnerJmTpRabu.setAlpha(0.5f);

            }


        } else {
            spinnerJmBkRabu.setClickable(true);
            spinnerJmTpRabu.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkRabu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpRabu.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkRabu.setAlpha(1.0f);
                spinnerJmTpRabu.setAlpha(1.0f);

            }
        }
    }

    @OnClick(R.id.cbSelasa)
    void cbselasa(CheckBox checkbox) {
        if (spinnerJmBkSelasa.isClickable() == true && spinnerJmTpSelasa.isClickable() == true) {
            spinnerJmBkSelasa.setClickable(false);
            spinnerJmTpSelasa.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSelasa.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpSelasa.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkSelasa.setAlpha(0.5f);
                spinnerJmTpSelasa.setAlpha(0.5f);
            }


        } else {
            spinnerJmBkSelasa.setClickable(true);
            spinnerJmTpSelasa.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSelasa.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpSelasa.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkSelasa.setAlpha(1.0f);
                spinnerJmTpSelasa.setAlpha(1.0f);

            }
        }
    }

    @OnClick(R.id.cbSenin)
    void cbsenin(CheckBox checkbox) {
        if (spinnerJmBkSenin.isClickable() == true && spinnerJmTpSenin.isClickable() == true) {
            spinnerJmBkSenin.setClickable(false);
            spinnerJmTpSenin.setClickable(false);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSenin.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmTpSenin.setBackground(getDrawable(R.drawable.bgspinner));
                spinnerJmBkSenin.setAlpha(0.5f);
                spinnerJmTpSenin.setAlpha(0.5f);
            }


        } else {
            spinnerJmBkSenin.setClickable(true);
            spinnerJmTpSenin.setClickable(true);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                spinnerJmBkSenin.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmTpSenin.setBackground(getDrawable(R.drawable.bgspinner_checked));
                spinnerJmBkSenin.setAlpha(1.0f);
                spinnerJmTpSenin.setAlpha(1.0f);

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_jam_buka);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Pengaturan Jadwal");

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        spinnerJmBkSenin.setOnItemSelectedListener(this);
        spinnerJmBkSelasa.setOnItemSelectedListener(this);
        spinnerJmBkRabu.setOnItemSelectedListener(this);
        spinnerJmBkKamis.setOnItemSelectedListener(this);
        spinnerJmBkJumat.setOnItemSelectedListener(this);
        spinnerJmBkSabtu.setOnItemSelectedListener(this);
        spinnerJmBkMinggu.setOnItemSelectedListener(this);
        spinnerJmTpSenin.setOnItemSelectedListener(this);
        spinnerJmTpSelasa.setOnItemSelectedListener(this);
        spinnerJmTpRabu.setOnItemSelectedListener(this);
        spinnerJmTpKamis.setOnItemSelectedListener(this);
        spinnerJmTpJumat.setOnItemSelectedListener(this);
        spinnerJmTpSabtu.setOnItemSelectedListener(this);
        spinnerJmTpMinggu.setOnItemSelectedListener(this);
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
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void Simpan(View view) {
        Intent intent = new Intent(getApplicationContext(), DetailLapanganActivity.class);
        startActivity(intent);
    }
}
