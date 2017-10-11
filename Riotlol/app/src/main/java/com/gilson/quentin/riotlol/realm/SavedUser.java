package com.gilson.quentin.riotlol.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 11-10-17.
 */

public class SavedUser extends RealmObject{
    @PrimaryKey
    private int id;
    private String name;
    private String newName;

    public SavedUser() {

    }

    public SavedUser(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
