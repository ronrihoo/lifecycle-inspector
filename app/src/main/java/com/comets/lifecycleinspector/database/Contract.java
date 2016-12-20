package com.comets.lifecycleinspector.database;

import android.content.Context;


public class Contract {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "DATABASE.db";

    public Contract(Context context) {

    }

    public class DataTable {
        // Constants
        public static final String TABLE_NAME = "Data";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + "id" + " INTEGER " + ","
                + "persistence" + " TEXT)";
    }

}
