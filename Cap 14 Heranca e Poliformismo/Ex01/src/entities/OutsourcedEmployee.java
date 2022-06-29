package entities;

public class OutsourcedEmployee extends Employee{

    double additionalCharge;

    public OutsourcedEmployee(String name, int hours, double valuePerHour, double additionalCharge) {
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    public double getAdditionalCharge() {
        return additionalCharge;
    }

    public void setAdditionalCharge(double additionalCharge) {
        this.additionalCharge = additionalCharge;
    }

    //metodo de pagamento para funcionario terceirizado.
    @Override
    public double payment(){
        return super.payment() + additionalCharge * 1.1;
    }
}
