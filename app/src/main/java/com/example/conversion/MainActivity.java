package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.conversion.models.Celsius;
import com.example.conversion.models.Fahrenheit;
import com.example.conversion.models.Grado;
import com.example.conversion.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Grado celsius = new Celsius(0.0,"C");
        Grado fahrenheit= new Fahrenheit(0.0,"F");
        Grado kelvin = new Kelvin(0.0,"K");
    }
}