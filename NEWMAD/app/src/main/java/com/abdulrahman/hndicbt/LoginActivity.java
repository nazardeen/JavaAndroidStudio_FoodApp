package com.abdulrahman.hndicbt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText inputUName, inputPassword;
    Button btn_Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inputUName = findViewById(R.id.inputUName);
        inputPassword = findViewById(R.id.inputPassword);
        btn_Login = findViewById(R.id.btn_Login);

        btn_Login.setOnClickListener(v-> {
            if(inputPassword.getText().toString().equals("")||
                    inputPassword.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),
                        "Please enter Values", Toast.LENGTH_SHORT).show();
            }else{
                if(inputUName.getText().toString().equals("abdulrahman")||
                inputPassword.getText().toString().equals("123456")) {
                    Intent myIntent = new Intent(
                            getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Please enter Values", Toast.LENGTH_SHORT).show();
                }


                }

        });

    }
}