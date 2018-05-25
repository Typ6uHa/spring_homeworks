package server.repositories;

import server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User,Long> {
    List<User> findAllByFirstName(String firstName);
    Optional<User> findOneByLogin(String login);
    Optional<User> findOneById(Long id);
}
