package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPasswordLengthException;
import main.java.lt.mif.vu.ood.exceptions.PasswordMissingUppercaseLetterException;
import main.java.lt.mif.vu.ood.validations.PasswordValidator;
import main.java.lt.mif.vu.ood.validations.PasswordValidatorImpl;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PasswordValidatorTest {

    private static final PasswordValidator passwordValidator = new PasswordValidatorImpl();

    @Test
    public void validPassword() {
        String password = "123456A59a!@";
        assertDoesNotThrow(() -> passwordValidator.validate(password));
    }

    @Test
    public void validPasswordWithCustomSpecialChars() {
        String password = "123456Aa%^+";
        List<String> specialChars = Arrays.asList("!", "+");
        passwordValidator.setSpecialChars(specialChars);
        assertDoesNotThrow(() -> passwordValidator.validate(password));
    }

    @Test(expected = InvalidPasswordLengthException.class)
    public void invalidPasswordLength() {
        String password = "1Aa!";
        passwordValidator.validate(password);
    }

    @Test(expected = PasswordMissingUppercaseLetterException.class)
    public void invalidPasswordNoUppercase() {
        String password = "1@aaaaaaaaa";
        passwordValidator.validate(password);
    }

    @Test(expected = InvalidPasswordCharsException.class)
    public void invalidPasswordNoSpecialSymbols() {
        String password = "123456Aaa";
        passwordValidator.validate(password);
    }
}
