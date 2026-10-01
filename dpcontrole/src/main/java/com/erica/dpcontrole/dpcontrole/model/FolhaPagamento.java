package com.erica.dpcontrole.dpcontrole.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.YearMonth;


@Entity
@Getter @Setter
public class FolhaPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private YearMonth competencia;

    private BigDecimal salarioBase;
    private BigDecimal totalComissao;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;
    private Integer diasTrabalhados;

}

