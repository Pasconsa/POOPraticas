package application;

import entities.Employee;
import entities.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
//Fazer a leitura de N funcionarios até preencher a lista toda
        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + "data:");
            System.out.print("Outsourced (y/n)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name:  ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Hours:  ");
            int hours = sc.nextInt();
            System.out.print("Value Per Hour:  ");
            double valuePerHour = sc.nextDouble();

            //Questionamento do bonus do funcionario terceiro ou apenas pagamento
            if (ch == 'y') {
                System.out.println("Additional charge:  ");
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge); //instancia um novo funcionario terceirizado
                list.add(emp); //adicionamos na lista de novos funcionários.
            }
            else{
                Employee emp = new Employee(name, hours, valuePerHour);
                list.add(emp);
            }

        }

        System.out.println();
        System.out.println("PAYMENTS");
        for (Employee emp : list) {
            System.out.println(emp.getName() + " - $" + String.format("%.2f", emp.payment()) );
        }

    }

}
