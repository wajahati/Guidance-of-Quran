package com.example.guidanceofquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= findViewById(R.id.login);
        email = findViewById(R.id.Email);
        password =  findViewById(R.id.Password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p = password.getText().toString();
                if (e.equals("ahmadwajahat312@gmail.com") && p.equals("123456")){
                    Intent main_menu = new Intent(MainActivity.this, MainMenu.class);
                    startActivity(main_menu);
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}