package com.cjava.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjava.example.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by junior on 01/12/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginContract.View {


    public static final String PUBLIC_PROFILE = "public_profile";
    public static final String EMAIL = "email";

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_login_fb)
    Button btnLoginFb;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_recovery)
    TextView tvRecovery;


    private CallbackManager mCallbackManager;
    private LoginContract.Presenter mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_view);
        ButterKnife.bind(this);


        if (AccessToken.getCurrentAccessToken() != null) {

            Toast.makeText(this, AccessToken.getCurrentAccessToken().getToken(), Toast.LENGTH_SHORT).show();
            AccessToken.setCurrentAccessToken(null);
        }


        mPresenter = new LoginController(this, this);

        mCallbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(mCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                        Toast.makeText(LoginActivity.this, loginResult.getAccessToken().getToken(), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException exception) {

                    }
                });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }


    @OnClick({R.id.btn_login, R.id.btn_login_fb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                mPresenter.loginTradicional(etEmail.getText().toString(), etPassword.getText().toString());

                break;
            case R.id.btn_login_fb:
                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList(PUBLIC_PROFILE, EMAIL));
                break;
        }
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void loginSuccess(UserModel userModel) {

        Toast.makeText(this, "Hola" + userModel.getFirst_name() + " " + userModel.getLast_name(), Toast.LENGTH_SHORT).show();
    }
}
