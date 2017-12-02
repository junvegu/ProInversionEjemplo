package com.cjava.example.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.cjava.example.base.ServiceFactory;
import com.facebook.AccessToken;
import com.facebook.login.Login;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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


        LoginRequest loginService =
                ServiceFactory.createService(LoginRequest.class);

        Call<UserModel> call = loginService.loginWithFacebook(access_token);

        mView.setLoadingIndicator(true);


        call.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(@NonNull Call<UserModel> call, @NonNull Response<UserModel> response) {

                //Respuesta Exitosa


                mView.setLoadingIndicator(false);

                if (response.isSuccessful()){
                    // 200,2001,204 ....

                    mView.loginSuccess(response.body());

                }else{
                    //404,401
                    mView.showErrorMessage("Ocurrió un error");
                }

            }

            @Override
            public void onFailure(@NonNull Call<UserModel> call, @NonNull Throwable t) {

                mView.setLoadingIndicator(false);

                //Servidor no responde

                mView.showErrorMessage("Error desconocido");
            }
        });

    }
}
