package server.services;

import server.forms.UserForm;
import server.model.User;

import java.util.List;

public interface UserService {
    void signUp(UserForm userForm);

    List<User> findAll();

    User findOne(Long userId);
}
