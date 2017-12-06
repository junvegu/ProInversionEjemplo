package com.cjava.example.presentation.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.cjava.example.data.local.SessionManager;
import com.cjava.example.presentation.contacts.ActivityListContacts;

/**
 * Created by junior on 05/12/17.
 */

public class SplashActivity extends AppCompatActivity {


    private SessionManager mSessionManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSessionManager = new SessionManager(this);

        if (mSessionManager.isLogin()) {
            Intent intentLoginSucces = new Intent(this, ActivityListContacts.class);
            startActivity(intentLoginSucces);
            finish();
        } else {
            Intent intentNotLogin = new Intent(this, LoginActivity.class);
            startActivity(intentNotLogin);
            finish();
        }

    }
}
