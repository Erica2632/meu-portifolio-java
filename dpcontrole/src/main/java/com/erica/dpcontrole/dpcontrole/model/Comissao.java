package com.erica.dpcontrole.dpcontrole.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Comissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private FuncionarioExterno funcionario;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valorComissao;

    private LocalDate referencia;

}