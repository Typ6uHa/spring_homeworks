package ru.bagautdinov.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SequenceGenerator(name = "math_gen", sequenceName = "math_seq", allocationSize = 1)
@Table(name = "math")
@Data
public class MathOper {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "math_gen")
    private long id;

    @NotNull(message="Число не может быть пустым")
    private String number;

    @NotNull(message="Мат. функция не может быть пустой")
    private String function;

    @ManyToOne
    @NotNull(message="Пользователь не может быть пустым")
    @JoinColumn
    private User owner;

    @Override
    public String toString() {
        return "(" + number + ", " + function + ")";
    }
}
