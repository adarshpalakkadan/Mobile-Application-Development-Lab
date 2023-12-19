package com.example.uicontrols;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Spinner spinner;
    private CheckBox checkBox;
    private RadioButton radioButton1, radioButton2;
    private SeekBar seekBar;
    private ImageView imageView;

    private int toastDelay = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextValidation);
        spinner = findViewById(R.id.spinnerValidation);
        checkBox = findViewById(R.id.checkBoxValidation);
        radioButton1 = findViewById(R.id.radioButton1Validation);
        radioButton2 = findViewById(R.id.radioButton2Validation);
        seekBar = findViewById(R.id.seekBarValidation);
        imageView = findViewById(R.id.imageViewValidation);

        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCustomValidation();
            }
        });
    }

    private void showToastWithDelay(final String message) {
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }
                },
                toastDelay
        );
        toastDelay += 1000;
    }

    private void performCustomValidation() {
        String userInput = editText.getText().toString().trim();

        if (!userInput.equalsIgnoreCase("Hello")) {
            editText.setError("Please enter 'Hello'");
            showToastWithDelay("Please enter 'Hello'");
            return;
        } else {
            showToastWithDelay("Correct text entered: " + userInput);
        }

        String defaultItemText = "Select an item";
        String selectedSpinnerItem = "";

        if (spinner.getSelectedItem() != null) {
            selectedSpinnerItem = spinner.getSelectedItem().toString();
        }

        if (selectedSpinnerItem.equals(defaultItemText)) {
            showToastWithDelay("Please select an item");
        } else {
            showToastWithDelay("Selected item: " + selectedSpinnerItem);
        }

        if (!checkBox.isChecked()) {
            showToastWithDelay("Please check the box");
        } else {
            showToastWithDelay("CheckBox is checked");
        }

        if (!radioButton1.isChecked() && !radioButton2.isChecked()) {
            showToastWithDelay("Please select an option");
        } else {
            String selectedRadioButton = radioButton1.isChecked() ? "Option 1" : "Option 2";
            showToastWithDelay("Selected RadioButton: " + selectedRadioButton);
        }

        int seekBarValue = seekBar.getProgress();
        if (seekBarValue < 50) {
            showToastWithDelay("Seek Bar value is too low");
        } else {
            showToastWithDelay("Seek Bar value: " + seekBarValue);
        }

        imageView.setImageResource(android.R.drawable.btn_star_big_on);
        showToastWithDelay("ImageView updated");
    }
}
