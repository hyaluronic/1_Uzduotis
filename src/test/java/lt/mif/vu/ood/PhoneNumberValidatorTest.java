package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberLenghtException;
import main.java.lt.mif.vu.ood.exceptions.InvalidPhoneNumberPrefixException;
import main.java.lt.mif.vu.ood.validations.PhoneNumberValidator;
import main.java.lt.mif.vu.ood.validations.PhoneNumberValidatorImpl;
import main.java.lt.mif.vu.ood.validations.ValidationRule;
import main.ood.domain.Party;
import org.junit.jupiter.api.Test;

import static main.java.lt.mif.vu.ood.utils.PhoneNumberUtils.changePhoneNumberPrefix;
import static org.junit.jupiter.api.Assertions.*;

public class PhoneNumberValidatorTest {

    private static final Party party = new Party();
    private static final PhoneNumberValidator phoneNumberValidator = new PhoneNumberValidatorImpl();

    @Test
    void validPhoneNumber() {
        party.phoneNumber = "+37062121212";
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberSpecialCharacters(party.phoneNumber));
    }

    @Test
    void invalidPhoneNumberPrefix() {
        party.phoneNumber = "+37062121212";
        assertThrows(InvalidPhoneNumberPrefixException.class, () -> phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber));
    }

    @Test
    void invalidPhoneNumberLength() {
        party.phoneNumber = "+3706212121";
        assertThrows(InvalidPhoneNumberLenghtException.class, () -> phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber));
    }

    @Test
    void invalidPhoneNumberBadChars() {
        party.phoneNumber = "+3706212121A";
        assertThrows(InvalidPhoneNumberCharsException.class, () -> phoneNumberValidator.validatePhoneNumberSpecialCharacters(party.phoneNumber));
    }

    @Test
    void phoneNumberPrefixChange() {
        party.phoneNumber = "862121212";
        assertEquals("+37062121212", changePhoneNumberPrefix(party.phoneNumber));
    }

    @Test
    void phoneNumberValidWithRule() {
        ValidationRule validationRule = new ValidationRule();
        validationRule.prefix = "+310";
        validationRule.length = 7;
        party.phoneNumber = "+3106123";
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberPrefix(party.phoneNumber, validationRule));
        assertDoesNotThrow(() -> phoneNumberValidator.validatePhoneNumberLength(party.phoneNumber, validationRule));
    }
}
