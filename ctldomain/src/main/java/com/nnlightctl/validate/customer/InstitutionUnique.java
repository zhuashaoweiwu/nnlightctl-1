package com.nnlightctl.validate.customer;

import com.nnlightctl.validate.process.InstitutionUniqueProcess;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InstitutionUniqueProcess.class)
public @interface InstitutionUnique {
    String message() default "机构名称不唯一";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
