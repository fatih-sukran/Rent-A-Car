package io.fatih.RentACar.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "plate")
    private String plate;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "kilometer")
    private int kilometer;

    @Column(name = "is_available")
    private boolean isAvailable;

    @Column(name = "daily_price")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
