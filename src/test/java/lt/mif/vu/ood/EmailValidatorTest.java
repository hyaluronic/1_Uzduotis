package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.exceptions.EmailMissingEtaSignException;
import main.java.lt.mif.vu.ood.exceptions.InvalidEmailCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidEmailDomainException;
import main.java.lt.mif.vu.ood.validations.EmailValidator;
import main.java.lt.mif.vu.ood.validations.EmailValidatorImpl;
import main.ood.domain.Party;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmailValidatorTest {

    private static final Party party = new Party();
    private static final EmailValidator emailValidator = new EmailValidatorImpl();

    @Test
    void validEmail() {
        party.email = "d@d.com";
        assertDoesNotThrow(() -> emailValidator.validateEmailEtaSign(party.email));
        assertDoesNotThrow(() -> emailValidator.validateEmailSpecialChars(party.email));
        assertDoesNotThrow(() -> emailValidator.validateEmailDomain(party.email));
    }

    @Test
    void invalidEmailNoEta() {
        party.password = "dd.com";
        assertThrows(EmailMissingEtaSignException.class, () -> emailValidator.validateEmailEtaSign(party.email));
    }

    @Test
    void invalidEmailSpecialChars() {
        party.password = "[]@[].com";
        assertThrows(InvalidEmailCharsException.class, () -> emailValidator.validateEmailSpecialChars(party.email));
    }

    @Test
    void invalidEmailDomain() {
        party.password = "1Aa!";
        assertThrows(InvalidEmailDomainException.class, () -> emailValidator.validateEmailDomain(party.email));
    }
}
