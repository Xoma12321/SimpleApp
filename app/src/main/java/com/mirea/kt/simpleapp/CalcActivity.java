package com.mirea.kt.simpleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        EditText editTextFirst = findViewById(R.id.etFirst);
        EditText editTextSecond = findViewById(R.id.etSecond);
        Button btnCalc = findViewById(R.id.btnStart);
        btnCalc.setOnClickListener(v -> {
            String firstTermStr = editTextFirst.getText().toString();
            String secondTermStr = editTextSecond.getText().toString();
            if (!firstTermStr.isEmpty() && !secondTermStr.isEmpty() && Double.parseDouble(secondTermStr) !=0) {
                double result = Double.parseDouble(firstTermStr) / Double.parseDouble(secondTermStr);
                Intent intent = new Intent();
                intent.putExtra("data", result);
                setResult(RESULT_OK, intent);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }
        });
    }
}