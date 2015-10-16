package com.example.xiaolong.androidcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import model.ViewAction;

public class MainActivity extends Activity {

    @Bind(R.id.calculator_result_edit_text) EditText result_edit_text;

    @Bind(R.id.value_1_number_edit_text) EditText value_1_edit_text;
    @Bind(R.id.value_2_number_edit_text) EditText value_2_edit_text;

    @Bind(R.id.calculator_plus_button) Button plus_button;
    @Bind(R.id.calculator_minus_button) Button minus_button;
    @Bind(R.id.calculator_multiply_button) Button multiply_button;
    @Bind(R.id.calculator_divide_button) Button divide_button;

    HashMap<View, ViewAction> view_actions = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initializeViewActions();
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

    private void initializeViewActions() {
        view_actions.put(plus_button, new ViewAction() {
            @Override
            public void execute() {
                Double result = get_value(value_1_edit_text) + get_value(value_2_edit_text);
                result_edit_text.setText(result.toString());
            }
        });

        view_actions.put(minus_button, new ViewAction() {
            @Override
            public void execute() {
                Double result = get_value(value_1_edit_text) - get_value(value_2_edit_text);
                result_edit_text.setText(result.toString());
            }
        });

        view_actions.put(multiply_button, new ViewAction() {
            @Override
            public void execute() {
                Double result = get_value(value_1_edit_text) * get_value(value_2_edit_text);
                result_edit_text.setText(result.toString());
            }
        });

        view_actions.put(divide_button, new ViewAction() {
            @Override
            public void execute() {
                Double result = get_value(value_1_edit_text) / get_value(value_2_edit_text);
                result_edit_text.setText(result.toString());
            }
        });
    }

    public void calculate(View view) {
        view_actions.get(view).execute();
    }




}
