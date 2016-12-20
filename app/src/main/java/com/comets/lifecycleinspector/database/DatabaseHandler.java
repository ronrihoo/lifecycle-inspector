package com.comets.lifecycleinspector.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseHandler {

    private DatabaseHelper dbHelper;

    public DatabaseHandler(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public int insert(String data, int _Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", _Id);
        values.put("persistence", data);
        long movie_Id = db.insert(Contract.DataTable.TABLE_NAME, null, values);
        db.close();
        return (int) movie_Id;
    }

    public String readFirst(int _Id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String data;
        String selectQuery = "SELECT " + "persistence"
                + " FROM " + Contract.DataTable.TABLE_NAME
                + " WHERE " + "id=" + String.valueOf(_Id);
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                data = cursor.getString(cursor.getColumnIndex("persistence"));
            } while (cursor.moveToNext());
        } else {
            data = "";
        }
        cursor.close();
        db.close();
        return data;
    }

    public void update(String data, int _Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("persistence", data);
        db.update(Contract.DataTable.TABLE_NAME, values, "id" + "= ?",
                new String[]{String.valueOf(_Id)});
        db.close();
    }

    public void delete(int _Id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Contract.DataTable.TABLE_NAME, "id" + "= ?",
                new String[]{String.valueOf(_Id)});
        db.close();
    }

    public void crash() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Contract.DataTable.TABLE_NAME, "crash" + "= ?",
                new String[]{String.valueOf(0)});
        db.close();
    }

}