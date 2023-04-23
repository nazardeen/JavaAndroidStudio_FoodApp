/*package com.abdulrahman.hndicbt;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ItemList extends AppCompatActivity {
    ListView ItemList;
    Cursor cursor;
    DBManager manager;

    String[] dbFields= new String[]{
            DatabaseHelper.ID,
            DatabaseHelper.NAME, DatabaseHelper.PRICE, DatabaseHelper.DESCRIPTION
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        manager = new DBManager(this);
        ItemList = findViewById(R.id.itemlistview);

        manager.openConnection();
        cursor=manager.getItems();
        manager.closeConnection();

        SimpleCursorAdapter cursorAdapter=new SimpleCursorAdapter((this.R.Layout.))

        ItemList.setOnClickListener((parent.view,position,id)-.{

        });



    }
}


    ListView ItemList;
    Cursor cursor;
    DBManager manager;

    String[] dbFields= new String[]{
            DatabaseHelper.ID,
            DatabaseHelper.NAME, DatabaseHelper.PRICE, DatabaseHelper.DESCRIPTION
    };*/