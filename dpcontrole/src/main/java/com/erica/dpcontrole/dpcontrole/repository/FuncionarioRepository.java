package com.erica.dpcontrole.dpcontrole.repository;
import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Funcionario findByCpf(String cpf);
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    List<Funcionario> findByNomeIgnoreCase(String nome);


}
