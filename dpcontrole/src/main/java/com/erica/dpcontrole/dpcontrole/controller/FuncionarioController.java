package com.erica.dpcontrole.dpcontrole.controller;

import com.erica.dpcontrole.dpcontrole.dto.AtualizarFuncionarioDTO;
import com.erica.dpcontrole.dpcontrole.dto.FuncionarioRespostaDTO;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import com.erica.dpcontrole.dpcontrole.dto.NovoFuncionarioDTO;
import com.erica.dpcontrole.dpcontrole.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService service;

    public FuncionarioController (FuncionarioService service){
        this.service= service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FuncionarioRespostaDTO cadastrar(@RequestBody NovoFuncionarioDTO dto) {
        return service.cadastrar(dto);
    }

    @GetMapping
    public List<FuncionarioRespostaDTO> listarTodos() {
        List<Funcionario> listaFuncionario= service.listarTodos();

        return listaFuncionario.stream()
                .map(FuncionarioRespostaDTO::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Object> buscarPorNome(@PathVariable String nome) {

        List<Funcionario> funcionarios = service.buscarPorNome(nome);

        if (funcionarios == null || funcionarios.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Não existe funcionário cadastrado com esse nome.");
        }

        List<FuncionarioRespostaDTO> resposta = funcionarios.stream()
                .map(FuncionarioRespostaDTO::new)
                .toList();

        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/cpf/{cpf}")
    public ResponseEntity<Object> atualizarPorCpf(@PathVariable String cpf, @RequestBody AtualizarFuncionarioDTO dto) {

        try {
            Funcionario funcionario = service.buscarPorCpf(cpf);
            funcionario.atualizarInformacoes(dto);
            service.salvar(funcionario);

            return ResponseEntity.ok(new FuncionarioRespostaDTO(funcionario));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}