package main.java.lt.mif.vu.ood.validations;

import java.util.HashMap;
import java.util.Map;

public interface PhoneNumberValidator {
    default void validatePhoneNumberPrefix(String phoneNumber){
        validatePhoneNumberPrefix(phoneNumber, null);
    }

    void validatePhoneNumberPrefix(String phoneNumber, ValidationRule s);

    default void validatePhoneNumberLength(String phoneNumber){
        validatePhoneNumberLength(phoneNumber, null);
    }

    void validatePhoneNumberLength(String phoneNumber, ValidationRule s);

    void validatePhoneNumberSpecialCharacters(String phoneNumber);
}
