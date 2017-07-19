package bolalob.develops.stud11314025.availaballs.LoginMVP;

import android.text.TextUtils;

/**
 * Created by Okta on 03/07/2017.
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            loginView.showValidationError();
        } else {
            if (username.equals("admin") && password.equals("admin")) {
                loginView.loginSucess();
            } else {
                loginView.loginError();
            }

        }
    }
}
