package test.java.lt.mif.vu.ood;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PhoneNumberValidatorTest {

    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidatorImpl();

    @Test
    public void validPhoneNumber() {
        String phoneNumber = "862121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validate(phoneNumber));
    }

    @Test
    public void validNormalizedPhoneNumber() {
        String phoneNumber = "+37062121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validate(phoneNumber));
    }

    @Test
    public void phoneNumberValidWithCustomRule() {
        String phoneNumber = "+3106123";
        ValidationRule validationRule = new ValidationRule("+310", 7);
        phoneNumberValidator.setValidationRule(validationRule);
        assertDoesNotThrow(() -> phoneNumberValidator.validate(phoneNumber));
    }

    @Test(expected = InvalidPhoneNumberPrefixException.class)
    public void invalidPhoneNumberPrefix() {
        String phoneNumber = "+37562121212";
        phoneNumberValidator.validate(phoneNumber);
    }

    @Test(expected = InvalidPhoneNumberLengthException.class)
    public void invalidPhoneNumberLength() {
        String phoneNumber = "+3706212121";
        phoneNumberValidator.validate(phoneNumber);
    }

    @Test(expected = InvalidPhoneNumberCharsException.class)
    public void invalidPhoneNumberBadChars() {
        String phoneNumber = "+3706212121A";
        phoneNumberValidator.validate(phoneNumber);
    }
}
