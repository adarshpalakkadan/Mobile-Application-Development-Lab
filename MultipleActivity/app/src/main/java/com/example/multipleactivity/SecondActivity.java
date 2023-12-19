package com.example.multipleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button b1, b2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        b1 = (Button) findViewById(R.id.btnHome);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);

                Toast.makeText(SecondActivity.this, "Welcome To Home Page", Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.btnFirst);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, FirstActivity.class);
                startActivity(intent);

                Toast.makeText(SecondActivity.this, "Welcome To First Page", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
