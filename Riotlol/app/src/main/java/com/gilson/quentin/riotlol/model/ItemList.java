package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by quentin on 11-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemList {

    private Map<String,Item> data;

    public Map<String, Item> getData() {
        return data;
    }

    public void setData(Map<String, Item> data) {
        this.data = data;
    }
}
