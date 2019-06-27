package com.darshit.androidweatherapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseObject {

    private static Database dbHelper;
    private SQLiteDatabase db;

    public DatabaseObject(Context context) {
        dbHelper = new Database(context);
        this.dbHelper.getWritableDatabase();
        this.db = dbHelper.getReadableDatabase();
    }

    public SQLiteDatabase getDbConnection(){
        return this.db;
    }

    public void closeDbConnection(){
        if(this.db != null){
            this.db.close();
        }
    }
}
