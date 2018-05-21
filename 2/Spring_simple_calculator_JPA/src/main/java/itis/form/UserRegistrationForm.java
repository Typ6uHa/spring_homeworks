package itis.form;


import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Size;

@Data
@ScriptAssert(lang = "javascript", script = "_this.repassword.equals(_this.password)", message = "Пароли должны совпадать")
public class UserRegistrationForm {

    @NotEmpty(message = "Логин не может быть пустым")
    private String username;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String password;

    private String repassword;

    @NotEmpty
    @Email(message = "Невалидный email")
    private String email;
}
