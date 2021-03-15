package com.example.fourth_try.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteManager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "abhiandroid.db";
    public static final int version = 1;

    public SqliteManager(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbQuery = "CREATE TABLE Items (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, description TEXT)";
        sqLiteDatabase.execSQL(dbQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }
}