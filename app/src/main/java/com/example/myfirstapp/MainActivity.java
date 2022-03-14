package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ImageButton measure, tmp, weight;
    TextView values;
    EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerDropdown);
        measure = findViewById(R.id.measureButton);
        tmp = findViewById(R.id.tmpButton);
        weight = findViewById(R.id.weightButton);
        values = findViewById(R.id.newValues);
        number = findViewById(R.id.userNumber);

        ArrayAdapter<CharSequence>transformer= ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        spinner.setAdapter(transformer);

        measure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().contentEquals("Metre")) {
                    Double numFloat = Double.parseDouble(number.getText().toString());

                    Double cm = Math.round((numFloat*100)*100.0)/100.0;
                    Double inch = Math.round((numFloat*39.37)*100.0)/100.0;
                    Double feet = Math.round((numFloat*3.28)*100.0)/100.0;

                    values.setText(String.format("%.2f", cm) + " cm" +"\r\n\n" + String.format("%.2f",inch) + " inches" +"\r\n\n" + String.format("%.2f",feet) + " feet");
                }
                else{
                    Toast.makeText(MainActivity.this,"ERROR!",Toast.LENGTH_LONG).show();
                }
            }
        });

        tmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().contentEquals("Celsius")) {
                    Double numFloat = Double.parseDouble(number.getText().toString());

                    Double kelvin = Math.round((numFloat+273.15)*100.0)/100.0;
                    Double fh = Math.round(((numFloat*9/5) + 32)*100.0)/100.0;

                    values.setText(String.format("%.2f",kelvin) + " Kelvin" +"\r\n\n" + String.format("%.2f",fh) + " Fahrenheit");
                }
                else{
                    Toast.makeText(MainActivity.this,"ERROR!",Toast.LENGTH_LONG).show();
                }
            }
        });

        weight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinner.getSelectedItem().toString().contentEquals("Kilogram")) {
                    Double numFloat = Double.parseDouble(number.getText().toString());

                    Double gram = Math.round((numFloat*1000)*100.0)/100.0;
                    Double ounce = Math.round((numFloat*35.27)*100.0)/100.0;
                    Double pound = Math.round((numFloat*2.205)*100.0)/100.0;

                    values.setText(String.format("%.2f",gram) + " Gram" +"\r\n\n" + String.format("%.2f",ounce) + " Ounce(OZ)" + "\r\n\n" + String.format("%.2f",pound) + " Pound(lb)" );
                }
                else{
                    Toast.makeText(MainActivity.this,"ERROR!",Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}