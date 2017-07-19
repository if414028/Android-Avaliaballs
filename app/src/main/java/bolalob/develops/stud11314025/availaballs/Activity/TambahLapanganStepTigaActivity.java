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
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.R;
import butterknife.BindView;

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

    @BindView(R.id.spinnerJamBuka)
    Spinner spinnerJamBuka;
    @BindView(R.id.spinnerJamTutup)
    Spinner spinnerJamTutup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lapangan_step_tiga);

        addActionBar();

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
        Intent intent = new Intent(TambahLapanganStepTigaActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
