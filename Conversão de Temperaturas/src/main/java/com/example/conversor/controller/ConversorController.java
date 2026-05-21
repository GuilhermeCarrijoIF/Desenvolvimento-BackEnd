package com.example.conversor.controller;

import com.example.conversor.domain.TemperatureOperator;
import com.example.conversor.exceptions.UnsupportedTemperatureTargetException;
import com.example.conversor.util.NumberConverter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/conversor")
@RestController
public class ConversorController {

    private final TemperatureOperator operator = new TemperatureOperator();

    @GetMapping("/celsiusParaKelvin/{valor}")
    public Double celsiusParaKelvin(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.celsiusParaKelvin(temperatura);
    }

    @GetMapping("/celsiusParaFahrenheit/{valor}")
    public Double celsiusParaFahrenheit(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.celsiusParaFahrenheit(temperatura);
    }

    @GetMapping("/kelvinParaCelsius/{valor}")
    public Double kelvinParaCelsius(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.kelvinParaCelsius(temperatura);
    }

    @GetMapping("/kelvinParaFahrenheit/{valor}")
    public Double kelvinParaFahrenheit(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.kelvinParaFahrenheit(temperatura);
    }

    @GetMapping("/fahrenheitParaCelsius/{valor}")
    public Double fahrenheitParaCelsius(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.fahrenheitParaCelsius(temperatura);
    }

    @GetMapping("/fahrenheitParaKelvin/{valor}")
    public Double fahrenheitParaKelvin(@PathVariable String valor) {
        validarNumero(valor);

        Double temperatura = NumberConverter.convertToDouble(valor);
        return operator.fahrenheitParaKelvin(temperatura);
    }

    private void validarNumero(String valor) {
        if (!NumberConverter.isNumeric(valor)) {
            throw new UnsupportedTemperatureTargetException(
                    "O valor informado nao e um numero valido: " + valor
            );
        }
    }
}
