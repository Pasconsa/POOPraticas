/*
Objetivos das exceção
Que as datas checkout não é superior a data checkin
Não posso atualizar as datas de reservas se elas não forem futuras .
 */

package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                System.out.print("Room number: ");
                int number = sc.nextInt();

                System.out.print("Check-in date (dd/MM/yyyy): ");
                Date checkin = sdf.parse(sc.next());            //checkin recebe sdf.parse do sc.next mais aceita essa a excessao

                System.out.print("Check-out date (dd/MM/yyyy): ");
                Date checkout = sdf.parse(sc.next());


                Reservation reservation = new Reservation(number, checkin, checkout);
                System.out.println("Reservation: " + reservation);

                System.out.println();
                System.out.println("Enter data to update the reservation: ");
                System.out.print("Check-in date (dd/MM/yyyy): ");
                checkin = sdf.parse(sc.next());
                System.out.print("Check-out date (dd/MM/yyyy): ");
                checkout = sdf.parse(sc.next());

                reservation.updateDates(checkin, checkout);
                System.out.println("Reservation: " + reservation);
            }
            catch (ParseException e) {
                System.out.println("Invalid date format");
            }
            catch (IllegalArgumentException e){
                System.out.println("Error in reservation: " + e.getMessage()); //e.getmessage é a frase que esta reservation class
            }
    }

}
