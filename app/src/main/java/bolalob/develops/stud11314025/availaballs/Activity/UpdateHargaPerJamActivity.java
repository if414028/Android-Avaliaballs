package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UpdateHargaPerJamActivity extends AppCompatActivity {

    @BindView(R.id.lySenin)
    LinearLayout lySenin;

    @BindView(R.id.iconHargaSeninAdd)
    CustomFontTextView iconHargaSeninAdd;


    @OnClick(R.id.btnSimpanHargaPerJam)
    void Updateharga() {
        this.finish();
    }

    @OnClick(R.id.iconHargaSeninAdd)
    void AddHargaSenin() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout parent = (LinearLayout) findViewById(R.id.lySenin);
        View tv = inflater.inflate(R.layout.list_editharga, null);

        int count = parent.getChildCount();

        int maxHarga = 6;

        if (count < maxHarga) {
            parent.addView(tv);
        } else {
            Toast.makeText(lySenin.getContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_harga_per_jam);
        ButterKnife.bind(this);
        setActionBarOntheTop();
        setStatusBarColor();

       final View tv = LayoutInflater.from(this).inflate(R.layout.list_editharga, null);
        CustomFontTextView iconRemove = ButterKnife.findById(tv, R.id.iconHargaRemove);
        CustomFontTextView iconAdd = (CustomFontTextView) tv.findViewById(R.id.iconHargaAdd);
        iconRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((LinearLayout) tv.getParent()).removeView(tv);
            }
        });
        iconAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddHargaSenin();
            }
        });
    }
    private void setStatusBarColor() {
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    private void setActionBarOntheTop() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("Pengaturan Harga");

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
}
