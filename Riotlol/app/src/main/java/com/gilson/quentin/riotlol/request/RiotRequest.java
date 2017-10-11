package com.gilson.quentin.riotlol.request;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.gilson.quentin.riotlol.application.App;
import com.gilson.quentin.riotlol.model.Champion;
import com.gilson.quentin.riotlol.model.ChampionList;
import com.gilson.quentin.riotlol.model.ItemList;
import com.gilson.quentin.riotlol.model.MatchStats;
import com.gilson.quentin.riotlol.model.PlayerResult;
import com.gilson.quentin.riotlol.model.RecentMatchResult;
import com.gilson.quentin.riotlol.model.SummonerSpellList;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;

/**
 * Created by quentin on 10-10-17.
 */

public class RiotRequest {

    public final static String API_KEY = "RGAPI-0cacdb78-3437-4d39-b528-323fda609de8";

    public interface PlayerInfoListener{
        void didReceivePlayerInfo(PlayerResult result);
        void didFail();
    }

    public interface RecentMatchListener{
        void didReceiveRecentMatch(RecentMatchResult result);
        void didFail();
    }

    public interface MatchStatsListener{
        void didReceiveMatchStats(MatchStats matchStats);
        void didFail();
    }

    public interface ChampionListener {
        void didReceiveChampion(ChampionList championList);
        void didFail();
    }

    public interface SummonerSpellListener {
        void didReceiveSummonerSpell(SummonerSpellList summonerSpellList);
        void didFail();
    }

    public interface ItemListener {
        void didReceiveItem(ItemList itemList);
        void didFail();
    }

    public static void getPlayerInfo(final PlayerInfoListener playerInfoListener, String name){

        String url = "https://euw1.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key="+API_KEY;

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
        String url = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/"+id+"/recent?api_key="+API_KEY;

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

    public static void getMatchStats(final MatchStatsListener listener, String id) {

        String url = "https://euw1.api.riotgames.com/lol/match/v3/matches/"+id+"?api_key="+API_KEY;

        JacksonRequest<MatchStats> request = new JacksonRequest<MatchStats>(Request.Method.GET, url, new JacksonRequestListener<MatchStats>() {
            @Override
            public void onResponse(MatchStats response, int statusCode, VolleyError error) {
                if(listener!=null){
                    if(response!=null){
                        listener.didReceiveMatchStats(response);
                    }else{
                        listener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(MatchStats.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }

    public static void getChampion(final ChampionListener listener) {

        String url = "https://euw1.api.riotgames.com/lol/static-data/v3/champions/?api_key="+API_KEY+"&tags=image";

        JacksonRequest<ChampionList> request = new JacksonRequest<ChampionList>(Request.Method.GET, url, new JacksonRequestListener<ChampionList>() {
            @Override
            public void onResponse(ChampionList response, int statusCode, VolleyError error) {
                if(listener!=null){
                    if(response!=null){
                        listener.didReceiveChampion(response);
                    }else{
                        listener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(ChampionList.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }

    public static void getSummonerSpell(final SummonerSpellListener listener) {

        String url = "https://euw1.api.riotgames.com/lol/static-data/v3/summoner-spells/?api_key="+API_KEY+"&tags=image";

        JacksonRequest<SummonerSpellList> request = new JacksonRequest<SummonerSpellList>(Request.Method.GET, url, new JacksonRequestListener<SummonerSpellList>() {
            @Override
            public void onResponse(SummonerSpellList response, int statusCode, VolleyError error) {
                if(listener!=null){
                    if(response!=null){
                        listener.didReceiveSummonerSpell(response);
                    }else{
                        listener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(SummonerSpellList.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }

    public static void getItem(final ItemListener listener) {

        String url = "https://euw1.api.riotgames.com/lol/static-data/v3/items/?api_key="+API_KEY+"&tags=image";

        JacksonRequest<ItemList> request = new JacksonRequest<ItemList>(Request.Method.GET, url, new JacksonRequestListener<ItemList>() {
            @Override
            public void onResponse(ItemList response, int statusCode, VolleyError error) {
                if(listener!=null){
                    if(response!=null){
                        listener.didReceiveItem(response);
                    }else{
                        listener.didFail();
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.constructUnsafe(ItemList.class);
            }
        });

        App.getShared().getRequestQueue().add(request);
    }
}
