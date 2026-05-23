package com.erica.dpcontrole.dpcontrole.service;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import com.erica.dpcontrole.dpcontrole.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario salvar(Funcionario f) {
        return repository.save(f);
    }

    public List<Funcionario> listarTodos() {
        return repository.findAll();
    }

    public Funcionario buscarPorCpf(String cpf) {
        Funcionario func = repository.findByCpf(cpf);
        if (func == null) {
            throw new RuntimeException("CPF não encontrado.");
        }
        return func;
    }

    public List<Funcionario> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

}
