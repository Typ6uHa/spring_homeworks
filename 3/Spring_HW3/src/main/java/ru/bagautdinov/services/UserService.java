package ru.bagautdinov.services;

import ru.bagautdinov.forms.UserRegistrationForm;
import ru.bagautdinov.models.User;

public interface UserService {
    void saveNewUser(UserRegistrationForm form);
    User getUserWithEmail(String email);
}
