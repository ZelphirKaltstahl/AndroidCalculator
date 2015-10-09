package com.example.xiaolong.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    private static final String TAG = "myLogs";

    private TextView value_1_label;
    private TextView value_2_label;
    private TextView result_label;
    private TextView result_text_view;

    private EditText value_1_edit_text;
    private EditText value_2_edit_text;

    private Button plus_button;
    private Button minus_button;
    private Button multiply_button;
    private Button divide_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize_widgets();
        addActionListeners();
    }

    private void initialize_widgets() {
        value_1_edit_text = (EditText) findViewById(R.id.value_1_number_text_field);
        value_2_edit_text = (EditText) findViewById(R.id.value_2_number_text_field);

        plus_button = (Button) findViewById(R.id.calculator_plus_button);
        minus_button = (Button) findViewById(R.id.calculator_minus_button);
        multiply_button = (Button) findViewById(R.id.calculator_multiply_button);
        divide_button = (Button) findViewById(R.id.calculator_divide_button);

        result_text_view = (TextView) findViewById(R.id.calculator_result_text_view);
    }

    private Double get_value_1() {
        String value_1 = value_1_edit_text.getText().toString();
        Double double_value_1 = 0.0;

        try {
            double_value_1 = Double.parseDouble(value_1);
        } catch (NumberFormatException ex) {
            Toast.makeText(getApplicationContext(), "Enter a number!", Toast.LENGTH_SHORT);
        }
        return double_value_1;
    }

    private Double get_value_2() {
        String value_2 = value_2_edit_text.getText().toString();
        Double double_value_2 = 0.0;

        try {
            double_value_2 = Double.parseDouble(value_2);
        } catch (NumberFormatException ex) {
            Toast.makeText(getApplicationContext(), "Enter a number!", Toast.LENGTH_SHORT);
        }
        return double_value_2;
    }

    private void addActionListeners() {
        plus_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = get_value_1() + get_value_2();
                result_text_view.setText(result.toString());
            }
        });

        minus_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = get_value_1() - get_value_2();
                result_text_view.setText(result.toString());
            }
        });

        multiply_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = get_value_1() * get_value_2();
                result_text_view.setText(result.toString());
            }
        });

        divide_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Double result = get_value_1() / get_value_2();
                result_text_view.setText(result.toString());
            }
        });
    }




}
