/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoscarros;

import Model.Aluguel;
import Model.Carro;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import service.ServicoDeAluguel;
import service.TaxaDoBrasil;

/**
 *
 * @author pedro
 */
public class ServicosCarros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

        System.out.print("digite o modelo do carro : ");
        String modeloDoCarro = sc.nextLine();
        System.out.print("digite o inicio do aluguel (dd/mm/yyyy hh/ss) : ");
        Date inicioDoAluguel = sdf.parse(sc.nextLine());
        System.out.print("digite o fim do aluguel (dd/mm/yyyy hh/ss) : ");
        Date fimDoAluguel = sdf.parse(sc.nextLine());

        Aluguel aluguel = new Aluguel(inicioDoAluguel, fimDoAluguel, new Carro(modeloDoCarro));

        System.out.print("digite o preco por hora : ");
        double precoPorHora = sc.nextDouble();
        System.out.print("digite o proco por dia : ");
        double preocoPorDia = sc.nextDouble();

        ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorHora, preocoPorDia, new TaxaDoBrasil());

        servicoDeAluguel.processarFatura(aluguel);
        System.out.println("FATURA");
        System.out.println("pagamento base : " + String.format("%.2f", aluguel.getFatura().getPagamentoBase()));
        System.out.println("taxa : " + String.format("%.2f", aluguel.getFatura().getTaxa()));
        System.out.println("pagamento total : " + String.format("%.2f", aluguel.getFatura().valorTotal()));

        sc.close();
    }

}
