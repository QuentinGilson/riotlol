package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;


/**
 * Created by quentin on 10-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionList{

    private String version;
    private Map<String,Champion> data;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Champion> getData() {
        return data;
    }

    public void setData(Map<String, Champion> data) {
        this.data = data;
    }
}
