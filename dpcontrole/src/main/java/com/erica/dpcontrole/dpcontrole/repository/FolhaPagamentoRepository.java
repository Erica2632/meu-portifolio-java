package com.erica.dpcontrole.dpcontrole.repository;

import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;
public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento, Long> {

    List<FolhaPagamento> findByCompetencia(YearMonth competencia);
    List<FolhaPagamento> findByFuncionario_CargoAndCompetencia(String cargo, YearMonth competencia);

    Optional<FolhaPagamento> findByCompetenciaAndFuncionario_Cpf(YearMonth competencia, String cpf);

}