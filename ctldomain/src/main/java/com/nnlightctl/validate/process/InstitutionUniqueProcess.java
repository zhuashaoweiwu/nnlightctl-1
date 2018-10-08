package com.nnlightctl.validate.process;

import com.nnlightctl.validate.customer.InstitutionUnique;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstitutionUniqueProcess implements ConstraintValidator<InstitutionUnique, String> {

    public InstitutionUniqueProcess() {
        
    }

    @Override
    public void initialize(InstitutionUnique institutionUnique) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if ("hello".equalsIgnoreCase(s)) {
            return true;
        }
        return false;
    }
}
