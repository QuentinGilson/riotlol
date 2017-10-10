package com.gilson.quentin.riotlol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by quentin on 10-10-17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResult {

    private int profileIconId;
    private String name;

    public PlayerResult() {
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
