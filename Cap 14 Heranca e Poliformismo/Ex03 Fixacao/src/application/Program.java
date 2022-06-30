package application;


import entities.Individual;
import entities.Juridica;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos sao os contribuintes : ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println(" Informacoes Taxa do contribuinte #" + i);
            System.out.print("Individual ou  Juridico ( i / j) ? ");
            char ch = sc.next().charAt(0);
            System.out.print("Nome = ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Renda Anual : ");
            double rendaAnual = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Seguro Saude: ");
                double getSeguroSaude = sc.nextDouble();
                list.add(new Individual(nome, rendaAnual, getSeguroSaude));
            } else {
                System.out.print("Numero de empregados: ");
                int numerosDeEmpregados = sc.nextInt();
                list.add(new Juridica(nome, rendaAnual, numerosDeEmpregados));
            }
        }

        double sum = 0.0;
        System.out.println();
        System.out.println("TAXAS PAGAS:");
        for (TaxPayer tp : list) {
            double tax = tp.taxa();
            System.out.println(tp.getNome() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TAXAS PAGAS: $ " + String.format("%.2f", sum));
    }

}






