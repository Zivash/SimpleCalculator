package com.example.firstapp;

import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    static int numberOne = 0;
    static int numberTwo = 0;
    static int numberTwoFlag = 1;
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

        if(result.getText().toString().equals("0") || numberTwoFlag == 0) {
            result.setText(str);
            numberTwoFlag = 1;
        }
        else result.append(str);

    }

    public void funcAritmichs(View view) {
        Button button = (Button) view;

        numberTwoFlag = 0;

        numberOne = parseInt(result.getText().toString());

        String str = button.getText().toString();
        
        arithmetic = str;

        result.setText(str);
    }

    public void funcEqual(View view) {
        Button button = (Button) view;

        numberTwo = parseInt(result.getText().toString());

        switch(arithmetic) {
            case "+":
                result.setText(String.valueOf(numberOne+numberTwo));
                break;
            case "-":
                result.setText(String.valueOf(numberOne-numberTwo));
                break;
            case "X":
                result.setText(String.valueOf(numberOne*numberTwo));
                break;
            case "/":
                result.setText(String.valueOf(numberOne/numberTwo));
        }

        numberTwoFlag = 0;

    }
}