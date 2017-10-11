package com.gilson.quentin.riotlol.realm;

import com.gilson.quentin.riotlol.model.SummonerSpell;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 11-10-17.
 */

public class SummonerSpellRealmObject extends RealmObject {
    @PrimaryKey
    private int id;
    private ImageSummonerSpellRealmObject image;

    public SummonerSpellRealmObject() {

    }

    public SummonerSpellRealmObject(SummonerSpell summonerSpell) {
        this.id = summonerSpell.getId();
        this.image = new ImageSummonerSpellRealmObject(summonerSpell.getImage());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageSummonerSpellRealmObject getImage() {
        return image;
    }

    public void setImage(ImageSummonerSpellRealmObject image) {
        this.image = image;
    }

}
