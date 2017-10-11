package com.gilson.quentin.riotlol.realm;

import com.gilson.quentin.riotlol.model.ImageItem;
import com.gilson.quentin.riotlol.model.Item;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by quentin on 11-10-17.
 */

public class ItemRealmObject extends RealmObject {

    @PrimaryKey
    private int id;
    private ImageItemRealmObject image;

    public ItemRealmObject() {

    }

    public ItemRealmObject(Item item) {
        this.id = item.getId();
        this.image = new ImageItemRealmObject(item.getImage());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageItemRealmObject getImage() {
        return image;
    }

    public void setImage(ImageItemRealmObject image) {
        this.image = image;
    }
}
