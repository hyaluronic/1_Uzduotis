package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPhoneNumberPrefixException extends Exception{
    public InvalidPhoneNumberPrefixException(String errorMessage){
        super(errorMessage);
    }
}
