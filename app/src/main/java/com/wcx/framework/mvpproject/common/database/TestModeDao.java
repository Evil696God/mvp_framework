package com.wcx.framework.mvpproject.common.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface TestModeDao {
    @Insert
    void insert(TestBean testBean);
}
