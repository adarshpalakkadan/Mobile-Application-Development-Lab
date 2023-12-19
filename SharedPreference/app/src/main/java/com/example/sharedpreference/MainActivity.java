package com.example.sharedpreference;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Button b1;
    private SharedPreferences sh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.editTextName);
        e2 = findViewById(R.id.editTextTextEmailAddress);
        e3 = findViewById(R.id.editTextPhone);
        e4 = findViewById(R.id.editTextPassword);
        b1 = findViewById(R.id.buttonRegister);

        sh = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        String savedName = sh.getString("name", "");
        String savedEmail = sh.getString("email", "");
        String savedPhone = sh.getString("phone", "");
        String savedPassword = sh.getString("password", "");

        e1.setText(savedName);
        e2.setText(savedEmail);
        e3.setText(savedPhone);
        e4.setText(savedPassword);

        b1.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        String name = e1.getText().toString().trim();
        String email = e2.getText().toString().trim();
        String phone = e3.getText().toString().trim();
        String password = e4.getText().toString().trim();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(phone) || TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidEmail(email)) {
            Toast.makeText(this, "Please enter a valid email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidPhoneNumber(phone)) {
            Toast.makeText(this, "Please enter a valid 10-digit phone number", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidPassword(password)) {
            Toast.makeText(this, "Password should be at least 8 characters", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = sh.edit();
        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("phone", phone);
        editor.putString("password", password);
        editor.apply();

        Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone.length() == 10 && TextUtils.isDigitsOnly(phone);
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}
