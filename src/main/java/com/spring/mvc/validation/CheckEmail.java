package com.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //Target указывает на область, у чему применяется аннотация, т.е. к полю
@Retention(RetentionPolicy.RUNTIME)//информация об этой аннотации должная сохраняться до выполнения кода, до ран-тайм
@Constraint(validatedBy = CheckEmailValidator.class) //этот класс будет обрадатывать аннотацию, это свой созданный класс
public @interface CheckEmail { //аннотация, это не класс
    public String value() default "xyz.com";
    public String message() default "email must ends with xyz.com";

    // при создании своей аннотации эти две строки ниже просто нужно дабавлять в свою анннотацию обязательно
    public Class<?>[] groups() default {}; // позволяет разбивать аннотации по группам
    public Class<? extends Payload>[] payload() default {}; //перенос информации о метаданных клиента
}
