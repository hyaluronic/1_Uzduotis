package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.domain.Party;
import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordLengthException;
import main.java.lt.mif.vu.ood.exceptions.PasswordMissingUppercaseLetterException;
import main.java.lt.mif.vu.ood.validations.PasswordValidator;
import main.java.lt.mif.vu.ood.validations.PasswordValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PasswordValidatorTest {

    private static final Party party = new Party();
    private static final PasswordValidator passwordValidator = new PasswordValidatorImpl();

    @Test
    void validPassword() {
        party.password = "123456Aa!@#";
        assertDoesNotThrow(() -> passwordValidator.validatePasswordLength(party.password));
        assertDoesNotThrow(() -> passwordValidator.validatePasswordUppercaseLetters(party.password));
        assertDoesNotThrow(() -> passwordValidator.validatePasswordSpecialCharacters(party.password));
    }

    @Test
    void invalidPasswordLength() {
        party.password = "1Aa!";
        assertThrows(InvalidPasswordLengthException.class, () -> passwordValidator.validatePasswordLength(party.password));
    }

    @Test
    void invalidPasswordNoUppercase() {
        party.password = "1@aaaaaaaaa";
        assertThrows(PasswordMissingUppercaseLetterException.class, () -> passwordValidator.validatePasswordUppercaseLetters(party.password));
    }

    @Test
    void invalidPasswordNoSpecialSymbols() {
        party.password = "123456Aaa";
        assertThrows(InvalidPasswordCharsException.class, () -> passwordValidator.validatePasswordSpecialCharacters(party.password));
    }
}
