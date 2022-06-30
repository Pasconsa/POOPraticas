package entities;

public class Individual extends TaxPayer {

private double seguroSaude ;

    public Individual() {
        super();
    }

    public Individual(String nome, double rendaAnual, double seguroSaude) {
        super(nome, rendaAnual);
        this.seguroSaude = seguroSaude;
    }

    public double getSeguroSaude() {
        return seguroSaude;
    }

    public void setSeguroSaude(double seguroSaude) {
        this.seguroSaude = seguroSaude;
    }

    // Realizar estrutura de decisão =  se a renda anual for menor que 2000 retorne taxa de 15% e subtrai 50% valor gasto saude

    @Override
    public double taxa() {
        if(getRendaAnual() < 2000){
            return getRendaAnual() * 0.15 - seguroSaude * 0.5;
        }
        else{
            return getRendaAnual() * 0.25 - seguroSaude * 0.5;
        }
    }
}
