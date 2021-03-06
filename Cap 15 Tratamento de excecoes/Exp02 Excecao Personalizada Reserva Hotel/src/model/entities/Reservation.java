package model.entities;

import model.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private int number;
    private Date checkin;
    private Date checkout;

    //formatar a data para esse formato dd/mm/aaaa
    //static para que outros objetos não seja instanciado
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(int roomNumber, Date checkin, Date checkout)  {
        if (!checkout.after(checkin)) { //programação defensiva evitando erro copilador no construtor
            throw new DomainException( " Check-out date must be after check-in date");
        }
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

    public void updateDates(Date checkin, Date checkout) {

        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates.") ;
        }
        if (!checkout.after(checkin)) {
            throw new DomainException( "Error in reservation : Check-out date must be after check-in date");
        }
        this.checkin = checkin;
        this.checkout = checkout;
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

