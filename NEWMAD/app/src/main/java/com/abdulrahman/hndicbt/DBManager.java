package com.abdulrahman.hndicbt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
    Context context;
    SQLiteDatabase database;
    DatabaseHelper dbHelper;


    public DBManager(Context c) {
        context = c;
    }
    public DBManager openConnection(){
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;

    }
    public void closeConnection(){
        dbHelper.close();
    }
    public void insertItem(String name, String description, Float price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME,name);
        contentValues.put(DatabaseHelper.DESCRIPTION,description);
        contentValues.put(DatabaseHelper.PRICE,price);


        database.insert(DatabaseHelper.ITEM,null,contentValues);

    }

    public void updateItem(int id, String name, String description, float price) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAME, name);
        contentValues.put(DatabaseHelper.DESCRIPTION, description);
        contentValues.put(DatabaseHelper.PRICE, price);


        database.update(DatabaseHelper.ITEM, contentValues, DatabaseHelper.ID + "=" + id, null);
    }

    public Cursor getItems(){
        String[] columns = new String[]{DatabaseHelper.ID,DatabaseHelper.NAME,DatabaseHelper.DATE,DatabaseHelper.ORDER_STATUS};
    Cursor cursor = database.query(DatabaseHelper.ITEM,columns,null,null,null,null,null);
        if (cursor != null) {
            cursor.moveToFirst();
        }return cursor;

        }

    public void deleteItem(int id)
    {
        database.delete(DatabaseHelper.ITEM, DatabaseHelper.ID + "=", null);
    }




}
