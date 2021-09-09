package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPhoneNumberLenghtException extends Exception{
    public InvalidPhoneNumberLenghtException(String errorMessage){
        super(errorMessage);
    }
}
