package com.gilson.quentin.riotlol.realm;

import com.gilson.quentin.riotlol.application.App;

import io.realm.Realm;

/**
 * Created by quentin on 10-10-17.
 */

public class RealmManager {

    private static RealmManager realmManager;
    private Realm realm = App.getShared().getRealm();

    public static RealmManager getRealmManager(){
        if(realmManager==null){
            realmManager = new RealmManager();
        }
        return realmManager;
    }

    public void addChampion(ChampionRealmObject champion){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(champion);
        realm.commitTransaction();
    }

    public int getNumberOfChampion(){
        return realm.where(ChampionRealmObject.class).findAll().size();
    }

    public ChampionRealmObject getChampion(int id) {
        return realm.where(ChampionRealmObject.class).equalTo("id",id).findFirst();
    }

    public void addSummonerSpell(SummonerSpellRealmObject summonerSpellRealmObject) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(summonerSpellRealmObject);
        realm.commitTransaction();
    }

    public SummonerSpellRealmObject getSummonerSpell(int id) {
        return realm.where(SummonerSpellRealmObject.class).equalTo("id",id).findFirst();
    }

    public void addItem(ItemRealmObject itemRealmObject) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(itemRealmObject);
        realm.commitTransaction();
    }

    public ItemRealmObject getItem(int id) {
        return realm.where(ItemRealmObject.class).equalTo("id",id).findFirst();
    }

    public void createSavedUser(SavedUser user){
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
    }

    public void updateSavedUserNewName(String name) {
        realm.beginTransaction();
        getSavedUser().setNewName(name);
        realm.commitTransaction();
    }

    public void updateSavedUserName(String name) {
        realm.beginTransaction();
        getSavedUser().setName(name);
        realm.commitTransaction();
    }

    public SavedUser getSavedUser(){
        return realm.where(SavedUser.class).findFirst();
    }
}
