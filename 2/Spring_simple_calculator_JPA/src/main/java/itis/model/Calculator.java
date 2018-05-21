package itis.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Calculator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = "^[0-9]*[.]?[0-9]+$", message = "Введены некорректные данные")
    private String digit;

    private String operation;

    @ManyToOne
    private User user;

    public Calculator(String digit, String operation, User user) {
        this.digit = digit;
        this.operation = operation;
        this.user = user;
    }
}
