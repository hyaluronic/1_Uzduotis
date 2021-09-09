package main.java.lt.mif.vu.ood.exceptions;

public class InvalidEmailDomainException extends Exception{
    public InvalidEmailDomainException(String errorMessage){
        super(errorMessage);
    }
}
