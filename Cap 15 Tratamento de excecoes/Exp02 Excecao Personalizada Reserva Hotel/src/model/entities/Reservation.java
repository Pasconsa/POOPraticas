package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.SimpleFormatter;

public class Reservation {
    private int number;
    private Date checkin;
    private Date checkout;

    //formatar a data para esse formato dd/mm/aaaa
    //static para que outros objetos não seja instanciado
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(int roomNumber, Date checkin, Date checkout) {
        this.number = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }


    public int getRoomNumber() {
        return number;
    }

    public void setRoomNumber(int roomNumber) {
        this.number = number;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getChekout() {
        return checkout;
    }


    public long duration() {
        long diff = checkout.getTime() - checkin.getTime();  // pega a diferença das duas datas em mili segundos.
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);  // converter mili segundos em dias

    }

    public String updateDates(Date checkin, Date checkout) {


        /* Solução 2 (ruim): método retornando string
• A semântica da operação é prejudicada
• Retornar string não tem nada a ver com atualização de reserva
• E se a operação tivesse que retornar um string?
• Ainda não é possível tratar exceções em construtores
• Ainda não há auxílio do compilador: o programador deve "lembrar" de verificar se houve erro
• A lógica fica estruturada em condicionais aninhadas*/

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            return "Error in reservation: Reservation dates for update must be future dates.";
        }
        if (!checkout.after(checkin)) {
            return "Error in reservation : Check-out date must be after check-in date";
        }
        this.checkin = checkin;
        this.checkout = checkout;
        return null;
    }


    //to string impressão
    @Override
    public String toString() {
        return "Room "
                + number
                + ", check-in: "
                + sdf.format(checkin)
                + ", check-out: "
                + sdf.format(checkout)
                + " "
                + duration()
                + " nights";
    }


}

