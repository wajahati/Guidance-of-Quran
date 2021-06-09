package com.example.guidanceofquran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    ImageButton button;
    ImageButton log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        button= findViewById(R.id.currentmood);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent current_mood = new Intent(MainMenu.this, CurrentMood.class);
                startActivity(current_mood);
            }
        });
        log_out= findViewById(R.id.logout);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_menu = new Intent(MainMenu.this, MainActivity.class);
                startActivity(main_menu);
            }
        });


    }
}