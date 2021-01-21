package ru.sealoftime.web.secondlab.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DoubleMinMaxValidator implements ConstraintValidator<DoubleMinMax, Double> {
    private double min;
    private double max;

    @Override
    public void initialize(DoubleMinMax minMaxAnnotation) {
        this.min = minMaxAnnotation.min();
        this.max = minMaxAnnotation.max();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        return (value - this.min >= 0) && (this.max - value >= 0) ;
    }
}
