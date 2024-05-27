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
public class MotherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String name;

    @Column(name = "socket_cpu")
    private String socketCPU;

    private String formFactor;

    @Column(name = "memory_max")
    private String memoryMax;

    @Column(name = "memory_slots")
    private int memorySlots;

    private String colour;

    private double price;

    public MotherBoard(String name, String socketCPU, String formFactor, String memoryMax, int memorySlots, String colour, double price) {
        this.name = name;
        this.socketCPU = socketCPU;
        this.formFactor = formFactor;
        this.memoryMax = memoryMax;
        this.memorySlots = memorySlots;
        this.colour = colour;
        this.price = price;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSocketCPU() {
        return this.socketCPU;
    }

    public void setSocketCPU(String socketCPU) {
        this.socketCPU = socketCPU;
    }

    public String getFormFactor() {
        return this.formFactor;
    }

    public void setFormFactor(String formFactor) {
        this.formFactor = formFactor;
    }

    public String getMemoryMax() {
        return this.memoryMax;
    }

    public void setMemoryMax(String memoryMax) {
        this.memoryMax = memoryMax;
    }

    public int getMemorySlots() {
        return this.memorySlots;
    }

    public void setMemorySlots(int memorySlots) {
        this.memorySlots = memorySlots;
    }

    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
