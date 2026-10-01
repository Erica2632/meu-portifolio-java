package com.erica.dpcontrole.dpcontrole.dto;

import com.erica.dpcontrole.dpcontrole.model.Funcionario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class FuncionarioRespostaDTO {
    private String nome;
    private String cpf;
    private String pis;
    private String cargo;
    private BigDecimal salarioBase;
    private LocalDate dataAdmissao;
    private LocalDate dataDemissao;



    public FuncionarioRespostaDTO(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.cpf = funcionario.getCpf();
        this.pis= funcionario.getPis();
        this.cargo = funcionario.getCargo();
        this.salarioBase = funcionario.getSalarioBase();
        this.dataAdmissao = funcionario.getDataAdmissao();
        this.dataDemissao = funcionario.getDataDemissao();
    }


}