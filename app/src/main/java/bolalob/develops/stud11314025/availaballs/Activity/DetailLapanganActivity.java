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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        setActionbar();
        getDataNamaLap();
        getDataLokLap();
        getDataPhoto();
        getDataPhoneNum();
        getDataJumlahLap();
        getDataPrice();
        getDataOpenHour();
        getDataCloseHour();
        setTextTv();
        setCollapsingActionBar();
        setImageGlideinAppbar();
        setStatusBarColor();
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
    }

    private void setStatusBarColor() {
        Window window = DetailLapanganActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    private void setTextTv() {
        tvNmLap.setText(getDataNamaLap());
        tvOpenHour.setText(getDataOpenHour());
        tvCloseHour.setText(getDataCloseHour());
        tvAlmt.setText(getDataLokLap());
        tvNoHp.setText(getDataPhoneNum());
        tvJmlhLap.setText(getDataJumlahLap());
        tvHrg.setText("Rp." + getDataPrice());
    }

    private String getDataCloseHour() {
        Intent intent = this.getIntent();
        String closehour = intent.getExtras().getString("CLOSEHOUR_KEY");
        return closehour;

    }

    private String getDataOpenHour() {
        Intent intent = this.getIntent();
        String openhour = intent.getExtras().getString("OPENHOUR_KEY");
        return openhour;

    }

    private String getDataPrice() {
        Intent intent = this.getIntent();
        String price = intent.getExtras().getString("PRICE_KEY");
        return price;
    }

    private String getDataJumlahLap() {
        Intent intent = this.getIntent();
        String jmlhlap = intent.getExtras().getString("JUMLAHLAP_KEY");
        return jmlhlap;
    }

    private String getDataPhoneNum() {
        Intent intent = this.getIntent();
        String phonenum = intent.getExtras().getString("PHONENUM_KEY");
        return phonenum;
    }

    private String getDataLokLap() {
        Intent intent = this.getIntent();
        String loklap = intent.getExtras().getString("LOKASI_KEY");
        return loklap;
    }

    private String getDataPhoto() {
        Intent intent = this.getIntent();
        String photo = intent.getExtras().getString("PHOTO_KEY");
        return photo;
    }

    private void setImageGlideinAppbar() {
        Glide.with(getApplicationContext())
                .load(getDataPhoto())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        loadingImage.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        loadingImage.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(appbarimage);
    }

    private void setCollapsingActionBar() {
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
                    collapsingToolbarLayout.setTitle(getDataNamaLap());
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.clrpressed));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
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
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public String getDataNamaLap() {
        Intent intent = this.getIntent();
        final String namalap = intent.getExtras().getString("NAMALAP_KEY");
        return namalap;
    }
}
