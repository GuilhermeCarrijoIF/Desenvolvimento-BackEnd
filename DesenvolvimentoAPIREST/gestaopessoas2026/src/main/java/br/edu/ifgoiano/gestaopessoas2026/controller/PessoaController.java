package br.edu.ifgoiano.gestaopessoas2026.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoiano.gestaopessoas2026.model.Pessoa;
import br.edu.ifgoiano.gestaopessoas2026.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa buscarPorId(@PathVariable String id) {
        return pessoaService.buscarPorId(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> buscarTodas() {
        return pessoaService.buscarTodas();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Pessoa criar(@RequestBody Pessoa pessoa) {
        return pessoaService.criar(pessoa);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Pessoa atualizar(@RequestBody Pessoa pessoa) {
        return pessoaService.atualizar(pessoa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id) {
        pessoaService.deletar(id);
    }
}