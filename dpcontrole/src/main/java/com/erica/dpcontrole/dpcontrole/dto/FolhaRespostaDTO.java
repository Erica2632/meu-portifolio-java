package com.erica.dpcontrole.dpcontrole.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.YearMonth;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter @Setter

public class FolhaRespostaDTO {

    private FuncionarioRespostaDTO funcionario;
    private YearMonth competencia;
    private BigDecimal salarioBase;
    private BigDecimal totalComissao;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;
    private Integer diasTrabalhados;

}