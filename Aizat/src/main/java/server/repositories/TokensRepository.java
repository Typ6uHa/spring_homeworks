package server.repositories;

import server.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokensRepository extends JpaRepository<Token,Long> {

    Optional<Token> findFirstByValue(String value);

}
