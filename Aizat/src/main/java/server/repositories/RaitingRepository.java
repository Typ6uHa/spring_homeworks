package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Rating;

public interface RaitingRepository extends JpaRepository<Rating, Long> {
}
