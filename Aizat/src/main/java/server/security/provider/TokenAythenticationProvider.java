package server.security.provider;

import server.security.token.TokenAuthentication;
import server.model.Token;
import server.repositories.TokensRepository;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TokenAythenticationProvider implements AuthenticationProvider {

    @Autowired
    private TokensRepository tokensRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        Optional<Token> tokenCandidate = tokensRepository.findFirstByValue(tokenAuthentication.getName());

        if ( tokenCandidate.isPresent()){
            UserDetails userDetails = userDetailsService.loadUserByUsername(tokenCandidate.get().getUser().getLogin());
            tokenAuthentication.setUserDetails(userDetails);
            tokenAuthentication.setAuthenticated(true);
            return tokenAuthentication;
        } else {
            throw new FatalBeanException("sosi");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return TokenAuthentication.class.equals(aClass);
    }
}
