package bolalob.develops.stud11314025.availaballs.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
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

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Adapter.RecyclerViewAdapter;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Service.API;
import bolalob.develops.stud11314025.availaballs.Service.Service;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter adapter;
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


    public static final String USER = "userKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setActionbar();
        setStatusBarColor();
        progressBar.setVisibility(View.VISIBLE);
        consumeAPIListLapngan();
    }

    private void consumeAPIListLapngan() {
        API client = Service.createService(API.class);
        Call<List<Lapangan>> call = client.getAllLapangan();
        call.enqueue(new Callback<List<Lapangan>>() {
            @Override
            public void onResponse(Call<List<Lapangan>> call, Response<List<Lapangan>> response) {
                progressBar.setVisibility(View.GONE);
                List<Lapangan> repos = response.body();
                adapter = new RecyclerViewAdapter(MainActivity.this, repos);
                layoutManager = new LinearLayoutManager(MainActivity.this);
                rvView.setLayoutManager(layoutManager);
                rvView.setAdapter(adapter);
                if (repos.isEmpty()) {
                    viewEmpty();
                } else {
                    viewnotEmpty();
                }


            }

            @Override
            public void onFailure(Call<List<Lapangan>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setActionbar() {
        SharedPreferences sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        String user = sharedpreferences.getString(USER, "-");
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(this);
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        TextView mTitleTextView = (TextView) mCustomView.findViewById(R.id.title_text_centered);
        mTitleTextView.setText("List Lapangan" + " Login By " + user);

        mActionBar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.clrNavigation)));
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
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
                SharedPreferences sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnCncl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Anda batal keluar ...", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });



//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//        View dialogView = getLayoutInflater().inflate(R.layout.alert_dialog_logout,null);
//        alertDialogBuilder.setMessage("Are you Sure want to Logout?");
//        alertDialogBuilder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                SharedPreferences sharedpreferences = getSharedPreferences(LoginActivity.MyPREFERENCES, Context.MODE_PRIVATE);
//                SharedPreferences.Editor editor = sharedpreferences.edit();
//                editor.clear();
//                editor.commit();
//                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//
//        alertDialogBuilder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "Anda batal keluar ...", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
    }

    private RecyclerView.OnScrollListener recyclerViewOnScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

    };
}