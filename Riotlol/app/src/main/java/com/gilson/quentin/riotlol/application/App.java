package com.gilson.quentin.riotlol.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by quentin on 10-10-17.
 */

public class App extends Application {

    private static App shared;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        shared = this;

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.start();
    }

    public static App getShared() {
        return shared;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
