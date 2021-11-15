package com.example.lab02_balanin3930_converter;

public class Unit {
    public String name;
    public Double coeff;

    public Unit(String n, Double c)
    {
        this.name = n;
        this.coeff = c;

    }
    public String toString()
    {
        return name;
    }
}