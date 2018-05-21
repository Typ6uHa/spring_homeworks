package itis.model;

import itis.model.enums.UserRole;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name = "user_gen", sequenceName = "users_seq", allocationSize = 1)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    private long id;

    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
