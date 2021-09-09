package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.domain.Party;
import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberLengthException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberPrefixException;
import main.java.lt.mif.vu.ood.validations.PhoneNumberValidator;
import main.java.lt.mif.vu.ood.validations.PhoneNumberValidatorImpl;
import main.java.lt.mif.vu.ood.validations.ValidationRule;
import org.junit.Test;

import static main.java.lt.mif.vu.ood.utils.PhoneNumberUtils.changePhoneNumberPrefix;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneNumberValidatorTest {

    private static final Party party = new Party();
    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidatorImpl();

    @Test
    public void validPhoneNumber() {
        party.phoneNumber = "+37062121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberSpecialCharacters(party.phoneNumber));
    }

    @Test
    public void phoneNumberValidWithRule() {
        ValidationRule validationRule = new ValidationRule();
        validationRule.prefix = "+310";
        validationRule.length = 7;
        party.phoneNumber = "+3106123";
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber, validationRule));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber, validationRule));
    }

    @Test(expected = InvalidPhoneNumberPrefixException.class)
    public void invalidPhoneNumberPrefix() {
        party.phoneNumber = "+37062121212";
        phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber);
    }

    @Test(expected = InvalidPhoneNumberLengthException.class)
    public void invalidPhoneNumberLength() {
        party.phoneNumber = "+3706212121";
        phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber);
    }

    @Test(expected = InvalidPhoneNumberCharsException.class)
    public void invalidPhoneNumberBadChars() {
        party.phoneNumber = "+3706212121A";
        phoneNumberValidator.validatePhoneNumberSpecialCharacters(party.phoneNumber);
    }

    @Test
    public void phoneNumberPrefixChange() {
        party.phoneNumber = "862121212";
        assertEquals("+37062121212", changePhoneNumberPrefix(party.phoneNumber));
    }
}
