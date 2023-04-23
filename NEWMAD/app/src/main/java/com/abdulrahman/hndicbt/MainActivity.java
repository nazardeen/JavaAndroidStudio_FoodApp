package com.abdulrahman.hndicbt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.abdulrahman.hndicbt.DatabaseHelper.ITEM;
import static com.abdulrahman.hndicbt.DatabaseHelper.NAME;

public class MainActivity extends AppCompatActivity {

    EditText inputName,inputDescription, inputPrice;
    Button btnAdd, btnUpdate,btnDelete;
    DBManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new DBManager(this);
        
        inputName= findViewById(R.id.inputName);
        inputPrice= findViewById(R.id.inputPrice);
        inputDescription= findViewById(R.id.inputDescription);
        btnAdd= findViewById(R.id.buttonAdd);
        btnUpdate= findViewById(R.id.buttonUpdate);
        btnDelete= findViewById(R.id.buttonDelete);



        btnAdd.setOnClickListener(v->{
            String name=inputName.getText().toString();
            String description=inputDescription.getText().toString();
            String price=inputPrice.getText().toString();

            if(!name.equals("")||price.equals("")||description.equals(""))
            {
            /*    manager.openConnection();
                manager.insertItem(name,description, Float.parseFloat(price));
                manager.closeConnection();
            */

                Toast.makeText(MainActivity.this,"Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Please Enter all values", Toast.LENGTH_SHORT).show();
            }
        });





        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Update Food Item");
                alert.setMessage("Some Contents will be replaced. Are you sure want to update? ");

                if (inputName.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this,"Update Successfully", Toast.LENGTH_SHORT).show();
                    return;

                }else {
                    alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"Update not added", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                alert.show();

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
       // manager.openConnection();
       // manager.deleteItem(Integer.parseInt(intent.getStringExtra(DatabaseHelper.ID)));


     //   finish();



            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("DELETE ITEM!!");
                alert.setMessage("Are you sure want to DELETE item? ");

                if (inputName.getText().toString().matches("")) {
                    Toast.makeText(MainActivity.this,"Update not added", Toast.LENGTH_SHORT).show();
                    return;

                }else {
                    alert.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            Toast.makeText(MainActivity.this,"Item not Deleted", Toast.LENGTH_SHORT).show();

                        }
                    });
                }
                alert.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        Toast.makeText(MainActivity.this,"Item Deleted", Toast.LENGTH_SHORT).show();
                    }

                });

                alert.show();

            }
        });

    }
}