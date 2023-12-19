package com.example.calculatorsimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button addButton, subtractButton, multiplyButton, divideButton, percentButton, allClearButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        addButton = findViewById(R.id.addButton);
        subtractButton = findViewById(R.id.subtractButton);
        multiplyButton = findViewById(R.id.multiplyButton);
        divideButton = findViewById(R.id.divideButton);
        percentButton = findViewById(R.id.percentButton);
        allClearButton = findViewById(R.id.allClearButton);
        result = findViewById(R.id.result);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    performAddition();
                } else {
                    showRequiredFieldMessage();
                }
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    performSubtraction();
                } else {
                    showRequiredFieldMessage();
                }
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    performMultiplication();
                } else {
                    showRequiredFieldMessage();
                }
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    performDivision();
                } else {
                    showRequiredFieldMessage();
                }
            }
        });

        percentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isInputValid()) {
                    performPercentage();
                } else {
                    showRequiredFieldMessage();
                }
            }
        });

        allClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
            }
        });
    }

    private boolean isInputValid() {
        return !number1.getText().toString().isEmpty() && !number2.getText().toString().isEmpty();
    }

    private void performAddition() {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double res = num1 + num2;
        result.setText("Result: " + res);
    }

    private void performSubtraction() {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double res = num1 - num2;
        result.setText("Result: " + res);
    }

    private void performMultiplication() {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double res = num1 * num2;
        result.setText("Result: " + res);
    }

    private void performDivision() {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double res = num1 / num2;
        result.setText("Result: " + res);
    }

    private void performPercentage() {
        double num1 = Double.parseDouble(number1.getText().toString());
        double num2 = Double.parseDouble(number2.getText().toString());
        double res = (num1 * num2) / 100;
        result.setText("Result: " + res);
    }

    private void showRequiredFieldMessage() {
        result.setText("Please fill in both fields.");
    }

    private void clearFields() {
        number1.setText("");
        number2.setText("");
        result.setText("Result will be displayed here");
    }
}
