package com.cjava.example;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by junior on 11/12/17.
 */

public class ProinversionApp extends Application {


    private static final String REALM_NAME = "Proinversion.realm";

    private static final int REALM_SCHEMA_VERSION = 1;
    @Override
    public void onCreate() {
        super.onCreate();


        Realm.init(this);
        Realm.setDefaultConfiguration(getRealmConfiguration());


    }

    public static RealmConfiguration getRealmConfiguration() {
        return new RealmConfiguration.Builder()
                .name(ProinversionApp.REALM_NAME)
                .schemaVersion(ProinversionApp.REALM_SCHEMA_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

}
