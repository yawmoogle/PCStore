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
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long storageId;

    @Column(unique = true)
    private String name;

    private String capacity;

    @Column(name = "price_per_gb")
    private double pricePerGB;

    private String type;

    private String cache;

    private String formFactor;

    @Column(name = "interface")
    private String storageInterface;

    private double price;

    public Storage(String name, String capacity, double pricePerGB, String type, String cache, String formFactor, String storageInterface, double price) {
        this.name = name;
        this.capacity = capacity;
        this.pricePerGB = pricePerGB;
        this.type = type;
        this.cache = cache;
        this.formFactor = formFactor;
        this.storageInterface = storageInterface;
        this.price = price;
    }


    public String getStorageInterface() {
        return storageInterface;
    }
}
