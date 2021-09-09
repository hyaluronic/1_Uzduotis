package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPhoneNumberLengthException extends Exception{
    public InvalidPhoneNumberLengthException(String errorMessage){
        super(errorMessage);
    }
}
