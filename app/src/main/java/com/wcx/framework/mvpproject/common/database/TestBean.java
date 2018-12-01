package com.wcx.framework.mvpproject.common.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "testmodel")
public class TestBean implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "_id")
    public int id = 1;

    @NonNull
    @ColumnInfo(name = "description")
    public String description;

    @NonNull
    @ColumnInfo(name = "image_url")
    public String image_url;

    public TestBean() {

    }

    @Ignore
    public TestBean(String description, String image_url) {
        this.description = description;
        this.image_url = image_url;
    }
}

