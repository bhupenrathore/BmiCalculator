package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight, edtHeightF, edtHeightIn;
        Button btnCalculate;
        LinearLayout llMain;

        edtHeightF = findViewById(R.id.edtHeightF);
        edtHeightIn= findViewById(R.id.edtHeightIn);
        edtWeight= findViewById(R.id.edtWeight);
        txtResult = findViewById(R.id.txtResult);
        btnCalculate= findViewById(R.id.btnCalculate);
        llMain= findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                int wt=  Integer.parseInt(edtWeight.getText().toString());
               int ft=  Integer.parseInt(edtHeightF.getText().toString());
               int In= Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn = ft*12 + In;
               Double totalCm = totalIn*2.53;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);

               if ((bmi>25)){
                   txtResult.setText("You are OverWeight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colOverWt));
                }else if (bmi<18){
                   txtResult.setText("You are UnderWeight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colUnderWt));

               }else{
                   txtResult.setText("You are Fit");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colFit));

               }
            }
        });
    }
}