package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.IcEditHariJam)
    CustomFontTextView IcEditJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        IcEditJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),UpdateJamBukaActivity.class);
                startActivity(intent);
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);;
        }

        Intent intent = this.getIntent();
        final String namalap = intent.getExtras().getString("NAMALAP_KEY");
        String loklap = intent.getExtras().getString("LOKASI_KEY");
        String photo = intent.getExtras().getString("PHOTO_KEY");
        String phonenum = intent.getExtras().getString("PHONENUM_KEY");
        String jmlhlap = intent.getExtras().getString("JUMLAHLAP_KEY");
        String price = intent.getExtras().getString("PRICE_KEY");
        String openhour = intent.getExtras().getString("OPENHOUR_KEY");
        String closehour = intent.getExtras().getString("CLOSEHOUR_KEY");
        tvNmLap.setText(namalap);
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
                    collapsingToolbarLayout.setTitle(namalap);
                    collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.clrpressed));
                    isShow = true;
                } else if(isShow) {
                    collapsingToolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
        Glide.with(getApplicationContext())
                .load(photo)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(appbarimage);
        tvOpenHour.setText(openhour);
        tvCloseHour.setText(closehour);
        tvAlmt.setText(loklap);
        tvNoHp.setText(phonenum);
        tvJmlhLap.setText(jmlhlap);
        tvHrg.setText("Rp." + price);
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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                navigateUpTo(new Intent(this, MainActivity.class));
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void updatejambuka(View view) {

    }


}
