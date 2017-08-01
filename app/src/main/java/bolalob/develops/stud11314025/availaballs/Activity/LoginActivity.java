package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenter;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenterImp;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginView;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnFocusChange;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.eTEmail)
    EditText etEmail;
    @BindView(R.id.eTPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.txtInputEmail)
    TextInputLayout txtInputEmail;
    @BindView(R.id.iconEmailTextView)
    CustomFontTextView iconemailTV;

    private LoginPresenter presenter;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String USER = "userKey";
    public static final String PASS = "passKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Window window = LoginActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.clrlinedark));
        }

        presenter = new LoginPresenterImp(this);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = etEmail.getText().toString();
                String pass = etPassword.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(USER, user);
                editor.putString(PASS, pass);
                editor.commit();
                presenter.login(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });



    }

    @OnTextChanged(value = R.id.eTEmail, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeEmailTextChanged() {
        final View llemail = findViewById(R.id.layoutUsername);
        llemail.setAlpha(0.5f);
    }

    @OnTextChanged(value = R.id.eTEmail, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onEmailTextChanged() {
        final View llemail = findViewById(R.id.layoutUsername);
        int length = etEmail.getText().length();
        if (length == 0) {
            llemail.setAlpha(0.5f);
        } else llemail.setAlpha(1.0f);
    }

    @OnTextChanged(value = R.id.eTEmail, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterEmailTextChanged() {
        final View llemail = findViewById(R.id.layoutUsername);
        int length = etEmail.getText().length();
        if (length == 0) {
            llemail.setAlpha(0.5f);
        } else llemail.setAlpha(1.0f);
    }

    @OnFocusChange(value = R.id.eTEmail)
    void onEmailFocusChanged(boolean focused) {
        final View llemail = findViewById(R.id.layoutUsername);
        if (!focused) {
            llemail.setAlpha(0.5f);
        } else {
            llemail.setAlpha(1.0f);
        }
    }

    @OnTextChanged(value = R.id.eTPassword, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforePassTextChanged() {
        final View llpass = findViewById(R.id.layoutPassword);
        llpass.setAlpha(0.5f);
    }

    @OnTextChanged(value = R.id.eTPassword, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onPassTextChanged() {
        final View llpass = findViewById(R.id.layoutPassword);
        int length = etPassword.getText().length();
        if (length == 0) {
            llpass.setAlpha(0.5f);
        } else llpass.setAlpha(1.0f);
    }

    @OnTextChanged(value = R.id.eTPassword, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterPassTextChanged() {
        final View llpass = findViewById(R.id.layoutPassword);
        int length = etPassword.getText().length();
        if (length == 0) {
            llpass.setAlpha(0.5f);
        } else llpass.setAlpha(1.0f);
    }

    @OnFocusChange(value = R.id.eTPassword)
    void onPassFocusChanged(boolean focused) {
        final View llpass = findViewById(R.id.layoutPassword);
        if (!focused) {
            llpass.setAlpha(0.5f);
        } else {
            llpass.setAlpha(1.0f);
        }
    }

    @Override
    public void showValidationError() {
        Snackbar snackbar = Snackbar.make(findViewById(R.id.activity_login), "Email atau Password Kosong", Snackbar.LENGTH_LONG)
                .setAction("Action", null);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));

        TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();
    }

    @Override
    public void loginSucess() {
        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);
    }

    @Override
    public void loginError() {
        Snackbar snackbar = Snackbar
                .make(findViewById(R.id.activity_login), "Akun Tidak Terdaftar", Snackbar.LENGTH_SHORT)
                .setAction("Action", null);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSnackbar));

        TextView tv = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        snackbar.show();

    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
//                moveTaskToBack(true);
//                finish();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.gc();
                System.exit(1);
//                finish();
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    //    @Override
//    public void onBackPressed() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
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
//                Toast.makeText(LoginActivity.this, "Anda batal keluar ...", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        AlertDialog alertDialog = alertDialogBuilder.create();
//        alertDialog.show();
//    }


    public void setAlpha(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutUsername);
        layout.setAlpha(1);
    }

}
