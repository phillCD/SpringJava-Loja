package com.satc.satcloja.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Balanco extends EntityId{
    private LocalDate dataBalanco;
    private String responsavel;
    private List<OperacaoFinanceira> operacoes = new ArrayList<>();

    public LocalDate getDataBalanco() {return dataBalanco;}

    public void setDataBalanco(LocalDate dataBalanco) {this.dataBalanco = dataBalanco;}

    public String getResponsavel() {return responsavel;}

    public void setResponsavel(String responsavel) {this.responsavel = responsavel;}

    public List<OperacaoFinanceira> getOperacoes() {return operacoes;}

    public void setOperacoes(List<OperacaoFinanceira> operacoes) {this.operacoes = operacoes;}

    public void addOperacoes(OperacaoFinanceira operacao) {
        this.operacoes.add(operacao);
    }

    public void delOperacoes(OperacaoFinanceira operacao){
        this.operacoes.remove(operacao);
    }

    public void imprimirBalanco(){
        System.out.println("----------------------------------");
        System.out.println("Balanco numero: "+ this.getId());
        System.out.println("Data: "+getDataBalanco());
        System.out.println("Responsavel: "+getResponsavel());
        System.out.println("----------------------------------");
        System.out.println("Itens: ");
        for (OperacaoFinanceira op : this.getOperacoes()){
            System.out.println("Data Operação: " + op.getDataOperacao() + " Tipo Operação: " + op.getTipoOperacao(op) +
                    " Valor Operação: " + op.getValorTotalOperacao());
        }
        System.out.println("----------------------------------");
        System.out.println("Total Debitos: "+ this.getValorTotal(TipoOperacao.DEBITO));
        System.out.println("Total Créditos: "+ this.getValorTotal(TipoOperacao.CREDITO));
        System.out.println("Total: "+ (this.getValorTotal(TipoOperacao.CREDITO) - this.getValorTotal(TipoOperacao.DEBITO)));
    }

    public Double getValorTotal(TipoOperacao tipo) {
        return this.getOperacoes().stream().filter(op -> op.getTipoOperacao(op).equals(tipo))
                .mapToDouble(OperacaoFinanceira::getValorTotalOperacao).sum();
    }

    public String getTipoOpercacao (OperacaoFinanceira operacao){
        if (operacao instanceof Compra){
            return "Compra";
        }

        if (operacao instanceof Venda){
            return "Venda";
        }
        return "Locação";
    }
}
