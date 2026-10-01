package com.erica.dpcontrole.dpcontrole.controller;

import com.erica.dpcontrole.dpcontrole.dto.*;
import com.erica.dpcontrole.dpcontrole.model.Comissao;
import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import com.erica.dpcontrole.dpcontrole.service.FolhaPagamentoService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/folhas")
public class FolhaPagamentoController {
    private final FolhaPagamentoService service;

    public FolhaPagamentoController(FolhaPagamentoService service) {
        this.service = service;
    }

    @PostMapping("gerar-folha-automatica/{competencia}")
    public ResponseEntity<List<FolhaRespostaDTO>> gerarFolhaAutomatica(@PathVariable YearMonth competencia) {
        List<FolhaPagamento> folhas = service.gerarFolhaAutomatica(competencia);

        List<FolhaRespostaDTO> resposta = folhas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resposta);

    }

    @GetMapping("/{competencia}")
    public ResponseEntity<List<FolhaRespostaDTO>> listarPorCompetencia(@PathVariable YearMonth competencia) {
        List<FolhaPagamento> folhas = service.listarPorCompetencia(competencia);

        List<FolhaRespostaDTO> resposta = folhas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resposta);
    }

    @GetMapping("listar-comissao")
    public ResponseEntity<List<ComissaoRespostaDTO>> listar(@RequestParam (required = false) String cargo  , @RequestParam YearMonth competencia ) {

        List<Comissao> comissoes = service.listar(cargo, competencia);

        List<ComissaoRespostaDTO> resposta = comissoes.stream()
                .map(ComissaoRespostaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{competencia}/{cpf}")
    public ResponseEntity<?> atualizarValores(
            @PathVariable YearMonth competencia,
            @PathVariable String cpf,
            @Valid @RequestBody AtualizarFolhaDTO dados) {

        try {
            FolhaPagamento folha = service.atualizarValores(competencia, cpf, dados);
            return ResponseEntity.ok(converterParaDTO(folha));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{competencia}")
    public ResponseEntity<Void> deletarPorCompetencia(@PathVariable YearMonth competencia) {
        service.deletarPorCompetencia(competencia);
        return ResponseEntity.noContent().build();
    }

    private FolhaRespostaDTO converterParaDTO(FolhaPagamento folha) {
        FolhaRespostaDTO dto = new FolhaRespostaDTO();

        if (folha.getFuncionario() != null) {
            dto.setFuncionario(new FuncionarioRespostaDTO(folha.getFuncionario()));
        }

        dto.setCompetencia(folha.getCompetencia());
        dto.setSalarioBase(folha.getSalarioBase());
        dto.setTotalComissao(folha.getTotalComissao());
        dto.setTotalDesconto(folha.getTotalDesconto());
        dto.setSalarioLiquido(folha.getSalarioLiquido());
        dto.setDiasTrabalhados(folha.getDiasTrabalhados());

        return dto;
    }
}