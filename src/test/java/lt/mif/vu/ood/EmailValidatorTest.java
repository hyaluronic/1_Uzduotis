package test.java.lt.mif.vu.ood;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmailValidatorTest {

    private static final EmailValidator emailValidator = new EmailValidatorImpl();

    @Test
    public void validEmail() {
        String email = "d@d.com";
        assertDoesNotThrow(() -> emailValidator.validate(email));
    }

    @Test(expected = EmailMissingEtaSignException.class)
    public void invalidEmailNoEta() {
        String email = "dd.com";
        emailValidator.validate(email);
    }

    @Test(expected = InvalidEmailCharsException.class)
    public void invalidEmailSpecialChars() {
        String email = "[]@[].com";
        emailValidator.validate(email);
    }

    @Test(expected = InvalidEmailDomainException.class)
    public void invalidEmailDomain() {
        String email = "dd@dd.1a-";
        emailValidator.validate(email);
    }
}
