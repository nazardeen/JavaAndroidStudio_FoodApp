package com.abdulrahman.hndicbt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String ITEM = "Item";
    public static final String ID = "_id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String QUANTITY = "quantit";
    public static final String TYPE = "typee";


    public static final String ORDER = "Orderr";
    public static final String ORDER_ID = "_id";
    public static final String DATE = "name";
    public static final String ORDER_DES = "description";
    public static final String TOTAL_AMOUNT = "amount";
    public static final String NO_ORDER_ITEMS = "orderitems";
    public static final String ORDER_STATUS = "status";



    static final String DB_NAME = " YummyFoods.DB";

    static final int DB_VERSION = 1;


    private static final String CREATE_TABLE_ITEM = "create table " + ITEM + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT, " + DESCRIPTION + " TEXT, "
            + QUANTITY + " INTEGER, "+ TYPE + " TEXT, " + PRICE + " FLOAT);";

    private static final String CREATE_TABLE_ORDER = "create table " + ORDER + "(" + ORDER_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " DATE, " +ORDER_DES + " TEXT, "
            + TOTAL_AMOUNT + " FLOAT, " + NO_ORDER_ITEMS + " INTEGER,"+ ORDER_STATUS + "BOOLEAN);";






    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_ITEM);
        sqLiteDatabase.execSQL(CREATE_TABLE_ORDER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ITEM );
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ORDER);

        onCreate(sqLiteDatabase);
    }
}
