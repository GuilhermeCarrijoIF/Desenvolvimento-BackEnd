package com.guilherme.projeto_calculadora;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/")
    public String inicio() {
        return """
                API da Calculadora funcionando!
                Endpoints disponíveis:
                /somar?a=10&b=5
                /subtrair?a=10&b=5
                /multiplicar?a=10&b=5
                /dividir?a=10&b=5
                /raiz-quadrada?numero=9
                /raiz-cubica?numero=8
                /potencia?base=2&expoente=3
                /binario?numero=13
                /potencia-dez?expoente=3
                /fatorial?numero=5
                /pi
                """;
    }

    @GetMapping("/somar")
    public String somar(@RequestParam double a, @RequestParam double b) {
        double resultado = a + b;
        return "Soma: " + resultado;
    }

    @GetMapping("/subtrair")
    public String subtrair(@RequestParam double a, @RequestParam double b) {
        double resultado = a - b;
        return "Subtração: " + resultado;
    }

    @GetMapping("/multiplicar")
    public String multiplicar(@RequestParam double a, @RequestParam double b) {
        double resultado = a * b;
        return "Multiplicação: " + resultado;
    }

    @GetMapping("/dividir")
    public String dividir(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return "Erro: não é possível dividir por zero.";
        }
        double resultado = a / b;
        return "Divisão: " + resultado;
    }

    @GetMapping("/raiz-quadrada")
    public String raizQuadrada(@RequestParam double numero) {
        if (numero < 0) {
            return "Erro: não existe raiz quadrada real de número negativo.";
        }
        double resultado = Math.sqrt(numero);
        return "Raiz quadrada de " + numero + " = " + resultado;
    }

    @GetMapping("/raiz-cubica")
    public String raizCubica(@RequestParam double numero) {
        double resultado = Math.cbrt(numero);
        return "Raiz cúbica de " + numero + " = " + resultado;
    }

    @GetMapping("/potencia")
    public String potencia(@RequestParam double base, @RequestParam double expoente) {
        double resultado = Math.pow(base, expoente);
        return base + " elevado a " + expoente + " = " + resultado;
    }

    @GetMapping("/binario")
    public String converterParaBinario(@RequestParam int numero) {
        if (numero < 0) {
            return "Erro: para esta atividade, informe um número inteiro não negativo.";
        }
        String resultado = Integer.toBinaryString(numero);
        return "Decimal " + numero + " em binário = " + resultado;
    }

    @GetMapping("/potencia-dez")
    public String potenciaDez(@RequestParam int expoente) {
        double resultado = Math.pow(10, expoente);
        return "10 elevado a " + expoente + " = " + (long) resultado;
    }

    @GetMapping("/fatorial")
    public String fatorial(@RequestParam int numero) {
        if (numero < 0) {
            return "Erro: não existe fatorial de número negativo.";
        }

        long resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }

        return "Fatorial de " + numero + " = " + resultado;
    }

    @GetMapping("/pi")
    public String calcularPi() {
        return "Valor de PI = " + Math.PI;
    }
}