package com.example.lab01_balanin_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
            //Баланин Эдуард группа 393 Лабораторная работа 1 - Простой калькулятор
    EditText tA;
    EditText tB;
    TextView tC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tA= findViewById(R.id.text_A);
        tB= findViewById(R.id.text_B);
        tC= findViewById(R.id.text_result);
    }

   public void OnButton_Click(View v)
   {
       if(tA.getText().length() == 0 || tB.getText().length() == 0)
       {
           tC.setText("A or B field is empty");
           return;
       }
       double A = 0;
       double B = 0;
       try {
           A = Double.parseDouble(tA.getText().toString());
           B = Double.parseDouble(tB.getText().toString());
       }
       catch (Exception ex)
       {
           tC.setText("Field A or B is not a valid number");
           return;
       }

       switch ((String)v.getTag())
       {
           case "0": tC.setText(String.valueOf(A + B)); break;
           case "1": tC.setText(String.valueOf(A - B)); break;
           case "2": tC.setText(String.valueOf(A * B)); break;
           case "3":
               if(B == 0)
               {
                   tC.setText("Field B is not a valid number");
                   return;
               }
               tC.setText(String.valueOf(A / B)); break;
           case "7": tC.setText(String.valueOf(Math.pow(A, B))); break;
       }
   }
   public void OnTrigonometryButton_Click(View v)
   {
       if(tA.getText().length() == 0)
       {
           tC.setText("'A' number field is empty");
           return;
       }
       double A = 0;
       double B = 0;
       try {
           A = Double.parseDouble(tA.getText().toString());

       }
       catch (Exception ex)
       {
           tC.setText("Field A or B is not a valid number");
           return;
       }

       A *= Math.PI / 180;
       switch ((String)v.getTag())
       {
           case "4":
               tC.setText(String.valueOf(Math.sin(A)));
               break;
           case "5":
               tC.setText(String.valueOf(Math.cos(A)));
               break;
           case "6":
               tC.setText(String.valueOf(Math.tan(A)));
               break;
           case "8":
               A = Double.parseDouble(tA.getText().toString());
               tC.setText(String.valueOf(Math.sqrt(A)));
               break;
       }

   }
}