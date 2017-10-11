package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

/**
 * Created by quentin on 11-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpellList {

    private Map<String,SummonerSpell> data;

    public Map<String, SummonerSpell> getData() {
        return data;
    }

    public void setData(Map<String, SummonerSpell> data) {
        this.data = data;
    }
}
