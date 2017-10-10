package com.gilson.quentin.riotlol.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.gilson.quentin.riotlol.application.App;
import com.gilson.quentin.riotlol.model.PlayerResult;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

/**
 * Created by quentin on 10-10-17.
 */

public class RiotRequest {

    public interface PlayerInfoListener{
        void didReceivePlayerInfo(String name);
        void didFail();
    }

    public static void getPlayerInfo(final PlayerInfoListener playerInfoListener, String name){

        String url = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key=RGAPI-d64dd51f-43f8-4538-924d-71cf15f8c8a7";

        JacksonRequest<PlayerResult> request = new JacksonRequest<PlayerResult>(Request.Method.GET, url, new JacksonRequestListener<PlayerResult>() {
            @Override
            public void onResponse(PlayerResult response, int statusCode, VolleyError error) {
                if(playerInfoListener!=null){
                    if(response!=null){
                        playerInfoListener.didReceivePlayerInfo(response.getName());
                    } else {
                        playerInfoListener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(PlayerResult.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }

}
