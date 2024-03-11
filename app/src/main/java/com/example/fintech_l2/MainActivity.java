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

import com.example.fintech_l2.exception.LengthCalculationException;
import com.example.fintech_l2.utils.TextCounterUtils;

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
        String strInput = inputText.getText().toString();
        boolean validationPassed = validateButtonInput(strInput);
        if (!validationPassed){
            return;
        }
        // using enums here would prob be nicer
        // strategy pattern could work too for more complex code
        String calculationMethod = choicesSpinner.getSelectedItem().toString();
        if (calculationMethod.equalsIgnoreCase("CHARS")){
            // could use one try/catch block, but with this implementation we allow more control
            // to have different actions if needed on failure
            try {
                resultText.setText(getString(R.string.total_characters_output,
                        TextCounterUtils.calculateChars(strInput)));
            }
            catch (LengthCalculationException e){
                resultText.setText(e.getMessage());
            }

        }
        else if (calculationMethod.equalsIgnoreCase("WORDS")){
            try {
                resultText.setText(getString(R.string.total_words_output,
                        TextCounterUtils.calculateWords(strInput)));
            }
            catch (LengthCalculationException e){
                resultText.setText(e.getMessage());
            }
        }
        else {
            Toast.makeText(this, getString(R.string.calculation_method_bad_input),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * @return true if validation passed, false otherwise
     */
    private boolean validateButtonInput(String strInput){
        if(TextUtils.isEmpty(strInput)) {
            inputText.setError(getString(R.string.empty_input));
            Toast.makeText(this, getString(R.string.empty_input), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}