package com.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

//валидатор, обрабатывающий значение
public class CheckEmailValidator
        implements ConstraintValidator<CheckEmail,String> { //в констреин валидатоме мы должны указать два джинерика
        //CheckEmail - сама валидация, которая будет обрабатывать CheckEmailValidator, и
        // String - тип данных, к которому будет применяться валидация

    private  String endOfEmail;


    @Override
    public void initialize(CheckEmail checkEmail)
    {
        endOfEmail = checkEmail.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext)
    {
        System.out.println("enteredValue " + enteredValue);
        return enteredValue.endsWith(endOfEmail);
    }
}
