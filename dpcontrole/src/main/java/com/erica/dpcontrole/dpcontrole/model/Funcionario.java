package com.erica.dpcontrole.dpcontrole.model;

import com.erica.dpcontrole.dpcontrole.dto.AtualizarFuncionarioDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Getter @Setter
@Entity
@Inheritance(strategy =InheritanceType.SINGLE_TABLE)
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "funcionario")
    private List<Desconto> descontos = new ArrayList<>();

    @OneToMany(mappedBy = "funcionario")
    private List<FolhaPagamento> folhasPagamento = new ArrayList<>();

    protected String nome;
    protected String cpf;
    protected String pis;
    protected LocalDate dataAdmissao;
    protected LocalDate dataDemissao;
    protected String cargo;
    protected BigDecimal salarioBase;


    public void atualizarInformacoes(AtualizarFuncionarioDTO dto) {
        if (dto.getNome() != null && !dto.getNome().trim().isEmpty()) {
            this.nome = dto.getNome();
        }

        if (dto.getCargo() != null && !dto.getCargo().trim().isEmpty()) {
            this.cargo = dto.getCargo();
        }

        if (dto.getSalarioBase() != null) {
            if (this.salarioBase == null || dto.getSalarioBase().compareTo(this.salarioBase) > 0) {
                this.salarioBase = dto.getSalarioBase();
            }
        }

        if (dto.getDataDemissao() != null) {
            this.dataDemissao= dto.getDataDemissao();
        }
    }
}