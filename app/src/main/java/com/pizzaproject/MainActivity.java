package com.pizzaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private RadioButton smallRadio, mediumRadio, largeRadio;

    private double pizzaPrice = 0.0;

    private TextView textAll;
    private Button buttonSubmit;
    private CheckBox check1, check2, check3, check4, check5, check6, check7, check8;
    private int count = 0;

    private EditText qyt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        setUp();
    }

    private void initView() {
        smallRadio = findViewById(R.id.smallRadio);
        mediumRadio = findViewById(R.id.mediumRadio);
        largeRadio = findViewById(R.id.largeRadio);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        textAll = findViewById(R.id.textAll);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        check5 = findViewById(R.id.check5);
        check6 = findViewById(R.id.check6);
        check7 = findViewById(R.id.check7);
        check8 = findViewById(R.id.check8);
        qyt = findViewById(R.id.qyt);
    }

    private void setUp() {
        smallRadio.setOnCheckedChangeListener(this);
        mediumRadio.setOnCheckedChangeListener(this);
        largeRadio.setOnCheckedChangeListener(this);

        check1.setOnCheckedChangeListener(this);
        check2.setOnCheckedChangeListener(this);
        check3.setOnCheckedChangeListener(this);
        check4.setOnCheckedChangeListener(this);
        check5.setOnCheckedChangeListener(this);
        check6.setOnCheckedChangeListener(this);
        check7.setOnCheckedChangeListener(this);
        check8.setOnCheckedChangeListener(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (qyt.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "enter quantity", Toast.LENGTH_SHORT).show();
                    return;
                }
                double total;
                if (count > 2) {
                    total = (Integer.parseInt(qyt.getText().toString()) * pizzaPrice) + ((count - 2) * 2);
                } else {
                    total = (Integer.parseInt(qyt.getText().toString()) * pizzaPrice);
                }

                textAll.setText("" + new DecimalFormat("##.##").format(total));
            }
        });
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.smallRadio:
                if (isChecked) {
                    pizzaPrice = 8.99;
                }

                break;
            case R.id.mediumRadio:
                if (isChecked) {
                    pizzaPrice = 11.99;
                }
                break;
            case R.id.largeRadio:
                if (isChecked) {
                    pizzaPrice = 14.99;
                }
                break;

            case R.id.check1:

            case R.id.check8:

            case R.id.check7:

            case R.id.check6:

            case R.id.check5:

            case R.id.check4:

            case R.id.check3:


            case R.id.check2:
                if (isChecked) {
                    count++;
                } else {
                    count--;
                }
                break;
        }
    }
}
