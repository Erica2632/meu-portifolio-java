package com.erica.dpcontrole.dpcontrole.repository;

import com.erica.dpcontrole.dpcontrole.model.Comissao;
import com.erica.dpcontrole.dpcontrole.model.FolhaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

public interface ComissaoRepository extends JpaRepository<Comissao, Long> {
    List<Comissao> findByFuncionario_Cargo(String cargo);

    List<Comissao> findByCompetencia(YearMonth competencia);
    List<Comissao> findByFuncionario_CargoAndCompetencia(String cargo, YearMonth competencia);
}
