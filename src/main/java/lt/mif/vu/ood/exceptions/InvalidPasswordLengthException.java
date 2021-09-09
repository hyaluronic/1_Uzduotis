package main.java.lt.mif.vu.ood.exceptions;

public class InvalidPasswordLengthException extends Exception{
    public InvalidPasswordLengthException(String errorMessage){
        super(errorMessage);
    }
}
