package com.example.facebookpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        EditText e1, e2;
        Button b1;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            b1 = findViewById(R.id.buttonLogin);
            e1 = findViewById(R.id.editTextEmail);
            e2 = findViewById(R.id.editTextPassword);

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = e1.getText().toString();
                    String password = e2.getText().toString();

                    boolean isValidEmail = isValidEmail(email);
                    boolean isValidPassword = isValidPassword(password);

                    if (isValidEmail && isValidPassword) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        showToast("Success!");
                    } else {
                        if (!isValidEmail) {
                            showToast("Invalid email format");
                        } else if (!isValidPassword) {
                            showToast("Password must be at least 8 characters");
                        }
                    }
                }
            });
        }

        public void showToast(String message) {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }

        public boolean isValidEmail(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        }

        public boolean isValidPassword(String password) {
            return !TextUtils.isEmpty(password) && password.length() >= 8;
        }
    }
