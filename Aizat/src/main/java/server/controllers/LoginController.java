package server.controllers;

import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import server.forms.LoginForm;
import server.model.Login;
import server.model.User;
import server.repositories.UsersRepository;
import server.services.LoginService;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/login")
    public ResponseEntity<Login> login(@RequestBody LoginForm loginForm){
        Optional <User> user = usersRepository.findOneByLogin(loginForm.getLogin());
        if (user.isPresent()){
            User user1 = user.get();
            Login login = new Login(loginService.login(loginForm),user1);
            return ResponseEntity.ok(login);
        }
        throw new FatalBeanException ("sosisa");
    }
}
