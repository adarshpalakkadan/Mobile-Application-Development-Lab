package com.example.simplecalculator;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private StringBuilder currentInput;
    private boolean isResultShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        currentInput = new StringBuilder();
        isResultShown = false;

        setButtonClickListeners();
    }

    private void setButtonClickListeners() {
        int[] numberButtonIds = {
                R.id.button0, R.id.button1, R.id.button2,
                R.id.button3, R.id.button4, R.id.button5,
                R.id.button6, R.id.button7, R.id.button8,
                R.id.button9
        };
        for (int numberButtonId : numberButtonIds) {
            findViewById(numberButtonId).setOnClickListener(view -> onNumberButtonClick(((Button) view).getText().toString()));
        }

        int[] operatorButtonIds = {
                R.id.add, R.id.subtract, R.id.multiply, R.id.divide,
                R.id.percent
        };
        for (int operatorButtonId : operatorButtonIds) {
            findViewById(operatorButtonId).setOnClickListener(view -> onOperatorButtonClick(((Button) view).getText().toString()));
        }

        findViewById(R.id.clear).setOnClickListener(view -> clearDisplay());
        findViewById(R.id.decimal).setOnClickListener(view -> onDecimalButtonClick());
        findViewById(R.id.equals).setOnClickListener(view -> evaluateExpression());
        findViewById(R.id.buttonparenthesis1).setOnClickListener(view -> appendToInput("("));
        findViewById(R.id.buttonparenthesis2).setOnClickListener(view -> appendToInput(")"));
    }

    private void onNumberButtonClick(String number) {
        if (isResultShown) {
            currentInput.setLength(0);
            isResultShown = false;
        }
        appendToInput(number);
    }

    private void onOperatorButtonClick(String operator) {
        if (isResultShown) {
            isResultShown = false;
        }
        appendToInput(" " + operator + " ");
    }

    private void onDecimalButtonClick() {
        if (isResultShown) {
            currentInput.setLength(0);
            isResultShown = false;
        }
        appendToInput(".");
    }

    private void appendToInput(String input) {
        currentInput.append(input);
        display.setText(currentInput.toString());
    }

    private void clearDisplay() {
        currentInput.setLength(0);
        display.setText("");
    }

    private void evaluateExpression() {
        try {
            String expression = currentInput.toString();

            Expression exp = new ExpressionBuilder(expression).build();

            double result = exp.evaluate();

            display.setText(String.valueOf(result));
            isResultShown = true;
        } catch (ArithmeticException e) {
            display.setText(getString(R.string.error_message));
            isResultShown = true;
        }
    }
}
