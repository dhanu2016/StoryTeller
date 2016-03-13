package com.example.dhanu.storyteller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Asbar Ali on 3/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="STORYTELLERa.db";
    public static final String STORIES="STORIESa";
    public static final String TABLE_NAME="USERSa";
    public static final String COL1="ID";
    public static final String COL2="NAME";
    public static final String COL3="PASSWORD";
    SQLiteDatabase db;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        db = this.getWritableDatabase();
    }
    public Cursor getAlldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cs = db.rawQuery("select * from "+TABLE_NAME,null);
        return cs;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL2 + " TEXT," + COL3 + " TEXT)");
        db.execSQL("create table " + STORIES + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,TOPIC TEXT,TYPES TEXT,STORY TEXT,IMAGE TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " + TABLE_NAME);
        db.execSQL("Drop table if exists " + STORIES);
        onCreate(db);
    }


    public boolean insertdata (String name,String password){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL2, name);
        contentValues.put(COL3, password);

        long result=db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean createstory(String name,String topic,String types,String story,String image){
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("TOPIC", topic);
        contentValues.put("STORY", story);
        contentValues.put("TYPES", types);
        contentValues.put("IMAGE", image);
        long result=db.insert(STORIES, null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }

}
