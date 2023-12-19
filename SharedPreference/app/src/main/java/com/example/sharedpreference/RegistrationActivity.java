package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class RegistrationActivity extends AppCompatActivity {
    TextView t1, t2, t3, t4;
    Button b2;
    private SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        t1 = (TextView) findViewById(R.id.textViewUsername);
        t2 = (TextView) findViewById(R.id.textViewEmail);
        t3 = (TextView) findViewById(R.id.textViewPhone);
        t4 = (TextView) findViewById(R.id.textViewPassword);
        b2 = (Button) findViewById(R.id.buttonBack);

        sh = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        b2.setOnClickListener(view -> back());

        display();
    }

    private void display() {
        String username = sh.getString("username", "");
        String email = sh.getString("email", "");
        String phone = sh.getString("phone", "");
        String password = sh.getString("password", "");

        t1.setText("Username: " + username);
        t2.setText("Email: " + email);
        t3.setText("Phone: " + phone);
        t4.setText("Password: " + password);
    }

    private void back() {
        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}



