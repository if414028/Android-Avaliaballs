package bolalob.develops.stud11314025.availaballs.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenter;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginPresenterImp;
import bolalob.develops.stud11314025.availaballs.LoginMVP.LoginView;
import bolalob.develops.stud11314025.availaballs.R;
import bolalob.develops.stud11314025.availaballs.Widget.CustomFontTextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.eTEmail)
    EditText etEmail;
    @BindView(R.id.eTPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLgn;
    @BindView(R.id.textInputEmail)
    TextInputLayout txtinputEmail;
    @BindView(R.id.iconEmailTextView)
    CustomFontTextView iconemailTV;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Window window = LoginActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
        }

        presenter = new LoginPresenterImp(this);

        btnLgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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

    public void setAlpha(View view) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutUsername);
        layout.setAlpha(1);
    }

}
