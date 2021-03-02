package ru.sealoftime.thirdlab.constraints;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = {DoubleMinMaxValidator.class})
@Documented
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE ,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleMinMax {

    double max();
    double min();

    String message() default "Not a valid value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


    @Target({ElementType.METHOD,
            ElementType.FIELD,
            ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR,
            ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        DoubleMinMax[] value();

    }
}
