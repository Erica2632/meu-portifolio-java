package com.erica.dpcontrole.dpcontrole.service;

import com.erica.dpcontrole.dpcontrole.dto.AtualizarFolhaDTO;
import com.erica.dpcontrole.dpcontrole.model.Comissao;
import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import com.erica.dpcontrole.dpcontrole.repository.ComissaoRepository;
import com.erica.dpcontrole.dpcontrole.repository.FolhaPagamentoRepository;
import com.erica.dpcontrole.dpcontrole.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.YearMonth;
import java.util.*;

@Service

public class FolhaPagamentoService {

    private final FolhaPagamentoRepository repository;
    private final FuncionarioRepository funcionarioRepository;
    private final ComissaoRepository comissaoRepository;

    public FolhaPagamentoService(FolhaPagamentoRepository repository, FuncionarioRepository funcionarioRepository, ComissaoRepository comissaoRepository){
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
        this.comissaoRepository= comissaoRepository;
    }
    public List<FolhaPagamento> gerarFolhaAutomatica(YearMonth competencia) {
        Set<Long> idsComFolha= new HashSet<>();
        for (FolhaPagamento existente : repository.findByCompetencia(competencia)) {
            idsComFolha.add(existente.getFuncionario().getId());
        }
        List<FolhaPagamento> folhas = new ArrayList<>();

        for (Funcionario f : funcionarioRepository.findAll()) {
            if (f.getDataDemissao() != null || f.getSalarioBase() == null) {
                continue;
            }
        if (idsComFolha.contains(f.getId())) {
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

    public List<FolhaPagamento> listarPorCompetencia(YearMonth competencia) {
        return repository.findByCompetencia(competencia);
    }

    public FolhaPagamento atualizarValores(YearMonth competencia, String cpf, AtualizarFolhaDTO dados) {
        FolhaPagamento folha = repository.findByCompetenciaAndFuncionario_Cpf( competencia, cpf)
                .orElseThrow(() -> new RuntimeException("Folha não encontrada"));

        int dias = dados.getDiasTrabalhados() != null ? dados.getDiasTrabalhados() : folha.getDiasTrabalhados();
        folha.setDiasTrabalhados(dias);

        BigDecimal salarioProporcional = folha.getSalarioBase()
                .multiply(BigDecimal.valueOf(dias))
                .divide(BigDecimal.valueOf(dias), RoundingMode.HALF_UP);
        BigDecimal comissao =  folha.getTotalComissao() != null ? folha.getTotalComissao() : BigDecimal.ZERO;
        BigDecimal desconto = folha.getTotalDesconto() != null ? folha.getTotalDesconto() : BigDecimal.ZERO;

        folha.setSalarioLiquido(salarioProporcional.add(comissao).subtract(desconto));

        return repository.save(folha);
    }

    public void deletarPorCompetencia(YearMonth competencia) {
        List<FolhaPagamento> folhas = repository.findByCompetencia(competencia);
        if (folhas.isEmpty()) {
            throw new RuntimeException("Nenhuma folha encontrada");
        }
        repository.deleteAll(folhas);
    }

    public List<Comissao> listar(String cargo, YearMonth competencia) {
        if (cargo != null && competencia != null) {
            return comissaoRepository.findByFuncionario_CargoAndCompetencia(cargo, competencia);
        } else if (cargo != null) {
            return comissaoRepository.findByFuncionario_Cargo(cargo);
        } else if (competencia != null) {
            return comissaoRepository.findByCompetencia(competencia);
        } else {
            return comissaoRepository.findAll();
        }
    }

}