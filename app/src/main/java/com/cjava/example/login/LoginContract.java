package com.cjava.example.login;

import com.cjava.example.base.BasePresenter;
import com.cjava.example.base.BaseView;

/**
 * Created by junior on 01/12/17.
 */

public interface LoginContract {


    interface View extends BaseView<Presenter> {


        void loginSuccess(UserModel userModel);
    }

    interface Presenter extends BasePresenter {

        void loginTradicional(String username, String password);

        void loginFacebook(String access_token);


    }
}
