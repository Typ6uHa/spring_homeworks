package ru.kpfu.itis.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.itis.model.Operation;


public class NumberValidator implements Validator {

    Character previousMathAction;

    @Override
    public boolean supports(Class<?> aClass) {
        return Operation.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Operation operation = (Operation) o;


        if (previousMathAction != null && previousMathAction == '/' && Double.parseDouble(operation.getDigit()) == 0.0) {
            errors.rejectValue("digit", "", "На ноль делить нельзя!");
        }

        try {
            Double.parseDouble(operation.getDigit());

        } catch (Exception e) {
            errors.rejectValue("digit", "", "Введены некорректные данные");
        }


    }

    public void setPreviousMathAction(Character previousMathAction) {
        this.previousMathAction = previousMathAction;
    }

}
