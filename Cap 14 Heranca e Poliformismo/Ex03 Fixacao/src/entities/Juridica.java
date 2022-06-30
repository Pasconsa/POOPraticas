package entities;

import entities.TaxPayer;

public class Juridica extends TaxPayer {

   private int numerosDeEmpregados;

   public Juridica (){
   super();
   }

    public Juridica(String nome, double rendaAnual, int numerosDeEmpregados) {
        super(nome, rendaAnual);
        this.numerosDeEmpregados = numerosDeEmpregados;
    }

    public int getNumerosDeEmpregados() {
        return numerosDeEmpregados;
    }

    public void setNumerosDeEmpregados(int numerosDeEmpregados) {
        this.numerosDeEmpregados = numerosDeEmpregados;
    }

    @Override
    public double taxa() {
        if (numerosDeEmpregados > 10) {
            return getRendaAnual() * 0.14;
        } else {
            return getRendaAnual() * 0.16;
        }
    }
}
