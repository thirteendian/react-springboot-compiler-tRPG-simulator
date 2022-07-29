package edu.duke.summer.client.annotation;

import edu.duke.summer.client.dto.SignupDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        SignupDto signupDto = (SignupDto) obj;
        return signupDto.getPassword().equals(signupDto.getReEnterPassword());
    }
}
