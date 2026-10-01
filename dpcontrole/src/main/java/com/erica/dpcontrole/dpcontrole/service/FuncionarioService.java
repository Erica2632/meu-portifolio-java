package com.erica.dpcontrole.dpcontrole.service;
import com.erica.dpcontrole.dpcontrole.dto.FuncionarioRespostaDTO;
import com.erica.dpcontrole.dpcontrole.dto.NovoFuncionarioDTO;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import com.erica.dpcontrole.dpcontrole.model.FuncionarioExterno;
import com.erica.dpcontrole.dpcontrole.model.TipoFuncionario;
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

    public FuncionarioRespostaDTO cadastrar ( NovoFuncionarioDTO dto){

        Funcionario novoFuncionario= new Funcionario();
        novoFuncionario.setNome(dto.getNome());
        novoFuncionario.setCpf(dto.getCpf());
        novoFuncionario.setPis(dto.getPis());
        novoFuncionario.setDataAdmissao(dto.getDataAdmissao());
        novoFuncionario.setCargo(dto.getCargo());
        novoFuncionario.setSalarioBase(dto.getSalarioBase());

        if ( dto.getTipoFuncionario()== TipoFuncionario.EXTERNO){
            novoFuncionario= new FuncionarioExterno();
        }  else {
            novoFuncionario= new Funcionario();
        }

        Funcionario funcionarioSalvo = repository.save(novoFuncionario);

        return new FuncionarioRespostaDTO(funcionarioSalvo);
    }

    public List<Funcionario> buscarPorNome(String nome) {

        return repository.findByNomeContainingIgnoreCase(nome);
    }

}
