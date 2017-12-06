package com.cjava.example.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.cjava.example.model.UserModel;
import com.google.gson.Gson;

/**
 * Created by junior on 05/12/17.
 */

public class SessionManager {


    private static final String  PREFERENCE_NAME = "ProinversionPreferences";
    private static int ACCESS_MODE = 0;


    public static final String  USER_DATA = "user";
    public static final String  IS_LOGIN = "is_login";
    public static final String  USER_TOKEN = "user_token";




    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;


    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCE_NAME, ACCESS_MODE);
        editor = preferences.edit();
    }


    public void openSession(UserModel user) {
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }


    public void closeSession() {
        editor.putBoolean(IS_LOGIN, false);
        editor.commit();
    }


    public boolean isLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }



    public void setUser(UserModel userEntity) {
        if (userEntity != null) {
            Gson gson = new Gson();
            String user = gson.toJson(userEntity);
            editor.putString(USER_DATA, user);
        }
        editor.commit();
    }

    public UserModel getUserEntity() {
        String userData = preferences.getString(USER_DATA, null);
        return new Gson().fromJson(userData, UserModel.class);
    }

}
