package com.nick.a75fapplication;

import android.provider.BaseColumns;

/**
 * Created by Nick Khoury on 2017-06-06.
 */

public class Contract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Contract() {}

    /* Inner class that defines the table contents */
    public static class Sensor implements BaseColumns {
        public static final String TABLE_NAME = "Sensor";
        public static final String COLUMN_DATA = "sensorValue";
        public static final String COLUMN_TIME = "epochTime";
        public static final String COLUMN_TAG = "entryTag";
    }
}
