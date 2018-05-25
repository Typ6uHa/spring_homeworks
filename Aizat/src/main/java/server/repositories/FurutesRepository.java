package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Futures;

public interface FurutesRepository extends JpaRepository<Futures,Long> {
}
