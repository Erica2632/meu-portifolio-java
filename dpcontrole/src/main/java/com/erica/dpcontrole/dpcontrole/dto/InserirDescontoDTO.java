package com.erica.dpcontrole.dpcontrole.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import  java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter

public class InserirDescontoDTO {
    private String cpf;
    private BigDecimal valorDesconto;
    private LocalDate competencia;
    @NotBlank
    private String descricao;

}
