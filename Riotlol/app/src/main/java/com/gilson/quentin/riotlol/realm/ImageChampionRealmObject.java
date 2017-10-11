package com.gilson.quentin.riotlol.realm;

import android.util.Log;

import com.gilson.quentin.riotlol.model.ImageChampion;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 10-10-17.
 */

public class ImageChampionRealmObject extends RealmObject {
    @PrimaryKey
    private String full;
    private String group;
    private String sprite;

    public ImageChampionRealmObject(ImageChampion imageChampion) {
        this.full = imageChampion.getFull();
        this.group = imageChampion.getGroup();
        this.sprite = imageChampion.getSprite();
    }

    public ImageChampionRealmObject() {

    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }
}
