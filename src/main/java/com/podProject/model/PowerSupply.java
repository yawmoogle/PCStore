package com.podProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor
public class PowerSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    private String type;

    private String efficiencyRating;

    private int wattage;

    private String modular;

    private String colour;

    private double price;

    public PowerSupply(String name, String type, String efficiencyRating, int wattage, String modular, String colour, double price) {
        this.name = name;
        this.type = type;
        this.efficiencyRating = efficiencyRating;
        this.wattage = wattage;
        this.modular = modular;
        this.colour = colour;
        this.price = price;
    }

}
