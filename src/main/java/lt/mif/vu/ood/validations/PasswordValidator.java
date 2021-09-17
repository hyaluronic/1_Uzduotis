package main.java.lt.mif.vu.ood.validations;

import java.util.List;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_SPECIAL_CHARS;

public interface PasswordValidator {

    void setSpecialChars(List<String> specialChars);

    void validate(String password);
}
