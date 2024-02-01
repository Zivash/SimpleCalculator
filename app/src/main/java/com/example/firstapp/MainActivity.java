package com.example.firstapp;

import static java.lang.Double.parseDouble;
//import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    static double numberOne = 0;
    static double numberTwo = 0;
    static boolean numberTwoFlag = false;
    static boolean arithmeticFunc = false;
    static boolean afterEqual = false;
    static String arithmetic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.textViewResult);

    }

    public void funcNumber(View view) {
        Button button = (Button) view;
        String str = button.getText().toString();

        if(result.getText().toString().equals("0") || arithmeticFunc || afterEqual) {
            result.setText(str);
            //arithmeticFunc = false;
            afterEqual = false;
        }
        else{
            result.append(str);
        }
        arithmeticFunc = false;
    }

    public void funcArithmetics(View view) {
        Button button = (Button) view;
        String str = button.getText().toString();

        if(numberTwoFlag)
        {
            funcEqual(view);
        }

        if (!arithmeticFunc) {
            numberOne = parseDouble(result.getText().toString());
            arithmeticFunc = true;
            numberTwoFlag = true;
        }
        arithmetic = str;
    }

    public void funcDelete(View view) {

        if(result.length() == 1)
        {
            result.setText("0");
        }
        else {
            result.setText(result.getText().toString().toCharArray(), 0, result.length() - 1);
        }
    }

    public void funcEqual(View view) {

        if(numberTwoFlag) {
            numberTwo = parseDouble(result.getText().toString());

            switch (arithmetic) {
                case "+":
                    if (numberOne + numberTwo == (int) (numberOne + numberTwo)) {
                        result.setText(String.valueOf((int) (numberOne + numberTwo)));
                    } else {
                        result.setText(String.valueOf(numberOne + numberTwo));
                    }
                    break;
                case "-":
                    if (numberOne - numberTwo == (int) (numberOne - numberTwo)) {
                        result.setText(String.valueOf((int) (numberOne - numberTwo)));
                    } else {
                        result.setText(String.valueOf(numberOne - numberTwo));
                    }
                    break;
                case "X":
                    if (numberOne * numberTwo == (int) (numberOne * numberTwo)) {
                        result.setText(String.valueOf((int) (numberOne * numberTwo)));
                    } else {
                        result.setText(String.valueOf(numberOne * numberTwo));
                    }
                    break;
                case "/":
                    if (numberOne / numberTwo == (int) (numberOne / numberTwo)) {
                        result.setText(String.valueOf((int) (numberOne / numberTwo)));
                    } else {
                        result.setText(String.valueOf(numberOne / numberTwo));
                    }
            }

            numberTwoFlag = false;
            arithmeticFunc = false;
            afterEqual = true;
        }
    }

}