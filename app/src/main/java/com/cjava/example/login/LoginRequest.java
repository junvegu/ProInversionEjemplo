package com.cjava.example.login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by junior on 01/12/17.
 */

public interface LoginRequest {

    @GET("me?fields=id,name,first_name,last_name,picture,email,gender")
    Call<UserModel> loginWithFacebook(@Query("access_token") String token);
}
