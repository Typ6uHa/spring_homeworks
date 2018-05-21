package ru.kpfu.itis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.model.Operation;
import ru.kpfu.itis.util.NumberValidator;

@Controller
public class CalculatorController {

    @Autowired
    SessionHistory sessionHistory;

    NumberValidator validator = new NumberValidator();

    @RequestMapping("/")
    public String showIndexPage(Model model) {
        Operation operation = new Operation();
        model.addAttribute("operation", operation);

        if (sessionHistory.getPreviousOperation().getDigit() != null) {
            model.addAttribute("history", sessionHistory.getPreviousOperation().getDigit());
        }
        if (sessionHistory.getPreviousOperation().getMathAction() != null && sessionHistory.getPreviousOperation().getMathAction().equals('=')) {
            sessionHistory.setPreviousOperation(new Operation());
        }
        return "calc";
    }


    @RequestMapping(value = "calculate", method = RequestMethod.POST)
    public String calculate(@ModelAttribute Operation operation, BindingResult bindingResult) {

        if (operation.getDigit() != null) {
            validator.setPreviousMathAction(sessionHistory.getPreviousOperation().getMathAction());
        }
        validator.validate(operation, bindingResult);
        if (bindingResult.hasErrors()) {
            return "calc";
        } else {
            if (sessionHistory.getPreviousOperation().getDigit() != null) {
                Double result = count(Double.parseDouble(sessionHistory.getPreviousOperation().getDigit()), Double.parseDouble(operation.getDigit()), sessionHistory.getPreviousOperation().getMathAction());
                sessionHistory.setPreviousOperation(new Operation(result.toString(), operation.getMathAction()));
            } else {
                sessionHistory.setPreviousOperation(new Operation(operation.getDigit(), operation.getMathAction()));
            }
        }
        return "redirect:/";
    }

    public Double count(Double a, Double b, Character mathAction) {

        switch (mathAction) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0.0;
    }
}
