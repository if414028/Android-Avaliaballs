package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.Adapter.RecyclerViewAdapterLapangan;

import bolalob.develops.stud11314025.availaballs.Model.LapanganResult;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.LapanganService;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import bolalob.develops.stud11314025.availaballs.Widget.SharePreferencesManager;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapterLapangan adapter;
    private RecyclerView.LayoutManager layoutManager;

    @BindView(R.id.rv_main)
    RecyclerView rvView;
    @BindView(R.id.emptyText)
    TextView emptyview;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.button1)
    Button btn1;
    @BindView(R.id.button2)
    Button btn2;
    @BindView(R.id.button3)
    Button btn3;
    @BindView(R.id.button4)
    Button btn4;
    @BindView(R.id.button5)
    Button btn5;
    @BindView(R.id.TextNo)
    TextView LabelNo;
    @BindView(R.id.TextNamaLapangan)
    TextView LabelNamaLap;
    @BindView(R.id.customFontTextView)
    CustomFontTextView LabelLokasi;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    private Context getContext() {
        return MainActivity.this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setActionbar();
        setStatusBarColor();
        progressBar.setVisibility(View.VISIBLE);
        consumeAPIListLapngan("1");

    }

    private void consumeAPIListLapngan(String pagenum) {
        LapanganService client = Service.createService(LapanganService.class);
        Call<LapanganResult> call = client.getAllLapangan(pagenum);
        call.enqueue(new Callback<LapanganResult>() {
            @Override
            public void onResponse(Call<LapanganResult> call, Response<LapanganResult> response) {
                progressBar.setVisibility(View.GONE);
                LapanganResult repos = response.body();
                final int currentPage = repos.getCurrentPage();
                final int nextPage = currentPage + 1;
                final int totalPage = repos.getTotalPage();
                adapter = new RecyclerViewAdapterLapangan();
                adapter.setLapangan(repos.object);
                layoutManager = new LinearLayoutManager(MainActivity.this);
                rvView.setLayoutManager(layoutManager);
                rvView.setAdapter(adapter);
                btn1.setVisibility(totalPage >= 1 ? View.VISIBLE : View.GONE);
                btn2.setVisibility(totalPage >= 2 ? View.VISIBLE : View.GONE);
                btn3.setVisibility(totalPage >= 3 ? View.VISIBLE : View.GONE);
                btn4.setVisibility(totalPage >= 4 ? View.VISIBLE : View.GONE);
                btn5.setVisibility(totalPage >= 5 ? View.VISIBLE : View.GONE);
                if (currentPage == totalPage || currentPage == totalPage - 1){
                    btn1.setText("1");
                    btn2.setText("2");
                }else if (btn2.getText()==Integer.toString(totalPage-3)){
                    btn1.setText("...");
                    btn2.setText(Integer.toString(totalPage-3));
                    btn3.setText(Integer.toString(totalPage-2));
                }else{
                    btn1.setText(Integer.toString(currentPage));
                    btn2.setText(Integer.toString(currentPage + 1));
                }
                btn1.setText(currentPage == totalPage || currentPage == totalPage - 1 ? "1" : Integer.toString(currentPage));
                btn2.setText(currentPage == totalPage || currentPage == totalPage - 1 ? "2" : Integer.toString(currentPage + 1));
                btn5.setText(Integer.toString(totalPage));
                btn4.setText(Integer.toString(totalPage - 1));
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = btn2.getText().toString();
                        int finalValue = Integer.parseInt(value) - 1;
                        if (finalValue < totalPage - 4) {
                            btn1.setText(finalValue == totalPage - 5 ? "..." : Integer.toString(finalValue + 1));
                            btn2.setText(Integer.toString(finalValue + 2));
                            btn3.setText(finalValue == totalPage - 5 ? Integer.toString(finalValue + 3) : "...");
                        } else if (btn3.getText() == "...") {
                            btn1.setText("...");
                        } else {
                            adapter.clear();
                            consumeAPIListLapngan(btn3.getText().toString());
                        }
                    }
                });
                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (btn1.getText() == "...") {
                            btn3.setText("...");
                            btn1.setText(Integer.toString(currentPage));
                            btn2.setText(Integer.toString(currentPage + 1));
                        } else {
                            adapter.clear();
                            consumeAPIListLapngan(btn1.getText().toString());
                        }
                    }
                });

                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.clear();
                        consumeAPIListLapngan(btn2.getText().toString());
                        btn1.setText(Integer.toString(currentPage - 1));
                        btn3.setText(btn2.getText() == Integer.toString(totalPage - 3) ? Integer.toString(currentPage + 1) : "...");                        ;
                    }
                });

                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.clear();
                        consumeAPIListLapngan(btn4.getText().toString());
                    }
                });
                btn5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.clear();
                        consumeAPIListLapngan(btn5.getText().toString());
                        btn1.setText("1");
                        btn2.setText("2");
                        btn3.setText("...");
                    }
                });
                if (repos.object.isEmpty()) {
                    viewEmpty();
                } else {
                    viewnotEmpty();
                }
            }


            @Override
            public void onFailure(Call<LapanganResult> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT);
            }
        });
    }

    @OnClick(R.id.buttonBottom)
    void byMap() {
        Intent intent = new Intent(MainActivity.this, TambahLapanganActivity.class);
        startActivity(intent);
    }

    private void setActionbar() {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar_home, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text);
        mTitleTextView.setText("List Lapangan");
        CustomFontTextView iconLogout = ButterKnife.findById(mCustomView, R.id.iconOlogout);
        iconLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

        actionActioBar(mCustomView);
    }

    private void actionActioBar(View actionbarView) {
        CustomFontTextView txtMap = ButterKnife.findById(actionbarView, R.id.iconByMap);
        txtMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocationByMapActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setStatusBarColor() {
        Window window = MainActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrNavigation));
        }
    }

    private void viewnotEmpty() {
        imageView.setVisibility(View.GONE);
        rvView.setVisibility(View.VISIBLE);
        emptyview.setVisibility(View.GONE);
        btn1.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        btn3.setVisibility(View.VISIBLE);
        btn4.setVisibility(View.VISIBLE);
        btn5.setVisibility(View.VISIBLE);
        LabelLokasi.setVisibility(View.VISIBLE);
        LabelNo.setVisibility(View.VISIBLE);
        LabelNamaLap.setVisibility(View.VISIBLE);
    }

    private void viewEmpty() {
        rvView.setVisibility(View.GONE);
        imageView.setVisibility(View.VISIBLE);
        emptyview.setVisibility(View.VISIBLE);
        btn1.setVisibility(View.GONE);
        btn2.setVisibility(View.GONE);
        btn3.setVisibility(View.GONE);
        btn4.setVisibility(View.GONE);
        btn5.setVisibility(View.GONE);
        LabelLokasi.setVisibility(View.GONE);
        LabelNo.setVisibility(View.GONE);
        LabelNamaLap.setVisibility(View.GONE);
    }

    public void tambahLapangan(View view) {
        Intent intent = new Intent(MainActivity.this, TambahLapanganActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        final View dialogView = getLayoutInflater().inflate(R.layout.alert_dialog_logout, null);
        Button btnLgout = (Button) dialogView.findViewById(R.id.btnLogout);
        Button btnCncl = (Button) dialogView.findViewById(R.id.btnCancel);

        alertDialogBuilder.setView(dialogView);
        final AlertDialog dialog = alertDialogBuilder.create();
        dialog.show();


        btnLgout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharePreferencesManager.logout(getContext());
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}