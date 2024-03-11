package com.example.fintech_l2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText inputText;
    private TextView resultText;
    private Spinner choicesSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();

        calculateButton.setOnClickListener(v -> buttonOnClickCalculate());
    }

    private void buttonOnClickCalculate(){
        Toast.makeText(this, "Button clicked!", Toast.LENGTH_SHORT).show();
    }

    private void initializeComponents(){
        calculateButton = findViewById(R.id.btnCalculate);
        inputText = findViewById(R.id.txtInput);
        resultText = findViewById(R.id.tvResult);
        choicesSpinner = findViewById(R.id.choicesSpinner);
    }
}