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
@Table(name = "futures")
public class Futures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "futures_id")
    private Restaurant restaurant;

    private int avgPrice;

    private boolean wifiExists;

    private boolean childFood;

    private boolean dressCode;

    private boolean takeawayFood;
}
