package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.Model.LapanganDetailResult;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.APIDetailLapangan;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLapanganActivity extends AppCompatActivity {

    @BindView(R.id.TvHarga)
    TextView tvHrg;
    @BindView(R.id.TvNoHp)
    TextView tvNoHp;
    @BindView(R.id.TvAlamat)
    TextView tvAlmt;
    @BindView(R.id.TvJlhLpng)
    TextView tvJmlhLap;
    @BindView(R.id.TvNamaLap)
    TextView tvNmLap;
    @BindView(R.id.TvJamOpen)
    TextView tvOpenHour;
    @BindView(R.id.TvJamClose)
    TextView tvCloseHour;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar_image)
    ImageView appbarimage;
    @BindView(R.id.placeholder_image)
    ImageView loadingImage;
    @BindView(R.id.IcEditHariJam)
    CustomFontTextView IcEditJam;
    @BindView(R.id.btnEditLapangan)
    CustomFontTextView IcEditNamaLapangan;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.btnEditHarga)
    CustomFontTextView btnEHarga;

    int id = 32;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionbar();
        setStatusBarColor();
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle(" ");
        IcEditJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJm = new Intent(DetailLapanganActivity.this, UpdateJamBukaActivity.class);
                startActivity(intentJm);
            }
        });
        IcEditNamaLapangan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentJm = new Intent(DetailLapanganActivity.this, UpdateNamaAlamatLapanganActivity.class);
                startActivity(intentJm);
            }
        });
        btnEHarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentHr = new Intent(getApplicationContext(), UpdateHargaPerJamActivity.class);
                startActivity(intentHr);
            }
        });

        consumeAPILapangan();
    }

    private void setStatusBarColor() {
        Window window = DetailLapanganActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    public void consumeAPILapangan() {
        APIDetailLapangan client = Service.createService(APIDetailLapangan.class);
        Call<LapanganDetailResult> call = client.getLapangan(id);
        call.enqueue(new Callback<LapanganDetailResult>() {
            @Override
            public void onResponse(Call<LapanganDetailResult> call, Response<LapanganDetailResult> response) {
                LapanganDetailResult lapangan = response.body();
                String namaLapangan = lapangan.object.getFieldName();
                String nomorTelepon = lapangan.object.getPhone();
                String jumlahLapangan = lapangan.object.getNumberOfField().toString();
                String alamatLapangan = lapangan.object.getDetailLocation();
                String jamBuka = lapangan.object.getOpeningHours();
                String jamTutup = lapangan.object.getClosingHours();
                String hargaNormal = lapangan.object.getPrice();

                tvNmLap.setText(namaLapangan);
                tvNoHp.setText(nomorTelepon);
                tvJmlhLap.setText(jumlahLapangan);
                tvOpenHour.setText(jamBuka);
                tvCloseHour.setText(jamTutup);
                tvHrg.setText("Rp. " + hargaNormal);
                tvAlmt.setText(alamatLapangan);

                setCollapsingActionBar(namaLapangan);
            }

            @Override
            public void onFailure(Call<LapanganDetailResult> call, Throwable t) {

            }
        });
    }

    private void setActionbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);

        }
    }

    @Override
    public void onBackPressed() {
        this.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setCollapsingActionBar(final String namaLapangan) {
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.setTitle(namaLapangan);
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.clrpressed));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
        return;
    }
}
