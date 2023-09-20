package com.example.finalfinalcalcappashishk;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView solution;
    private Boolean equation = false;
    private String view2 = "";
    private double result = 0.0;
    void assignId(int id) {
        MaterialButton btn = findViewById(id);
        btn.setOnClickListener(this::onClick);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        solution = findViewById(R.id.ongoing);
        assignId(R.id.button_divide);
        assignId(R.id.button_multiply);
        assignId(R.id.button_plus);
        assignId(R.id.button_minus);
        assignId(R.id.button_equals);
        assignId(R.id.button_0);
        assignId(R.id.button_1);
        assignId(R.id.button_2);
        assignId(R.id.button_3);
        assignId(R.id.button_4);
        assignId(R.id.button_5);
        assignId(R.id.button_6);
        assignId(R.id.button_7);
        assignId(R.id.button_8);
        assignId(R.id.button_9);
        assignId(R.id.button_ac);
    }

    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        if (buttonText.equals("AC")) {
            view2 = "";
            result = 0.0;
            solution.setText(view2);
            equation = false;
            return;
        }
        if(buttonText.equals("/") || buttonText.equals("*") || buttonText.equals("+") || buttonText.equals("-")){
            if(!equation) {
                equation = true;
            }
            else {
                buttonText = "";
            }
        }

        view2 += buttonText;
        solution.setText(view2);
        if (buttonText.equals("=")){
            double answer = equals(view2);
            solution.setText(""+ answer);
            view2 = "" + answer;
        }
    }
    public double equals(String string){
        String operator = "";
        double num1 = 0.0;
        double num2 = 0.0;
        int index = 0;
        if(string.contains("+")) {
            index = string.indexOf("+");
            operator = "+";
        }
        else if(string.contains("-")) {
            index = string.indexOf("-");
            operator = "-";
        }
        else if(string.contains("*")) {
            index = string.indexOf("*");
            operator = "*";
        }
        else if(string.contains("/")) {
            index = string.indexOf("/");
            operator = "/";
        }
        else{
            return parseDouble(string.substring(0, string.indexOf("=")));
        }
        num1 = parseDouble(string.substring(0, index));
        if(index+1 == string.length() - 1){
            num2 = 0;
        }
        else {
            num2 = parseDouble(string.substring(index + 1, string.length() - 1));
        }
        if (operator.equals("+")) {
            result = num1+num2;
        }
        else if (operator.equals("-")) {
            result = num1-num2;
        }
        else if (operator.equals("*")) {
            result = num1*num2;
        }
        else if (operator.equals("/")) {
            result = num1/num2;
        }
        return result;
    }
}
