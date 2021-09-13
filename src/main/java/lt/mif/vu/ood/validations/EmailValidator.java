package main.java.lt.mif.vu.ood.validations;

import java.util.List;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_SPECIAL_CHARS;

public interface EmailValidator {

    void validate(String email);
}
