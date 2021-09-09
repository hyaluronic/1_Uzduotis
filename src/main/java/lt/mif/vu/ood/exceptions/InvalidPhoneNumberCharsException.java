package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPhoneNumberCharsException extends Exception{
    public InvalidPhoneNumberCharsException(String errorMessage){
        super(errorMessage);
    }
}
