package ru.sealoftime.web.thirdlab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleInListValidator implements ConstraintValidator<DoubleInList, Double> {
    private double[] values;

    @Override
    public void initialize(DoubleInList doubleInListAnnotation) {
        values = doubleInListAnnotation.value();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        for(double possibleValue : values)
          if(value == possibleValue)
            return true;
        return false;
    }
}
