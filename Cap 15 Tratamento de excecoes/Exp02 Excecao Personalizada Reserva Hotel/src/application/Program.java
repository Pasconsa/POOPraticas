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
    public static void main(String[] args) throws ParseException { //meu metodo main pode aceitar a excecao throws de parse.
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(sc.next());            //checkin recebe sdf.parse do sc.next mais aceita essa a excessao

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkout = sdf.parse(sc.next());

        if(!checkout.after(checkin)){              //Se checkout não for depois de checkin imprima.
            System.out.println("Error in reservation : Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation (number, checkin, checkout);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkout = sdf.parse(sc.next());

 //Pessima solução para excecao. PELO FATO QUE ESSA SOLUÇÃO LOGICA DEVIA ESTA NA RESERVA E NÃO NO PROGRAMA PRINCIPAL
            Date now = new Date();
            if (checkin.before(now) || checkout.before(now)){
                System.out.println("Error in reservation: Reservation dates for update must be future dates.");
            }
            else if(!checkout.after(checkin)) {
                System.out.println("Error in reservation : Check-out date must be after check-in date");
            }
            else{
                reservation.updateDates(checkin,checkout);
                System.out.println("Reservation: " + reservation);
            }

        }

    }
}
