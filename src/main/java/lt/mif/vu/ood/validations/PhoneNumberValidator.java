package main.java.lt.mif.vu.ood.validations;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_LENGTH;
import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_PREFIX;

public interface PhoneNumberValidator {

    void setValidationRule(ValidationRule validationRule);

    void validate(String phoneNumber);
}
