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
public class Cooler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(name = "fan_rpm")
    private String fanRPM;

    @Column(name = "noise_level")
    private String noiseLevel;

    private String colour;

    @Column(name = "radiator_size")
    private String radiatorSize;

    private double price;

    public Cooler(String name, String fanRPM, String noiseLevel, String colour, String radiatorSize, double price) {
        this.name = name;
        this.fanRPM = fanRPM;
        this.noiseLevel = noiseLevel;
        this.colour = colour;
        this.radiatorSize = radiatorSize;
        this.price = price;
    }

    public String getFanRPM() {
        return fanRPM;
    }
    // Getters and setters are provided by Lombok @Data annotation
    // toString method is also provided by the @Data annotation
}
