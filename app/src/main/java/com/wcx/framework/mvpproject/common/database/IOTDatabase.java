package com.wcx.framework.mvpproject.common.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * @author wangchenxing
 * @data 30/11/2018 9:12 AM
 */
@Database(
        entities = {TestBean.class},
        version = IOTDatabase.DATABASEVERSION,
        exportSchema = false)
public abstract class IOTDatabase extends RoomDatabase {
    public abstract TestModeDao testModeDao();

    public static final int DATABASEVERSION = 1;
    private static String databaseName = "IOT.db";
    private static volatile IOTDatabase iotDatabase;

    public static IOTDatabase getDatabase(Context context) {
        if (iotDatabase == null) {
            synchronized (IOTDatabase.class) {
                if (iotDatabase == null) {
                    iotDatabase = Room.databaseBuilder(
                            context,
                            IOTDatabase.class,
                            databaseName
                    )
                            .addMigrations()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return iotDatabase;
    }
}
