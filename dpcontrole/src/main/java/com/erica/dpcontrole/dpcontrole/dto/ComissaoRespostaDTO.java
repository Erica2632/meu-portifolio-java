package com.erica.dpcontrole.dpcontrole.dto;

import com.erica.dpcontrole.dpcontrole.model.Comissao;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;

@Getter @Setter
public class ComissaoRespostaDTO {
    private String nomeFuncionario;
    private String cargoFuncionario;
    private BigDecimal valor;
    private YearMonth competencia;

    public ComissaoRespostaDTO(Comissao comissao) {
        this.nomeFuncionario = comissao.getFuncionario().getNome();
        this.cargoFuncionario = comissao.getFuncionario().getCargo();
        this.valor = comissao.getValor();
        this.competencia = comissao.getCompetencia();
    }
}
