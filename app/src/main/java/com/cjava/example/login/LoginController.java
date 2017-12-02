package com.cjava.example.login;

import android.content.Context;
import android.util.Log;

import com.facebook.login.Login;

/**
 * Created by junior on 01/12/17.
 */

public class LoginController implements LoginContract.Presenter {



    private LoginContract.View mView;
    private Context mContext;

    public LoginController(LoginContract.View mView, Context mContext) {
        this.mView = mView;
        this.mContext = mContext;
        this.mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void loginTradicional(String username, String password) {

        //Consulta al Api


        mView.loginSuccess(new UserModel("JUAN","PEREZ"));




    }

    @Override
    public void loginFacebook(String access_token) {
        mView.loginSuccess(new UserModel("JUAN","PEREZ"));



    }
}
