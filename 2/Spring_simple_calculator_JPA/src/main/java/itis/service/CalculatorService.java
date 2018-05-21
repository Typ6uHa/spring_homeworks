package itis.service;

import itis.model.Calculator;

public interface CalculatorService {

    void addDigit(Double digit);

    void addMathAction(String oper);

    Double getDigit();

    String getMathAction();

    Calculator calculate(Double digit, String operation);

    Double getResult();
}
