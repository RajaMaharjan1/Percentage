package com.meroapp.percentage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnCalculate;
    EditText etName, etAndroid, etIOT, etWeb;
    TextView tvText;
    String result="";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalculate = findViewById(R.id.btnCalculate);
        etName = findViewById(R.id.etName);
        etAndroid = findViewById(R.id.etAndroid);
        etIOT = findViewById(R.id.etIOT);
        etWeb = findViewById(R.id.etWeb);
        tvText = findViewById(R.id.tvText);
        btnCalculate.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==R.id.btnCalculate){
            if (TextUtils.isEmpty(etName.getText().toString())) {
                etName.setError("Please enter name");
                return;

            }else if (TextUtils.isEmpty(etAndroid.getText().toString())){
                etAndroid.setError("Please enter Android marks");
                return;

            } else if (TextUtils.isEmpty(etIOT.getText().toString())) {
                etIOT.setError("Please enter marks of IOT");
                return;
            } else if (TextUtils.isEmpty(etWeb.getText().toString())) {
                etWeb.setError("Please enter marks of WEB");
                return;
            } else {
                tvText.append(("Name: " +etName.getText().toString()) + " | Android: " + (etAndroid.getText().toString()) + " | IOT: " + (etIOT.getText().toString()) + " | Web: " + (etWeb.getText().toString()) +
                        " | percentage: "+percentage()+ " | result: "+result+"\n");
                Clear();
            }
        }

    }

    public double percentage() {

        double android = 0, iot = 0, web = 0;
        android = Double.parseDouble(etAndroid.getText().toString());
        iot=Double.parseDouble(etIOT.getText().toString());
        web = Double.parseDouble(etWeb.getText().toString());
        double per = (android + iot + web) / 3;
        if ((android >= 40) && (iot >= 40) && (web >= 40)) {
            result = "Pass";
        } else {
            result = "Fail";
        }

        return per;
    }

    public void Clear() {
        etName.setText("");
        etAndroid.setText("");
        etIOT.setText("");
        etWeb.setText("");
    }

            }




