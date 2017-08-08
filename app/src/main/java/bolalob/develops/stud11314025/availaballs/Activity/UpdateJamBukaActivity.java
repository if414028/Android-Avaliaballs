package bolalob.develops.stud11314025.availaballs.Activity;

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
            spinnerMingguTransformClickableTrue();
        } else {
            spinnerMingguTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbSabtu)
    void cbsabtu(CheckBox checkbox) {
        if (spinnerJmBkSabtu.isClickable() == true && spinnerJmTpSabtu.isClickable() == true) {
            spinnerSabtuTransformClickableTrue();
        } else {
            spinnerSabtuTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbJumat)
    void cbjumat(CheckBox checkbox) {
        if (spinnerJmBkJumat.isClickable() == true && spinnerJmTpJumat.isClickable() == true) {
            spinnerJumatTransformClickableTrue();
        } else {
            spinnerJumatTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbKamis)
    void cbkamis(CheckBox checkbox) {
        if (spinnerJmBkKamis.isClickable() == true && spinnerJmTpKamis.isClickable() == true) {
            spinnerKamisTransformClickableTrue();
        } else {
            spinnerKamisTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbRabu)
    void cbrabu(CheckBox checkbox) {
        if (spinnerJmBkRabu.isClickable() == true && spinnerJmTpRabu.isClickable() == true) {
            spinnerRabuTransformClickableTrue();
        } else {
            spinnerRabuTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbSelasa)
    void cbselasa(CheckBox checkbox) {
        if (spinnerJmBkSelasa.isClickable() == true && spinnerJmTpSelasa.isClickable() == true) {
            spinnerSelasaTransformClickableTrue();
        } else {
            spinnerSelasaTransformClickableFalse();
        }
    }

    @OnClick(R.id.cbSenin)
    void cbsenin(CheckBox checkbox) {
        if (spinnerJmBkSenin.isClickable() == true && spinnerJmTpSenin.isClickable() == true) {
            spinnerSeninTransformClickableTrue();
        } else {
            spinnerSeninTransformClickableFalse();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_jam_buka);
        ButterKnife.bind(this);
        setActionBarOntheTop();
        setOnItemSelectedListenerAll();
        setStatusbar();
    }

    private void setStatusbar() {
        Window window = UpdateJamBukaActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    private void setOnItemSelectedListenerAll() {
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

    private void setActionBarOntheTop() {
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
    public void onNothingSelected(AdapterView<?> adapterView) {    }

    public void Simpan(View view) {
        this.finish();
    }

    private void spinnerMingguTransformClickableFalse() {
        spinnerJmBkMinggu.setClickable(true);
        spinnerJmTpMinggu.setClickable(true);
        spinnerJmBkMinggu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpMinggu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkMinggu.setAlpha(1.0f);
        spinnerJmTpMinggu.setAlpha(1.0f);
    }

    private void spinnerMingguTransformClickableTrue() {
        spinnerJmBkMinggu.setClickable(false);
        spinnerJmTpMinggu.setClickable(false);
        spinnerJmBkMinggu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpMinggu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkMinggu.setAlpha(0.5f);
        spinnerJmTpMinggu.setAlpha(0.5f);
    }

    private void spinnerSabtuTransformClickableFalse() {
        spinnerJmBkSabtu.setClickable(true);
        spinnerJmTpSabtu.setClickable(true);
        spinnerJmBkSabtu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpSabtu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkSabtu.setAlpha(1.0f);
        spinnerJmTpSabtu.setAlpha(1.0f);
    }

    private void spinnerSabtuTransformClickableTrue() {
        spinnerJmBkSabtu.setClickable(false);
        spinnerJmTpSabtu.setClickable(false);
        spinnerJmBkSabtu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpSabtu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkSabtu.setAlpha(0.5f);
        spinnerJmTpSabtu.setAlpha(0.5f);
    }

    private void spinnerJumatTransformClickableFalse() {
        spinnerJmBkJumat.setClickable(true);
        spinnerJmTpJumat.setClickable(true);
        spinnerJmBkJumat.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpJumat.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkJumat.setAlpha(1.0f);
        spinnerJmTpJumat.setAlpha(1.0f);
    }

    private void spinnerJumatTransformClickableTrue() {
        spinnerJmBkJumat.setClickable(false);
        spinnerJmTpJumat.setClickable(false);
        spinnerJmBkJumat.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpJumat.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkJumat.setAlpha(0.5f);
        spinnerJmTpJumat.setAlpha(0.5f);
    }

    private void spinnerKamisTransformClickableFalse() {
        spinnerJmBkKamis.setClickable(true);
        spinnerJmTpKamis.setClickable(true);
        spinnerJmBkKamis.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpKamis.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkKamis.setAlpha(1.0f);
        spinnerJmTpKamis.setAlpha(1.0f);
    }

    private void spinnerKamisTransformClickableTrue() {
        spinnerJmBkKamis.setClickable(false);
        spinnerJmTpKamis.setClickable(false);
        spinnerJmBkKamis.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpKamis.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkKamis.setAlpha(0.5f);
        spinnerJmTpKamis.setAlpha(0.5f);
    }

    private void spinnerRabuTransformClickableFalse() {
        spinnerJmBkRabu.setClickable(true);
        spinnerJmTpRabu.setClickable(true);
        spinnerJmBkRabu.setAlpha(1.0f);
        spinnerJmTpRabu.setAlpha(1.0f);
        spinnerJmBkRabu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpRabu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
    }

    private void spinnerRabuTransformClickableTrue() {
        spinnerJmBkRabu.setClickable(false);
        spinnerJmTpRabu.setClickable(false);
        spinnerJmBkRabu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpRabu.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkRabu.setAlpha(0.5f);
        spinnerJmTpRabu.setAlpha(0.5f);
    }

    private void spinnerSelasaTransformClickableFalse() {
        spinnerJmBkSelasa.setClickable(true);
        spinnerJmTpSelasa.setClickable(true);
        spinnerJmBkSelasa.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpSelasa.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkSelasa.setAlpha(1.0f);
        spinnerJmTpSelasa.setAlpha(1.0f);
    }

    private void spinnerSelasaTransformClickableTrue() {
        spinnerJmBkSelasa.setClickable(false);
        spinnerJmTpSelasa.setClickable(false);
        spinnerJmBkSelasa.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpSelasa.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkSelasa.setAlpha(0.5f);
        spinnerJmTpSelasa.setAlpha(0.5f);
    }

    private void spinnerSeninTransformClickableFalse() {
        spinnerJmBkSenin.setClickable(true);
        spinnerJmTpSenin.setClickable(true);
        spinnerJmBkSenin.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmTpSenin.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner_checked));
        spinnerJmBkSenin.setAlpha(1.0f);
        spinnerJmTpSenin.setAlpha(1.0f);
    }

    private void spinnerSeninTransformClickableTrue() {
        spinnerJmBkSenin.setClickable(false);
        spinnerJmTpSenin.setClickable(false);
        spinnerJmBkSenin.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmTpSenin.setBackgroundDrawable(getResources().getDrawable(R.drawable.bgspinner));
        spinnerJmBkSenin.setAlpha(0.5f);
        spinnerJmTpSenin.setAlpha(0.5f);
    }

}
