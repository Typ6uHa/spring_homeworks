package itis.service;

import org.springframework.stereotype.Service;
import itis.form.UserRegistrationForm;

@Service
public interface UserService {

    void saveNewUser(UserRegistrationForm form);

    void securedMethod();
}
