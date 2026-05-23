package com.erica.dpcontrole.dpcontrole.model;

import com.erica.dpcontrole.dpcontrole.dto.AtualizarFuncionarioDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    protected LocalDate dataDesligamento;
    protected String cargo;
    protected BigDecimal salarioBase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Desconto> getDescontos() {
        return descontos;
    }

    public void setDescontos(List<Desconto> descontos) {
        this.descontos = descontos;
    }

    public List<FolhaPagamento> getFolhasPagamento() {
        return folhasPagamento;
    }

    public void setFolhasPagamento(List<FolhaPagamento> folhasPagamento) {
        this.folhasPagamento = folhasPagamento;
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

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataDesligamento() {
        return dataDesligamento;
    }

    public void setDataDesligamento(LocalDate dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
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
            this.dataDesligamento = dto.getDataDemissao();
        }
    }
}