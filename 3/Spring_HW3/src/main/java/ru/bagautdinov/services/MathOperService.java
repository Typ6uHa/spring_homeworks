package ru.bagautdinov.services;

import ru.bagautdinov.models.MathOper;
import ru.bagautdinov.models.User;

import java.util.List;

public interface MathOperService {
    void saveNewOper(User owner, MathOper operation);
    List<Double> getSessionHistory();
}
