package com.example.conversion.models;

public class Fahrenheit extends Grado{
    public Fahrenheit(Double valor, String unidad) {
        super(valor, unidad);}
    public Fahrenheit parse(Celsius c){return new Fahrenheit((c.getValor()-32)*.55,"C");}

    public Fahrenheit parse (Kelvin k){return new Fahrenheit((k.getValor()-32*.55)+273.15, "K");}

}
