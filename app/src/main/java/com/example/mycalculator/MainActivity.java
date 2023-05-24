package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private StringBuilder currentInput;
    private double currentOperand;
    private double previousOperand;
    private double result;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
        currentInput = new StringBuilder();
        currentOperand = 0.0;
        previousOperand = 0.0;
        result = 0.0;
        operator = "";

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonDot = findViewById(R.id.buttonDot);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("0");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInput("9");
            }
        });

        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v
            ) {
                performOperation("/");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.toString().contains(".")) {
                    updateInput(".");
                }
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("=");
            }
        });
    }

    private void updateInput(String value) {
        currentInput.append(value);
        resultTextView.setText(currentInput.toString());
    }

    private void performOperation(String newOperator) {
        if (operator.isEmpty()) {
            currentOperand = Double.parseDouble(currentInput.toString());
        } else {
            previousOperand = currentOperand;
            currentOperand = Double.parseDouble(currentInput.toString());
            performCalculation();
        }
        operator = newOperator;
        currentInput.setLength(0);
    }

    private void performCalculation() {
        switch (operator) {
            case "+":
                result = previousOperand + currentOperand;
                break;
            case "-":
                result = previousOperand - currentOperand;
                break;
            case "*":
                result = previousOperand * currentOperand;
                break;
            case "/":
                if (currentOperand != 0) {
                    result = previousOperand / currentOperand;
                } else {
                    result = Double.NaN;
                }
                break;
        }
        updateResult();
    }

    private void updateResult() {
        resultTextView.setText(String.valueOf(result));
    }

    private void clear() {
        currentInput.setLength(0);
        currentOperand = 0.0;
        previousOperand = 0.0;
        result = 0.0;
        operator = "";
        resultTextView.setText("0");
    }
}