package com.erica.dpcontrole.dpcontrole.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter

public class AtualizarFolhaDTO {
    @JsonProperty("diasTrabalhados")
    private Integer diasTrabalhados;
}