package com.gilson.quentin.riotlol.realm;

import com.gilson.quentin.riotlol.model.ImageSummonerSpell;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 11-10-17.
 */

public class ImageSummonerSpellRealmObject extends RealmObject {
    @PrimaryKey
    private String full;

    public ImageSummonerSpellRealmObject() {

    }

    public ImageSummonerSpellRealmObject(ImageSummonerSpell imageSummonerSpell) {
        this.full = imageSummonerSpell.getFull();
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
