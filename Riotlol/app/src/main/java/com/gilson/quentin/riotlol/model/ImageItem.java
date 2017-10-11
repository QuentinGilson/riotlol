package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by quentin on 11-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageItem {

    private String full;


    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
