package org.workingproject47fs.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class OurValidator implements ConstraintValidator<OurValidation, String> {
    @Override
    public void initialize(OurValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {

        if (password == null) {
            addConstraintViolation(context, "Password cannot be null");
            return false;
        }

        List<String> errors = new ArrayList<>();

        if (password.length() < 8) {
            errors.add("Длина пароля должна быть более 8 символов");
        }

        if (!password.matches(".*[A-Z].*")) {
            errors.add("Пароль должен содержать хотя бы одну большую букву");
        }

        if (!password.matches(".*\\d.*")) {
            errors.add("Пароль должен содержать хотя бы одну цифру");
        }

        // ---------

        if (!errors.isEmpty()){
            for (String error: errors){
                addConstraintViolation(context,error);
            }
            return false;
        }

        return true;
    }

    private void addConstraintViolation(ConstraintValidatorContext context, String message){
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
