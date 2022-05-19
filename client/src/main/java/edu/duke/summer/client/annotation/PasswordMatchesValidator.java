package edu.duke.summer.client.annotation;

import edu.duke.summer.client.Signup;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        //todo
        Signup signup = (Signup) obj;
        return signup.getPassword().equals(signup.getMatchingPassword());
    }
}
