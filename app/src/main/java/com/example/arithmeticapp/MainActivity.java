package com.example.arithmeticapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double num1,num2,sum;
    EditText et1,et2;
    TextView txtResult;
    Button btnAdd,btnSub,btnDiv,btnMulti,btnClear,btnExit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        txtResult = findViewById(R.id.textViewResult);
        btnClear = findViewById(R.id.buttonClear);
        btnExit = findViewById(R.id.buttonExit);
        btnDiv = findViewById(R.id.buttonDivide);
        btnMulti = findViewById(R.id.buttonMulti);
        btnSub = findViewById(R.id.buttonMinus);
        btnAdd = findViewById(R.id.buttonAdd);

        addition();
        subtraction();
        multiplication();
        division();
        clearAll();
        closeApp();
    }

    private void closeApp() {
        btnExit.setOnClickListener(v -> finish());
    }

    private void clearAll() {
        btnClear.setOnClickListener(v -> {
            et1.setText("");
            et2.setText("");
            txtResult.setText("");
        });
    }

    private void division() {
        btnDiv.setOnClickListener(v -> {
            num1 = Double.parseDouble(et1.getText().toString());
            num2 = Double.parseDouble(et2.getText().toString());
            sum = num1/num2;
            txtResult.setText(String.format(Locale.getDefault(), "%.2f", sum));
        });
    }

    private void multiplication() {
        btnMulti.setOnClickListener(v -> {
            num1 = Double.parseDouble(et1.getText().toString());
            num2 = Double.parseDouble(et2.getText().toString());
            sum = num1 * num2;
            txtResult.setText(String.format(Locale.getDefault(), "%.2f", sum));
        });
    }

    private void subtraction() {
        btnSub.setOnClickListener(v -> {
            num1 = Double.parseDouble(et1.getText().toString());
            num2 = Double.parseDouble(et2.getText().toString());
            sum = num1-num2;
            txtResult.setText(String.format(Locale.getDefault(), "%.2f", sum));
        });
    }

    private void addition() {
        btnAdd.setOnClickListener(v -> {
            num1 = Double.parseDouble(et1.getText().toString());
            num2 = Double.parseDouble(et2.getText().toString());
            sum = num1+num2;
            txtResult.setText(String.format(Locale.getDefault(), "%.2f", sum));
        });
    }
}