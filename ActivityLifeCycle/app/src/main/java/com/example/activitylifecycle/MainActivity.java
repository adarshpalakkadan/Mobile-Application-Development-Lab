package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LifecycleDemo";
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        showToast("onCreate");
        addTextView("onCreate");
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToast("onStart");
        addTextView("onStart");
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToast("onResume");
        addTextView("onResume");
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("onPause");
        addTextView("onPause");
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showToast("onStop");
        addTextView("onStop");
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToast("onDestroy");
        addTextView("onDestroy");
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showToast("onRestart");
        addTextView("onRestart");
        Log.d(TAG, "onRestart");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void addTextView(String message) {
        TextView textView = new TextView(this);
        textView.setText(message);
        linearLayout.addView(textView);
    }
}
