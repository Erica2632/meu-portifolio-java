package com.erica.dpcontrole.dpcontrole.dto;

import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import java.math.BigDecimal;

public class FuncionarioRespostaDTO {
    private String nome;
    private String cpf;
    private String cargo;
    private BigDecimal salarioBase;

    public FuncionarioRespostaDTO() {}

    public FuncionarioRespostaDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.cargo = funcionario.getCargo();
        this.salarioBase = funcionario.getSalarioBase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(BigDecimal salarioBase) {
        this.salarioBase = salarioBase;
    }
}