package com.example.fintech_l2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
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

        // set button action
        calculateButton.setOnClickListener(v -> buttonOnClickCalculate());
    }

    private void initializeComponents(){
        calculateButton = (Button) findViewById(R.id.btnCalculate);
        inputText = (EditText) findViewById(R.id.txtInput);
        resultText = (TextView) findViewById(R.id.tvResult);
        choicesSpinner = (Spinner) findViewById(R.id.choicesSpinner);

        // init values for spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.calculation_choices_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        choicesSpinner.setAdapter(adapter);
    }

    private void buttonOnClickCalculate(){
        boolean validationPassed = validateButtonInput();
        if (!validationPassed){
            return;
        }
        
    }

    /**
     * @return true if validation passed, false otherwise
     */
    private boolean validateButtonInput(){
        String strInput = inputText.getText().toString();
        if(TextUtils.isEmpty(strInput)) {
            inputText.setError(getString(R.string.empty_input));
            Toast.makeText(this, getString(R.string.empty_input), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}