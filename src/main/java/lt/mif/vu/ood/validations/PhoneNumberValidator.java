package main.java.lt.mif.vu.ood.validations;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_LENGTH;
import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_PREFIX;

public interface PhoneNumberValidator {

    default void validate(String phoneNumber){
        validate(phoneNumber, new ValidationRule(DEFAULT_PREFIX, DEFAULT_LENGTH));
    }

    void validate(String phoneNumber, ValidationRule validationRule);
}
