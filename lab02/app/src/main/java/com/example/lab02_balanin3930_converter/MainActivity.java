package com.example.lab02_balanin3930_converter;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    EditText et_From;
    Spinner sp_From;
    Spinner sp_To;
    TextView tv_res;
    RadioButton rb_time, rb_meter, rb_mass;
    ArrayAdapter <Object> adpMeter;
    ArrayAdapter <Object> adpTime;
    ArrayAdapter <Object> adpMass;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {   //Balanin 393 Lab 02 Converter
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adpMeter = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adpTime = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);
        adpMass = new <Object> ArrayAdapter(this, android.R.layout.simple_list_item_1);

        et_From = findViewById(R.id.editText_From);
        tv_res = findViewById(R.id.tv_result);
        sp_From = findViewById(R.id.spinner_From);
        sp_To = findViewById(R.id.spinner_To);
        rb_time = findViewById(R.id.rb_time);
        rb_mass = findViewById(R.id.rb_mass);
        rb_meter = findViewById(R.id.rb_meters);
        //Filling adapter for Meters
        Unit un = new Unit("mm", 0.001);
        adpMeter.add(un);
        un = new Unit("sm", 0.01);
        adpMeter.add(un);
        un = new Unit("dm", 0.1);
        adpMeter.add(un);
        un = new Unit("m", 1.0);
        adpMeter.add(un);
        un = new Unit("km", 1000.0);
        adpMeter.add(un);
        //Filling adapter for Mass
        un = new Unit("mg", 0.000001);
        adpMass.add(un);
        un = new Unit("gr", 0.001);
        adpMass.add(un);
        un = new Unit("kg", 1.0);
        adpMass.add(un);
        un = new Unit("centner", 1.0);
        adpMass.add(un);
        un = new Unit("tonn", 1.0);
        adpMass.add(un);
        //Filling Adapter for Time
        un = new Unit("ms", .001);
        adpTime.add(un);
        un = new Unit("s", 1.0);
        adpTime.add(un);
        un = new Unit("min", 60.0);
        adpTime.add(un);
        un = new Unit("hours", 3600.0);
        adpTime.add(un);
        un = new Unit("days", 86400.0);
        adpTime.add(un);
        sp_From.setAdapter(adpMeter);
        sp_To.setAdapter(adpMeter);
    }
    public void OnConverter_Click(View v)
    {
        double a;
        if (et_From.getText().toString().length() == 0) {
            tv_res.setText("Value filed is not a number");
            return;
        }
        try {
            a = Double.parseDouble(et_From.getText().toString());
        }
        catch (Exception e) {
            tv_res.setText("Value filed is not a number");
            return;
        }
        Unit from = (Unit) sp_From.getSelectedItem();
        Unit to = (Unit) sp_To.getSelectedItem();
        tv_res.setText(String.valueOf(a * from.coeff / to.coeff));
    }

    public void SwitchAdapters(View v)
    {
        switch ((String)v.getTag()) {
            case "1":
                    sp_From.setAdapter(adpMeter);
                    sp_To.setAdapter(adpMeter);
                    rb_time.setChecked(false);
                    rb_mass.setChecked(false);
                break;
            case "2":
                    sp_From.setAdapter(adpMass);
                    sp_To.setAdapter(adpMass);
                    rb_time.setChecked(false);
                    rb_meter.setChecked(false);
                break;
            case "3":
                    sp_From.setAdapter(adpTime);
                    sp_To.setAdapter(adpTime);
                    rb_meter.setChecked(false);
                    rb_mass.setChecked(false);
                break;
        }
    }
}