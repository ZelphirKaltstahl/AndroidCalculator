package com.example.xiaolong.androidcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.calculator_result_edit_text) EditText result_edit_text;

    @Bind(R.id.value_1_number_edit_text) EditText value_1_edit_text;
    @Bind(R.id.value_2_number_edit_text) EditText value_2_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private Double get_value(EditText editText) {
        String value_1 = editText.getText().toString();
        Double double_value_1 = 0.0;

        try {
            double_value_1 = Double.parseDouble(value_1);
        } catch (NumberFormatException ex) {
            Toast.makeText(getApplicationContext(), "Enter a number!", Toast.LENGTH_SHORT);
        }
        return double_value_1;
    }

    public void calculate_plus(View view) {
        Double result = get_value(value_1_edit_text) + get_value(value_2_edit_text);
        result_edit_text.setText(result.toString());
    }

    public void calculate_minus(View view) {
        Double result = get_value(value_1_edit_text) - get_value(value_2_edit_text);
        result_edit_text.setText(result.toString());
    }

    public void calculate_multiply(View view) {
        Double result = get_value(value_1_edit_text) * get_value(value_2_edit_text);
        result_edit_text.setText(result.toString());
    }

    public void calculate_divide(View view) {
        Double result = get_value(value_1_edit_text) / get_value(value_2_edit_text);
        result_edit_text.setText(result.toString());
    }
}
