package model.exceptions;

public class DomainException extends RuntimeException{

    public DomainException(String msg) {  // Passar menssagem para excessão
        super(msg);
    }
}
