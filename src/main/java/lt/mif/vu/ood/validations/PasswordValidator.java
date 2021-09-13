package main.java.lt.mif.vu.ood.validations;

import java.util.List;

import static main.java.lt.mif.vu.ood.validations.ValidationConstants.DEFAULT_SPECIAL_CHARS;

public interface PasswordValidator {

    default void validate(String password) {
        validate(password, DEFAULT_SPECIAL_CHARS);
    }

    void validate(String password, List<String> spacialChars);

}
