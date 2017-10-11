package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by quentin on 11-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpell {

    private int id;
    private ImageSummonerSpell image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageSummonerSpell getImage() {
        return image;
    }

    public void setImage(ImageSummonerSpell image) {
        this.image = image;
    }
}
