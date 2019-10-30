package pl.coderslab.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

    private int legalAge;

    @Override
    public void initialize(Age age) {
        this.legalAge = age.minAge();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }

        int age = LocalDate.now().getYear() - value;

        return age >= this.legalAge;
    }
}
