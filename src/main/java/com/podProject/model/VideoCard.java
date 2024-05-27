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
public class VideoCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    private String chipset;

    private String memory;

    @Column(name = "core_clock")
    private String coreClock;

    @Column(name = "boost_clock")
    private String boostClock;

    private String colour;

    private String length;

    private double price;

    public VideoCard(String name, String chipset, String memory, String coreClock, String boostClock, String colour, String length, double price) {
        this.name = name;
        this.chipset = chipset;
        this.memory = memory;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.colour = colour;
        this.length = length;
        this.price = price;
    }

    // Getters and setters are provided by Lombok @Data annotation
    // toString method is also provided by the @Data annotation
}
