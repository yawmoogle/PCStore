package com.podProject.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor
public class ComputerCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long caseId;

    @Column(unique = true)
    private String name;

    private String type;

    private String colour;

    private String powerSupply;

    private String sidePanel;

    private String externalVolume;

    private int internal35Bays;

    private double price;

    public ComputerCase(String name, String type, String colour, String powerSupply, String sidePanel,
                        String externalVolume, int internal35Bays, double price) {
        this.name = name;
        this.type = type;
        this.colour = colour;
        this.powerSupply = powerSupply;
        this.sidePanel = sidePanel;
        this.externalVolume = externalVolume;
        this.internal35Bays = internal35Bays;
        this.price = price;
    }

    public long getCaseId() {
        return caseId;
    }

    public void setCaseId(long caseId) {
        this.caseId = caseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getSidePanel() {
        return sidePanel;
    }

    public void setSidePanel(String sidePanel) {
        this.sidePanel = sidePanel;
    }

    public String getExternalVolume() {
        return externalVolume;
    }

    public void setExternalVolume(String externalVolume) {
        this.externalVolume = externalVolume;
    }

    public int getInternal35Bays() {
        return internal35Bays;
    }

    public void setInternal35Bays(int internal35Bays) {
        this.internal35Bays = internal35Bays;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComputerCase{" +
                "caseId=" + caseId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", powerSupply='" + powerSupply + '\'' +
                ", sidePanel='" + sidePanel + '\'' +
                ", externalVolume='" + externalVolume + '\'' +
                ", internal35Bays=" + internal35Bays +
                ", price=" + price +
                '}';
    }
}
