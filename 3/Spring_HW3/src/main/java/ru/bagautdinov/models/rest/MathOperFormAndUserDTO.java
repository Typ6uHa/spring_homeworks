package ru.bagautdinov.models.rest;

import lombok.Data;
import ru.bagautdinov.forms.MathOperForm;
import ru.bagautdinov.models.User;

@Data
public class MathOperFormAndUserDTO {

    private MathOperForm mathOperForm;
    private User user;
}
