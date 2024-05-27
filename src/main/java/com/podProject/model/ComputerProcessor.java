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
public class ComputerProcessor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long processorId;

    @Column(unique = true)
    private String name;

    private float performanceCoreClock; // Renamed to match "Performance Core Clock"

    private float performanceCoreBoostClock; // Renamed to match "Performance Core Boost Clock"

    @Column(name = "tdp")
    private int tdp;

    private int coreCount;

    @Column(name = "smt")
    private boolean smt;

    private String integratedGraphics; // Added to match "Integrated Graphics"

    private double price; // Added to match "Price"

    private String socketType; // Added to match "Socket Type"

    public ComputerProcessor(String name, int coreCount, float performanceCoreClock, float performanceCoreBoostClock, int tdp, String integratedGraphics, boolean smt, double price, String socketType) {
        this.name = name;
        this.coreCount = coreCount;
        this.performanceCoreClock = performanceCoreClock;
        this.performanceCoreBoostClock = performanceCoreBoostClock;
        this.tdp = tdp;
        this.integratedGraphics = integratedGraphics;
        this.smt = smt;
        this.price = price;
        this.socketType = socketType;
    }

    public void setProcessorId(long processorId) {
        this.processorId = processorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerformanceCoreClock(float performanceCoreClock) {
        this.performanceCoreClock = performanceCoreClock;
    }

    public void setPerformanceCoreBoostClock(float performanceCoreBoostClock) {
        this.performanceCoreBoostClock = performanceCoreBoostClock;
    }

    public void setTDP(int tdp) {
        this.tdp = tdp;
    }

    public void setCoreCount(int coreCount) {
        this.coreCount = coreCount;
    }

    public void setSmt(boolean smt) {
        this.smt = smt;
    }

    public void setIntegratedGraphics(String integratedGraphics) {
        this.integratedGraphics = integratedGraphics;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSocketType(String socketType) {
        this.socketType = socketType;
    }

    public long getProcessorId() {
        return processorId;
    }

    public String getName() {
        return name;
    }

    public float getPerformanceCoreClock() {
        return performanceCoreClock;
    }

    public float getPerformanceCoreBoostClock() {
        return performanceCoreBoostClock;
    }

    public int getTDP() {
        return tdp;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public boolean isSmt() {
        return smt;
    }

    public String getIntegratedGraphics() {
        return integratedGraphics;
    }

    public double getPrice() {
        return price;
    }

    public String getSocketType() {
        return socketType;
    }

    @Override
    public String toString() {
        return "ComputerProcessor{" +
                "processorId=" + processorId +
                ", name='" + name + '\'' +
                ", performanceCoreClock=" + performanceCoreClock +
                ", performanceCoreBoostClock=" + performanceCoreBoostClock +
                ", TDP=" + tdp +
                ", coreCount=" + coreCount +
                ", integratedGraphics='" + integratedGraphics + '\'' +
                ", smt=" + smt +
                ", price=" + price +
                ", socketType='" + socketType + '\'' +
                '}';
    }
}
