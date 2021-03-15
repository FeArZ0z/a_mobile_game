package com.example.fourth_try.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fourth_try.controller.Card;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class myDbAdapter {

    myDbHelper myHelper;
    public myDbAdapter(Context context){
        myHelper = new myDbHelper(context);
    }

    public void insertData(Card card){
        SQLiteDatabase db = myHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.TEXT, card.text);
        contentValues.put(myDbHelper.SIPS, card.sips);
        contentValues.put(myDbHelper.CATEGORY, card.kategorie);
    }

    public ArrayList<Card> getData(
    ){
        SQLiteDatabase db = myHelper.getWritableDatabase();

        String[] data = {myDbHelper.UID, myDbHelper.TEXT, myDbHelper.SIPS, myDbHelper.CATEGORY};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,data,null,null,null,null,null);
        ArrayList<Card> list = new ArrayList<>();
        while(cursor.moveToNext()){
            int cid = cursor.getInt(cursor.getColumnIndex(myDbHelper.UID));
            String text = cursor.getString(cursor.getColumnIndex(myDbHelper.TEXT));
            String sips = cursor.getString(cursor.getColumnIndex(myDbHelper.SIPS));
            String cat = cursor.getString(cursor.getColumnIndex(myDbHelper.CATEGORY));
            String Cid = String.valueOf(cid);
            Card array = new Card(text, sips, cat);
            list.add(array);
        }
        cursor.close();
        return list;
    }

    static class myDbHelper extends SQLiteOpenHelper{

        private static final String DATABASE_NAME = "myDatabase";
        private static final String TABLE_NAME = "Cards";
        private static final int DATABASE_Version = 2;
        private static final String UID = "_index";
        private static final String TEXT = "Text";
        private static final String SIPS = "Sips";
        private static final String CATEGORY = "Category";
        private static final String CRATE_TABLE = "CREATE TABLE "+ TABLE_NAME +" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ TEXT +" VARCHAR(255) ,"
                + SIPS +" VARCHAR(2),"+CATEGORY+" VARCHAR(1))";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CRATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        }
    }
}
