package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by quentin on 10-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion {

    private int id;
    private String name;
    private ImageChampion image;

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

    public ImageChampion getImage() {
        return image;
    }

    public void setImage(ImageChampion image) {
        this.image = image;
    }
}
