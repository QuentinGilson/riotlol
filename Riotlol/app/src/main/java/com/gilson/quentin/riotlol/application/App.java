package com.gilson.quentin.riotlol.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by quentin on 10-10-17.
 */

public class App extends Application {

    private static App shared;
    private RequestQueue requestQueue;
    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();

        shared = this;

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.start();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        realm = Realm.getInstance(realmConfiguration);
    }

    public static App getShared() {
        return shared;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public Realm getRealm() {
        return realm;
    }
}
