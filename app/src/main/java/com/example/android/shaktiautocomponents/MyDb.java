package com.example.android.shaktiautocomponents;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class MyDb extends SQLiteOpenHelper {

    public static final String DBName = "myDb";
    public static final int DBVersion = 1;

    public MyDb(Context context) {
        super(context, DBName, null, DBVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String signuptable = "CREATE TABLE signup(name VARCHAR,email VARCHAR,pass VARCHAR);";

        sqLiteDatabase.execSQL(signuptable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
