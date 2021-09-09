package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPasswordCharsException extends Exception{
    public InvalidPasswordCharsException(String errorMessage){
        super(errorMessage);
    }
}
