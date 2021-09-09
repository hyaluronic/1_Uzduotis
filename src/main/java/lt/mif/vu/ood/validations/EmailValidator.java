package main.java.lt.mif.vu.ood.validations;

public interface EmailValidator {
    void validateEmailEtaSign(String email);

    void validateEmailSpecialChars(String email);

    void validateEmailDomain(String email);
}
