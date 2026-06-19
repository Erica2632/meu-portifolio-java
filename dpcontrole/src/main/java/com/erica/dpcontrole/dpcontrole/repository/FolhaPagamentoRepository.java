package com.erica.dpcontrole.dpcontrole.repository;

import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface FolhaPagamentoRepository extends JpaRepository<FolhaPagamento, Long> {

    List<FolhaPagamento> findByCompetencia(String competencia);


    Optional<FolhaPagamento> findByCompetenciaAndFuncionario_Cpf(String competencia, String cpf);

}