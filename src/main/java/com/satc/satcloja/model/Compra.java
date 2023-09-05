package com.satc.satcloja.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Compra extends EntityId implements OperacaoFinanceira {
    @Column(name = "dt_compra")
    private LocalDate dataCompra;
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    @Column(name = "observacao")
    private String observacao;
    @OneToMany(mappedBy = "compra")
    private List<ItemCompra> itens = new ArrayList<>();

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {this.dataCompra = dataCompra;}

    public Fornecedor getFornecedor() {return fornecedor;}

    public void setFornecedor(Fornecedor fornecedor) {this.fornecedor = fornecedor;}

    public String getObservacao() {return observacao;}

    public void setObservacao(String observacao) {this.observacao = observacao;}

    public List<ItemCompra> getItens() {return itens;}

    public void setItens(List<ItemCompra> itens) {this.itens = itens;}

    public void addItemCompra(ItemCompra item) {this.itens.add(item);}

    @Override
    public LocalDate getDataOperacao() {
        return this.getDataCompra();
    }

    @Override
    public Double getValorTotalOperacao() {
        return getItens().stream().mapToDouble(ItemCompra::getValorCalculado).sum();
    }

    @Override
    public TipoOperacao getTipoOperacao(OperacaoFinanceira op) {
        return TipoOperacao.DEBITO;
    }
}