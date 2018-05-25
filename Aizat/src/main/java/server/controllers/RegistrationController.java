package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import server.forms.UserForm;
import server.services.UserService;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserForm> login(@RequestBody UserForm userForm){
        userService.signUp(userForm);
        return ResponseEntity.ok().build();
    }
}
