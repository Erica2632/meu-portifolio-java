package com.erica.dpcontrole.dpcontrole.service;

import com.erica.dpcontrole.dpcontrole.dto.AtualizarFolhaDTO;
import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import com.erica.dpcontrole.dpcontrole.repository.FolhaPagamentoRepository;
import com.erica.dpcontrole.dpcontrole.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FolhaPagamentoService {
    private final FolhaPagamentoRepository repository;
    private final FuncionarioRepository funcionarioRepository;

    public FolhaPagamentoService(FolhaPagamentoRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FolhaPagamento> gerarFolhaAutomatica(String competencia) {
        List<FolhaPagamento> folhas = new java.util.ArrayList<>();

        for (Funcionario f : funcionarioRepository.findAll()) {
            if (f.getDataDesligamento() != null || f.getSalarioBase() == null) {
                continue;
            }

            FolhaPagamento folha = new FolhaPagamento();
            folha.setFuncionario(f);
            folha.setCompetencia(competencia);
            folha.setDiasTrabalhados(30);
            folha.setSalarioBase(f.getSalarioBase());
            folha.setTotalComissao(BigDecimal.ZERO);
            folha.setTotalDesconto(BigDecimal.ZERO);
            folha.setSalarioLiquido(f.getSalarioBase());

            folhas.add(repository.save(folha));
        }
        return folhas;
    }

    public List<FolhaPagamento> listarPorCompetencia(String competencia) {
        return repository.findByCompetencia(competencia);
    }

    public FolhaPagamento atualizarValores(String competencia, String cpf, AtualizarFolhaDTO dados) {
        FolhaPagamento folha = repository.findByCompetenciaAndFuncionario_Cpf(competencia, cpf)
                .orElseThrow(() -> new RuntimeException("Folha não encontrada"));

        int dias = dados.getDiasTrabalhados() != null ? dados.getDiasTrabalhados() : folha.getDiasTrabalhados();
        BigDecimal comissao = dados.getTotalComissao() != null ? dados.getTotalComissao() : folha.getTotalComissao();
        BigDecimal desconto = dados.getTotalDesconto() != null ? dados.getTotalDesconto() : folha.getTotalDesconto();

        folha.setDiasTrabalhados(dias);
        folha.setTotalComissao(comissao);
        folha.setTotalDesconto(desconto);

        BigDecimal salarioDiario = folha.getSalarioBase().divide(BigDecimal.valueOf(30), 2, java.math.RoundingMode.HALF_UP);
        BigDecimal salarioProporcional = salarioDiario.multiply(BigDecimal.valueOf(dias));
        BigDecimal salarioLiquido = salarioProporcional.add(comissao).subtract(desconto);

        folha.setSalarioLiquido(salarioLiquido);

        return repository.save(folha);
    }

    public void deletarPorCompetencia(String competencia) {
        List<FolhaPagamento> folhas = repository.findByCompetencia(competencia);
        if (folhas.isEmpty()) {
            throw new RuntimeException("Nenhuma folha encontrada");
        }
        repository.deleteAll(folhas);
    }
}