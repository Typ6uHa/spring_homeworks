package server.forms;

import lombok.Data;

import java.util.Date;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Date birthDate;
}
