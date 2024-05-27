package com.podProject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor  // Since you are using Lombok, you can use this for easier no-args constructor generation
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memoryId;

    @Column(unique = true)  // Assuming the name should be unique
    private String name;

    private int speed;  // Assuming this should be an integer as per your data setup

    @Column(name = "modules")
    private String modules;  // Using string to describe e.g., "2 x 16GB"

    @Column(name = "price_per_gb")
    private double pricePerGB;  // Should be a numerical type for easier calculations

    @Column
    private String colour;

    @Column(name = "first_word_latency")
    private String firstWordLatency;  // Kept as string because it includes units (ns)

    private int casLatency;

    private double price;  // Price as a double for accurate financial calculations

    // You might want to add a constructor for initialization if not using setters
    public Memory(String name, int speed, String modules, double pricePerGB, String colour, String firstWordLatency, int casLatency, double price) {
        this.name = name;
        this.speed = speed;
        this.modules = modules;
        this.pricePerGB = pricePerGB;
        this.colour = colour;
        this.firstWordLatency = firstWordLatency;
        this.casLatency = casLatency;
        this.price = price;
    }

}
