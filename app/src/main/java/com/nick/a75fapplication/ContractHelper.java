package com.nick.a75fapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nick Khoury on 2017-06-06.
 */

public class ContractHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SensorData.db";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + Contract.Sensor.TABLE_NAME + " (" + Contract.Sensor._ID + " INTEGER PRIMARY KEY," + Contract.Sensor.COLUMN_DATA + " TEXT," + Contract.Sensor.COLUMN_TIME + " TEXT," + Contract.Sensor.COLUMN_TAG + " TEXT)";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + Contract.Sensor.TABLE_NAME;

    public ContractHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
