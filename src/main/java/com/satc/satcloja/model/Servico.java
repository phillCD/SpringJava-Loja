package com.satc.satcloja.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Servico extends ItemVendavel{
    @Column(name = "qtde_horas", nullable = false)
    private Double quantidadeHoras;


    public Servico(String descricao, Double valorUnitario, Double quantidadeHoras) {
        super.setDescricao(descricao);
        this.quantidadeHoras = quantidadeHoras;
        super.setValorUnitario(valorUnitario);
    }

    public Double getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(Double quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }

    @Override
    public Boolean getEstocavel() {
        return false;
    }
}

