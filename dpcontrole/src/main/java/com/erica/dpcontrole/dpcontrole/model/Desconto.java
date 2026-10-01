package com.erica.dpcontrole.dpcontrole.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Entity
@Setter @Getter
public class Desconto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valorDesconto;

    private LocalDate data;

    private YearMonth competencia;

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
}