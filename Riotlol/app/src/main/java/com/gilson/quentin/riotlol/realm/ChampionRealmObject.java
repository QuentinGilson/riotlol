package com.gilson.quentin.riotlol.realm;

import com.gilson.quentin.riotlol.model.Champion;
import com.gilson.quentin.riotlol.model.ImageChampion;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 10-10-17.
 */

public class ChampionRealmObject extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private ImageChampionRealmObject image;

    public ChampionRealmObject(Champion champion){
        this.id = champion.getId();
        this.name = champion.getName();
        this.image = new ImageChampionRealmObject(champion.getImage());
    }

    public ChampionRealmObject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageChampionRealmObject getImage() {
        return image;
    }

    public void setImage(ImageChampionRealmObject image) {
        this.image = image;
    }
}
