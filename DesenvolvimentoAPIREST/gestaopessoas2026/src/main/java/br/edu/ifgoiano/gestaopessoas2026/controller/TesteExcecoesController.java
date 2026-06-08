package br.edu.ifgoiano.gestaopessoas2026.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.gestaopessoas2026.exceptions.AcessoNaoAutorizadoException;
import br.edu.ifgoiano.gestaopessoas2026.exceptions.RequisicaoInvalidaException;

@RestController
public class TesteExcecoesController {

    @GetMapping("/teste/int/{v1}")
    public String testarErroInterno(@PathVariable Integer v1) {
        if (v1 == 0) {
            throw new RuntimeException("Erro interno simulado.");
        }

        return "Nenhum erro interno foi gerado. Valor recebido: " + v1;
    }

    @GetMapping("/teste/bad/{v1}")
    public String testarBadRequest(@PathVariable Integer v1) {
        if (v1 < 0) {
            throw new RequisicaoInvalidaException("Valor inválido. O número não pode ser negativo.");
        }

        return "Nenhum erro de requisição inválida foi gerado. Valor recebido: " + v1;
    }

    @GetMapping("/teste/nao/{v1}")
    public String testarNaoAutorizado(@PathVariable Integer v1) {
        if (v1 == 401) {
            throw new AcessoNaoAutorizadoException("Acesso não autorizado simulado.");
        }

        return "Nenhum erro de acesso não autorizado foi gerado. Valor recebido: " + v1;
    }
}