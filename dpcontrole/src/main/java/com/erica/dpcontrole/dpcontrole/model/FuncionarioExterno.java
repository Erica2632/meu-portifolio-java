package com.erica.dpcontrole.dpcontrole.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FuncionarioExterno extends Funcionario {

    @OneToMany(mappedBy = "funcionario")
    private List<Comissao> comissoes= new ArrayList<>();

    public List<Comissao> getComissoes() {
        return comissoes;
    }


    public void setComissoes(List<Comissao> comissoes) {
        this.comissoes = comissoes;
    }


}
