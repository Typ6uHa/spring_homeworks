package server.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
@Table(name = "user_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    private String login;
    private String hashPassword;

    private Date birthDate;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "userApp")
    private List<Review> review;

    @OneToMany(mappedBy = "userApp")
    List<Token> tokens;
}
