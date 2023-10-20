package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.conversion.models.Celsius;
import com.example.conversion.models.Fahrenheit;
import com.example.conversion.models.Grado;
import com.example.conversion.models.Kelvin;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText grados;

    TextView cv1,cv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         spinner = (Spinner) findViewById(R.id.unit);
         grados= (EditText) findViewById(R.id.grad);
         cv1=(TextView) findViewById(R.id.conv1);
         cv2=(TextView) findViewById(R.id.conv2);


        String[] unit_array ={"Celsius","Fahrenheit","Kelvin"};

        ArrayAdapter<String>adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unit_array);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Conversion();
            }
        });
    }

    private void Conversion()
    {
        int unidad = spinner.getSelectedItemPosition();
        String valor= grados.getText().toString();
        String result="";
        switch (unidad)
        {
            case 0:
                Celsius celsius= new Celsius(Double.parseDouble(valor), "F");
                cv1.setText(String.valueOf(celsius.parse(new Fahrenheit(Double.parseDouble(valor),"F")).getValor())+" F°");
                cv2.setText(String.valueOf(celsius.parse(new Kelvin(Double.parseDouble(valor), "K")).getValor())+" K°");
                break;
            case 1:
                Fahrenheit fahrenheit= new Fahrenheit(Double.parseDouble(valor), "F");
                cv1.setText(String.valueOf(fahrenheit.parse(new Celsius(Double.parseDouble(valor),"C")).getValor())+" C°");
                cv2.setText(String.valueOf(fahrenheit.parse(new Kelvin(Double.parseDouble(valor), "K")).getValor())+" K°");
                break;
            case 2:
                Kelvin kelvin=new Kelvin(Double.parseDouble(valor),"K");
                cv1.setText(String.valueOf(kelvin.parse(new Celsius(Double.parseDouble(valor),"C")).getValor())+" C°");
                cv2.setText(String.valueOf(kelvin.parse(new Fahrenheit(Double.parseDouble(valor), "F")).getValor())+" F°");
                break;
        }
    };
}