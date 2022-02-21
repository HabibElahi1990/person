package com.example.calcDraft.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NationalCodeConstraint implements ConstraintValidator<NationalCode,String> {
    @Override
    public void initialize(NationalCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value==null || value.isEmpty()){
            throw new IllegalArgumentException("invalid nationalCode value");
        }
        if (value.length()!=10){
            throw new IllegalArgumentException("invalid nationalCode size");
        }
        if (!checkPattern(value)){
            throw new IllegalArgumentException("invalid nationalCode char");
        }
        return true;
    }

    private boolean checkPattern(String value){
        Pattern pattern=Pattern.compile("[\\d]{10}");
        Matcher m=pattern.matcher(value);
        return m.matches();
    }
}
