package ru.bagautdinov.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;
import ru.bagautdinov.repository.MathOperRepository;
import ru.bagautdinov.services.MathOperService;
import ru.bagautdinov.component.MathComponent;

import java.util.List;

@Service
public class MathOperImpl implements MathOperService {

    @Autowired
    private MathComponent math;

    @Autowired
    private MathOperRepository mathOperRepository;

    @Override
    public void saveNewOper(User owner, MathOper operation) {

        operation.setOwner(owner);
        math.proceedMath(operation);
        mathOperRepository.save(operation);
    }

    @Override
    public List<Double> getSessionHistory() {
        return math.getHistory();
    }
}
