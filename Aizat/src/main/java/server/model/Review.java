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
@Table(name = "review_db")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "review_id",insertable = false,updatable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "review_id",insertable = false,updatable = false)
    private User user;

    private String rewiew;
}
