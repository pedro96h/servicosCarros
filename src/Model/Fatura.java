/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author pedro
 */
public class Fatura {

    private double pagamentoBase;
    private double taxa;

    public Fatura() {
    }

    public Fatura(double pagamentoBase, double taxa) {
        this.pagamentoBase = pagamentoBase;
        this.taxa = taxa;
    }

    public double getPagamentoBase() {
        return pagamentoBase;
    }

    public void setPagamentoBase(double pagamentoBase) {
        this.pagamentoBase = pagamentoBase;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double valorTotal() {
        return this.pagamentoBase + this.taxa;
    }
}
