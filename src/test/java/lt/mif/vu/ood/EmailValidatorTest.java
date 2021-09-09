package test.java.lt.mif.vu.ood;

import main.java.lt.mif.vu.ood.domain.Party;
import main.java.lt.mif.vu.ood.exceptions.EmailMissingEtaSignException;
import main.java.lt.mif.vu.ood.exceptions.InvalidEmailCharsException;
import main.java.lt.mif.vu.ood.exceptions.InvalidEmailDomainException;
import main.java.lt.mif.vu.ood.validations.EmailValidator;
import main.java.lt.mif.vu.ood.validations.EmailValidatorImpl;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailValidatorTest {

    private static final Party party = new Party();
    private static final EmailValidator emailValidator = new EmailValidatorImpl();

    @Test
    public void validEmail() {
        party.email = "d@d.com";
        assertDoesNotThrow(() -> emailValidator.validateEmailEtaSign(party.email));
        assertDoesNotThrow(() -> emailValidator.validateEmailSpecialChars(party.email));
        assertDoesNotThrow(() -> emailValidator.validateEmailDomain(party.email));
    }

    @Test(expected = EmailMissingEtaSignException.class)
    public void invalidEmailNoEta() {
        party.password = "dd.com";
        emailValidator.validateEmailEtaSign(party.email);
    }

    @Test(expected = InvalidEmailCharsException.class)
    public void invalidEmailSpecialChars() {
        party.password = "[]@[].com";
        emailValidator.validateEmailSpecialChars(party.email);
    }

    @Test(expected = InvalidEmailDomainException.class)
    public void invalidEmailDomain() {
        party.password = "1Aa!";
        emailValidator.validateEmailDomain(party.email);
    }
}
