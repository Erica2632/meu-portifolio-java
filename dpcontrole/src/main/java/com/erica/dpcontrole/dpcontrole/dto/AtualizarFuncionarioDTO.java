package com.erica.dpcontrole.dpcontrole.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter

public class AtualizarFuncionarioDTO {
    private String nome;
    private String cargo;
    private BigDecimal salarioBase;

    @Schema(example = "null", description = "Preencher apenas em caso de demissão")
    private LocalDate dataDemissao;

}
