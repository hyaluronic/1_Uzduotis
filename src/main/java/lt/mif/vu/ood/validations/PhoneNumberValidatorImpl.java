package main.java.lt.mif.vu.ood.validations;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_LENGTH;
import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_PREFIX;

public class PhoneNumberValidatorImpl implements PhoneNumberValidator {

    private ValidationRule validationRule = new ValidationRule(DEFAULT_PREFIX, DEFAULT_LENGTH);

    public PhoneNumberValidatorImpl(){

    }

    public void setValidationRule(ValidationRule validationRule) {
        this.validationRule = validationRule;
    }

    @Override
    public void validate(String phoneNumber) {
        throw new UnsupportedOperationException();
    }
}
