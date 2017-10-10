package com.gilson.quentin.riotlol.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.gilson.quentin.riotlol.application.App;
import com.gilson.quentin.riotlol.model.PlayerResult;
import com.gilson.quentin.riotlol.model.RecentMatchResult;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

/**
 * Created by quentin on 10-10-17.
 */

public class RiotRequest {

    public interface PlayerInfoListener{
        void didReceivePlayerInfo(PlayerResult result);
        void didFail();
    }

    public interface RecentMatchListener{
        void didReceiveRecentMatch(RecentMatchResult result);
        void didFail();
    }

    public static void getPlayerInfo(final PlayerInfoListener playerInfoListener, String name){

        String url = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key=RGAPI-d64dd51f-43f8-4538-924d-71cf15f8c8a7";

        JacksonRequest<PlayerResult> request = new JacksonRequest<PlayerResult>(Request.Method.GET, url, new JacksonRequestListener<PlayerResult>() {
            @Override
            public void onResponse(PlayerResult response, int statusCode, VolleyError error) {
                if(playerInfoListener!=null){
                    if(response!=null){
                        playerInfoListener.didReceivePlayerInfo(response);
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

    public static void getRecentMatch(final RecentMatchListener listener, String id) {
        String url = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/"+id+"/recent?api_key=RGAPI-d64dd51f-43f8-4538-924d-71cf15f8c8a7";

        JacksonRequest<RecentMatchResult> request = new JacksonRequest<RecentMatchResult>(Request.Method.GET, url, new JacksonRequestListener<RecentMatchResult>() {
            @Override
            public void onResponse(RecentMatchResult response, int statusCode, VolleyError error) {
                if(listener!=null){
                    if(response!=null){
                        listener.didReceiveRecentMatch(response);
                    }else{
                        listener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(RecentMatchResult.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }

}
