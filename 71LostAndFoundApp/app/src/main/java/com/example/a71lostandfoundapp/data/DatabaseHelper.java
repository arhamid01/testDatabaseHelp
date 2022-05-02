package com.example.a71lostandfoundapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.a71lostandfoundapp.model.Ad;
import com.example.a71lostandfoundapp.util.Util;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_AD_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("+ Util.AD_ID + "INTEGER PRIMARY KEY AUTOINCREMENT , "
                + Util.TABLE_NAME + "TEXT" + Util.PHONE + "TEXT" + Util.DESCRIPTION + "TEXT" + Util.DATE + "TEXT" + Util.LOCATION + "TEXT)";

        sqLiteDatabase.execSQL(CREATE_AD_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String DROP_AD_TABLE = "DROP TABLE IF EXISTS";
        sqLiteDatabase.execSQL(DROP_AD_TABLE, new String[]{Util.TABLE_NAME});
        onCreate(sqLiteDatabase);
    }

    public long insertAd(Ad advert){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Util.NAME, advert.getName());
        contentValues.put(Util.PHONE, advert.getPhone());
        contentValues.put(Util.DESCRIPTION, advert.getDescription());
        contentValues.put(Util.DATE, advert.getDate());
        contentValues.put(Util.LOCATION, advert.getLocation());
        long newRowId = db.insert(Util.TABLE_NAME, null, contentValues);
        db.close();
        return newRowId;
    }

    public boolean fetchAd(String name, String phoneNum, String desc, String date, String location){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Util.TABLE_NAME, new String[]{Util.AD_ID}, Util.NAME + "=? and " + Util.PHONE + "=? and " + Util.DESCRIPTION + "=? and " + Util.DATE + "=? and " + Util.LOCATION + "=?",
                new String[] {name, phoneNum, desc, date, location}, null, null, null);
        int numberOfRows = cursor.getCount();
        db.close();

        if (numberOfRows>0)
        {
            return true;
        }
        else{
            return false;
        }
    }
}
