package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
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
    @BindView(R.id.iconHargaSelasaAdd)
    CustomFontTextView iconHargaSelasaAdd;
    @BindView(R.id.iconHargaRabuAdd)
    CustomFontTextView iconHargaRabuAdd;
    @BindView(R.id.iconHargaKamisAdd)
    CustomFontTextView iconHargaKamisAdd;
    @BindView(R.id.iconHargaJumatAdd)
    CustomFontTextView iconHargaJumatAdd;
    @BindView(R.id.iconHargaSabtuAdd)
    CustomFontTextView iconHargaSabtuAdd;
    @BindView(R.id.iconHargaMingguAdd)
    CustomFontTextView iconHargaMingguAdd;

    @OnClick(R.id.btnSimpanHargaPerJam)
    void Updateharga() {
        this.finish();
    }

    @OnClick(R.id.iconHargaMingguAdd)
    void AddHargaMinggu() {
        addViewMinggu();
        iconHargaMingguAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaSabtuAdd)
    void AddHargaSabtu() {
        addViewSabtu();
        iconHargaSabtuAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaJumatAdd)
    void AddHargaJumat() {
        addViewJumat();
        iconHargaJumatAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaKamisAdd)
    void AddHargaKamis() {
        addViewKamis();
        iconHargaKamisAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaRabuAdd)
    void AddHargaRabu() {
        addViewRabu();
        iconHargaRabuAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaSelasaAdd)
    void AddHargaSelasa() {
        addViewSelasa();
        iconHargaSelasaAdd.setVisibility(View.GONE);
    }

    @OnClick(R.id.iconHargaSeninAdd)
    void AddHargaSenin() {
        addViewSenin();
        iconHargaSeninAdd.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_harga_per_jam);
        ButterKnife.bind(this);
        setActionBarOntheTop();
        setStatusBarColor();
    }

    private void addViewMinggu() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lyMinggu);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewMinggu();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaMingguAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewSabtu() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lySabtu);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewSabtu();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaSabtuAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewJumat() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lyJumat);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewJumat();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaJumatAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewKamis() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lyKamis);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewKamis();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaKamisAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewRabu() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lyRabu);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewRabu();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaRabuAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewSelasa() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lySelasa);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewSelasa();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaSelasaAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
            }
        });
    }

    private void addViewSenin() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout parent = (LinearLayout) findViewById(R.id.lySenin);
        final View rowView = inflater.inflate(R.layout.list_editharga, null);
        parent.addView(rowView);
        CustomFontTextView btnAdd = ButterKnife.findById(rowView, R.id.iconHargaAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();

                int maxHarga = 6;

                if (count < maxHarga) {
                    addViewSenin();
                } else {
                    Toast.makeText(getApplicationContext(), "Hanya dapat menambahkan 3 Harga tambahan", Toast.LENGTH_LONG).show();
                }
            }
        });
        CustomFontTextView btnRemove = ButterKnife.findById(rowView, R.id.iconHargaRemove);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = parent.getChildCount();
                int maxChild = 4;

                if (count == maxChild) {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    iconHargaSeninAdd.setVisibility(View.VISIBLE);
                } else {
                    ((LinearLayout) rowView.getParent()).removeView(rowView);
                    count--;
                }
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
