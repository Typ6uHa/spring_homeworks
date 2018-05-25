package server.services;

import server.forms.LoginForm;
import server.transfer.TokenDto;

public interface LoginService {
    TokenDto login(LoginForm loginForm);
}
