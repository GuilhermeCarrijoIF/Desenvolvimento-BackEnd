package br.edu.ifgoiano.gestaopessoas2026.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.edu.ifgoiano.gestaopessoas2026.exceptions.RequisicaoInvalidaException;
import br.edu.ifgoiano.gestaopessoas2026.model.Pessoa;

@Service
public class PessoaService {

    private final AtomicLong contador = new AtomicLong();

    public Pessoa buscarPorId(String id) {
        Long idConvertido = converterId(id);

        Pessoa pessoa = mockPessoa(idConvertido);

        if (idConvertido <= 0) {
            throw new RequisicaoInvalidaException("O ID informado deve ser maior que zero.");
        }

        return pessoa;
    }

    public List<Pessoa> buscarTodas() {
        List<Pessoa> pessoas = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            pessoas.add(mockPessoa((long) i));
        }

        return pessoas;
    }

    public Pessoa criar(Pessoa pessoa) {
        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new RequisicaoInvalidaException("O nome da pessoa é obrigatório.");
        }

        pessoa.setId(contador.incrementAndGet());
        return pessoa;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        if (pessoa.getId() == null || pessoa.getId() <= 0) {
            throw new RequisicaoInvalidaException("Informe um ID válido para atualizar a pessoa.");
        }

        if (pessoa.getNome() == null || pessoa.getNome().isBlank()) {
            throw new RequisicaoInvalidaException("O nome da pessoa é obrigatório.");
        }

        return pessoa;
    }

    public void deletar(String id) {
        Long idConvertido = converterId(id);

        if (idConvertido <= 0) {
            throw new RequisicaoInvalidaException("O ID informado deve ser maior que zero.");
        }

        // Simulação de exclusão.
    }

    private Pessoa mockPessoa(Long id) {
        Pessoa pessoa = new Pessoa();

        pessoa.setId(id);
        pessoa.setNome("Pessoa " + id);
        pessoa.setSobrenome("Sobrenome " + id);
        pessoa.setEndereco("Rua Exemplo, número " + id);
        pessoa.setGenero("Não informado");

        return pessoa;
    }

    private Long converterId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new RequisicaoInvalidaException("O ID informado não é válido.");
        }
    }
}