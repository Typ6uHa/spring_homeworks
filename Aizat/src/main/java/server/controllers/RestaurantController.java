package server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import server.model.Restaurant;
import server.repositories.RestaurantRepository;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurant() {
        return restaurantRepository.findAll();
    }

    @PostMapping("/restaurant/{restaurant-name}")
    public Restaurant getOneRestaurant(@PathVariable("restaurant-name") String name) {
        return restaurantRepository.findFirstByName(name);
    }
}
