package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by quentin on 11-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {

    private int id;
    private ImageItem image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageItem getImage() {
        return image;
    }

    public void setImage(ImageItem image) {
        this.image = image;
    }
}

