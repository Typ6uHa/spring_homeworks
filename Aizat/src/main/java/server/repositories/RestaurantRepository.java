package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import server.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    Restaurant findFirstByName(String name);
}
