package com.erica.dpcontrole.dpcontrole.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class AtualizarFolhaDTO {

    @JsonProperty("totalComissao")
    private BigDecimal totalComissao;

    @JsonProperty("totalDesconto")
    private BigDecimal totalDesconto;

    @JsonProperty("diasTrabalhados")
    private Integer diasTrabalhados;

    public BigDecimal getTotalComissao() {
        return totalComissao;
    }

    public void setTotalComissao(BigDecimal totalComissao) {
        this.totalComissao = totalComissao;
    }

    public BigDecimal getTotalDesconto() {
        return totalDesconto;
    }

    public void setTotalDesconto(BigDecimal totalDesconto) {
        this.totalDesconto = totalDesconto;
    }

    public Integer getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(Integer diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }
}