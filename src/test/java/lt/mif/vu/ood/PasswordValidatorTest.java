package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.domain.Party;
import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordLengthException;
import main.java.lt.mif.vu.ood.exceptions.PasswordMissingUppercaseLetterException;
import main.java.lt.mif.vu.ood.validations.PasswordValidator;
import main.java.lt.mif.vu.ood.validations.PasswordValidatorImpl;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PasswordValidatorTest {

    private static final Party party = new Party();
    private static final PasswordValidator passwordValidator = new PasswordValidatorImpl();

    @Test
    public void validPassword() {
        party.password = "123456Aa!@#";
        assertDoesNotThrow(() -> passwordValidator.validatePasswordLength(party.password));
        assertDoesNotThrow(() -> passwordValidator.validatePasswordUppercaseLetters(party.password));
        assertDoesNotThrow(() -> passwordValidator.validatePasswordSpecialCharacters(party.password));
    }

    @Test(expected = InvalidPasswordLengthException.class)
    public void invalidPasswordLength() {
        party.password = "1Aa!";
        passwordValidator.validatePasswordLength(party.password);
    }

    @Test(expected = PasswordMissingUppercaseLetterException.class)
    public void invalidPasswordNoUppercase() {
        party.password = "1@aaaaaaaaa";
        passwordValidator.validatePasswordUppercaseLetters(party.password);
    }

    @Test(expected = InvalidPasswordCharsException.class)
    public void invalidPasswordNoSpecialSymbols() {
        party.password = "123456Aaa";
        passwordValidator.validatePasswordSpecialCharacters(party.password);
    }
}
