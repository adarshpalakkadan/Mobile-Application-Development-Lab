package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class FirstActivity extends AppCompatActivity {

    Button b1, b2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        b1 = (Button) findViewById(R.id.btnHome);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(FirstActivity.this, "Welcome To Home Page", Toast.LENGTH_SHORT).show();

            }
        });

        b2 = (Button) findViewById(R.id.btnSecond);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);

                Toast.makeText(FirstActivity.this, "Welcome To Second Page", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
