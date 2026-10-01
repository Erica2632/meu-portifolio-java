package com.erica.dpcontrole.dpcontrole.dto;
import com.erica.dpcontrole.dpcontrole.model.TipoFuncionario;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class NovoFuncionarioDTO {
    private String nome;
    private String cpf;
    private String pis;
    private LocalDate dataAdmissao;
    private String cargo;
    private BigDecimal salarioBase;
    private TipoFuncionario tipoFuncionario;
}
