package com.example.toggleimage;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView image1, image2;
    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImage();
            }
        });
    }

    private void toggleImage() {
        String toastMessage;
        if (isFirstImage) {
            image1.setVisibility(View.INVISIBLE);
            image2.setVisibility(View.VISIBLE);
            toastMessage = "Image 2: Visible\nImage 1: Hidden";
        } else {
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.INVISIBLE);
            toastMessage = "Image 1: Visible\nImage 2: Hidden";
        }
        isFirstImage = !isFirstImage;

        showToast(toastMessage);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
