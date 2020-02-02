/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Model.Aluguel;
import Model.Fatura;

/**
 *
 * @author pedro
 */
public class ServicoDeAluguel {

    private double precoPorHora;
    private double precoPorDia;

    private TaxaDoBrasil taxaDoBrasil;

    public ServicoDeAluguel(double precoPorHora, double precoPorDia, TaxaDoBrasil taxaDoBrasil) {
        this.precoPorHora = precoPorHora;
        this.precoPorDia = precoPorDia;
        this.taxaDoBrasil = taxaDoBrasil;
    }

    public void processarFatura(Aluguel aluguel) {
        long t1 = aluguel.getInicio().getTime();
        long t2 = aluguel.getFim().getTime();
        double horas = (double) (t2 - t1) / 1000.0 / 60.0 / 60.0;
        
        System.out.println(Math.ceil(horas));
        double pagamento;
        if (horas <= 12.0) {
            pagamento = Math.ceil(horas) * this.precoPorHora;
        } else {
            pagamento = Math.ceil(horas) * this.precoPorDia;
        }

        double taxa = taxaDoBrasil.taxa(pagamento);

        aluguel.setFatura(new Fatura(pagamento, taxa));
    }

}
