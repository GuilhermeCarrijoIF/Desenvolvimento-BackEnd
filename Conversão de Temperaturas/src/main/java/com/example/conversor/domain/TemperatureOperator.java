package com.example.conversor.domain;

public class TemperatureOperator {

    public Double celsiusParaKelvin(Double celsius) {
        return celsius + 273.15;
    }

    public Double celsiusParaFahrenheit(Double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public Double kelvinParaCelsius(Double kelvin) {
        return kelvin - 273.15;
    }

    public Double kelvinParaFahrenheit(Double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public Double fahrenheitParaCelsius(Double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public Double fahrenheitParaKelvin(Double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }
}
