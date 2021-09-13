package main.java.lt.mif.vu.ood.validations;

public class ValidationRule {

    private final String prefix;
    private final int length;

    public ValidationRule(String prefix, int length) {
        this.prefix = prefix;
        this.length= length;
    }
}