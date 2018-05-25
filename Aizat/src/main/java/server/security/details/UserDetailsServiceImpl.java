package server.security.details;

import server.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Optional<User> userCandidate = usersRepository.findOneByLogin(login);
//
//        if(userCandidate != null) {
//            return new UserDetailsImpl(userCandidate.get());
//        } else throw new IllegalArgumentException("User not found");
        return new UserDetailsImpl(usersRepository.findOneByLogin(login).orElseThrow(IllegalArgumentException::new));
    }
}
