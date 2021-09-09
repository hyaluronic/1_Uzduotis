package main.java.lt.mif.vu.ood.exceptions;

public class InvalidEmailCharsException extends Exception{
    public InvalidEmailCharsException(String errorMessage){
        super(errorMessage);
    }
}
