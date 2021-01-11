package ru.sealoftime.web.secondlab.constraints;

import javax.validation.Constraint;
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

}
