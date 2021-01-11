package ru.sealoftime.web.secondlab.constraints;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Constraint(validatedBy = {DoubleInListValidator.class})
@Documented
@Target({ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE ,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface DoubleInList {
    //List of doubles, in which the value must lay
    double[] value();
}
