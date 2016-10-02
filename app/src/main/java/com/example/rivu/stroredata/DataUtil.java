package com.example.rivu.stroredata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// References AndroidTutorial

public class DataUtil extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "SQLiteExample.db";
    private static final int DATABASE_VERSION = 1;
    public static final String STUD_TABLE_NAME = "student";
    public static final String STUD_COLUMN_ID = "_id";
    public static final String STUD_COLUMN_NAME = "name";
    public static final String STUD_COLUMN_EMAIL = "email";
    public static final String STUD_COLUMN_PASSWORD = "password";

    public DataUtil(Context context) {

        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + STUD_TABLE_NAME + "(" +
                STUD_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                STUD_COLUMN_NAME + " TEXT, " +
                STUD_COLUMN_EMAIL + " TEXT, " +
                STUD_COLUMN_PASSWORD + " TEXT)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + STUD_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertInfo(String name, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put(STUD_COLUMN_NAME, name);
        contentValues.put(STUD_COLUMN_EMAIL, email);
        contentValues.put(STUD_COLUMN_PASSWORD, password);
         db.insert(STUD_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getPerson(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery( "SELECT * FROM " + STUD_TABLE_NAME + " WHERE " +
                STUD_COLUMN_EMAIL + "=? AND "+STUD_COLUMN_PASSWORD + "=? ", new String[] { email,password} );
        return res;
    }

}
