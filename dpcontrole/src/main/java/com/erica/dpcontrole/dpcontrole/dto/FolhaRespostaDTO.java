package com.erica.dpcontrole.dpcontrole.dto;

import java.math.BigDecimal;

public class FolhaRespostaDTO {

    private FuncionarioRespostaDTO funcionario;
    private String competencia;
    private BigDecimal salarioBase;
    private BigDecimal totalComissao;
    private BigDecimal totalDesconto;
    private BigDecimal salarioLiquido;
    private Integer diasTrabalhados;

    public FuncionarioRespostaDTO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioRespostaDTO funcionario) {
        this.funcionario = funcionario;
    }

    public Integer getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(Integer diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }

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

    public BigDecimal getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(BigDecimal salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }
}