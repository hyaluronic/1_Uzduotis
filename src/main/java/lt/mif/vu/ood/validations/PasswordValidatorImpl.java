package main.java.lt.mif.vu.ood.validations;

import java.util.List;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_SPECIAL_CHARS;

public class PasswordValidatorImpl implements PasswordValidator {

    private List<String> specialChars = DEFAULT_SPECIAL_CHARS;

    public PasswordValidatorImpl(){

    }

    @Override
    public void setSpecialChars(List<String> specialChars) {
        this.specialChars = specialChars;
    }

    @Override
    public void validate(String password) {
        throw new UnsupportedOperationException();
    }
}
