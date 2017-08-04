package com.nick.a75fapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by 4dm1n on 2017-06-06.
 */

public class Helper {
    static long pushDb(String sensorType, String sensorValue, Context context) {
        //To access your database, instantiate your subclass of SQLiteOpenHelper:
        ContractHelper mDbHelper = new ContractHelper(context);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        // put the time of the sensor data insert (using the epoch in seconds) into the table
        String epochSeconds = Long.toString(System.currentTimeMillis()/1000);
        values.put(Contract.Sensor.COLUMN_DATA, sensorValue); // sensor data
        values.put(Contract.Sensor.COLUMN_TIME, epochSeconds); // epoch
        values.put(Contract.Sensor.COLUMN_TAG, sensorType);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Contract.Sensor.TABLE_NAME, null, values);
        return newRowId;
    }
}
