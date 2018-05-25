package server.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "rating")
    private Restaurant restaurant;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long countUserAnswers;

    private float rating;


}
