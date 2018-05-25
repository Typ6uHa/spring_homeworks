package server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "restaurant_id",insertable = false,updatable = false)
    private Rating rating;

    private String openTime;

    private String closeTime;

    @OneToMany(mappedBy = "restaurant")
    private List<Futures> futuresList;

    private String description;

    private String urlPhoto;

    private String number;

    @OneToMany(mappedBy = "restaurant")
    private List<Review> reviews;

}
