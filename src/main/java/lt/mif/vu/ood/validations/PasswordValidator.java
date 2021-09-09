package main.java.lt.mif.vu.ood.validations;

public interface PasswordValidator {
     void validatePasswordLength(String password);

    void validatePasswordUppercaseLetters(String password);

    void validatePasswordSpecialCharacters(String password);
}
