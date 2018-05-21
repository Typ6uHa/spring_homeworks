package ru.bagautdinov.forms.mappers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.bagautdinov.forms.UserRegistrationForm;
import ru.bagautdinov.models.User;
import ru.bagautdinov.models.enums.UserRoles;

public class UserRegistrationFormMapper {

    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static User transform(UserRegistrationForm form) {
        User user = new User();
        user.setRole(UserRoles.ROLE_USER);
        user.setEmail(form.getEmail());
        user.setPassword(encoder.encode(form.getPassword()));
        return user;
    }
}
