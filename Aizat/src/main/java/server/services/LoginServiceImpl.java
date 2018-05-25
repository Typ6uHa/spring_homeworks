package server.services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import server.forms.LoginForm;
import server.model.Token;
import server.model.User;
import server.repositories.TokensRepository;
import server.repositories.UsersRepository;
import server.transfer.TokenDto;

import java.util.Optional;

import static server.transfer.TokenDto.from;

@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public TokenDto login(LoginForm loginForm) {
        Optional<User> user = usersRepository.findOneByLogin(loginForm.getLogin());

        if (user.isPresent()) {
            User user1 = user.get();

            if (passwordEncoder.matches(loginForm.getPassword(), user1.getHashPassword())) {
                Token token = Token.builder()
                        .user(user1)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokensRepository.save(token);
                return from(token);
            }
        }
        throw new FatalBeanException("sosi");
    }
}
