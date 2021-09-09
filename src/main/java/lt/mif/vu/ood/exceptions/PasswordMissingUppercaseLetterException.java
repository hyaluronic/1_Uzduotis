package main.java.lt.mif.vu.ood.exceptions;

public class PasswordMissingUppercaseLetterException extends Exception{
    public PasswordMissingUppercaseLetterException(String errorMessage){
        super(errorMessage);
    }
}
