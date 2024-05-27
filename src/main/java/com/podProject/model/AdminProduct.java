package com.podProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AdminProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long adminProductId;

    private String adminProductName = "[ Input Product Name ]";
    private double adminProductTotalPrice;

    private String cpuName;
    private String cpuPrice;

    private String cpuCoolerName;
    private String cpuCoolerPrice;

    private String motherboardName;
    private String motherboardPrice;

    private String memoryName;
    private String memoryPrice;

    private String storageName;
    private String storagePrice;

    private String videoCardName;
    private String videoCardPrice;

    private String computerCaseName;
    private String computerCasePrice;

    private String powerSupplyName;
    private String powerSupplyPrice;

    public AdminProduct(double adminProductTotalPrice, String cpuName, String cpuPrice, String cpuCoolerName, String cpuCoolerPrice, String motherboardName, String motherboardPrice, String memoryName, String memoryPrice, String storageName, String storagePrice, String videoCardName, String videoCardPrice, String computerCaseName, String computerCasePrice, String powerSupplyName, String powerSupplyPrice) {
        this.adminProductTotalPrice = adminProductTotalPrice;
        this.cpuName = cpuName;
        this.cpuPrice = cpuPrice;
        this.cpuCoolerName = cpuCoolerName;
        this.cpuCoolerPrice = cpuCoolerPrice;
        this.motherboardName = motherboardName;
        this.motherboardPrice = motherboardPrice;
        this.memoryName = memoryName;
        this.memoryPrice = memoryPrice;
        this.storageName = storageName;
        this.storagePrice = storagePrice;
        this.videoCardName = videoCardName;
        this.videoCardPrice = videoCardPrice;
        this.computerCaseName = computerCaseName;
        this.computerCasePrice = computerCasePrice;
        this.powerSupplyName = powerSupplyName;
        this.powerSupplyPrice = powerSupplyPrice;
    }

    public String getAdminProductName() {
        return adminProductName;
    }

    public double getAdminProductTotalPrice() {
        return adminProductTotalPrice;
    }

    public long getAdminProductId() {
        return adminProductId;
    }

    public void setAdminProductId(long adminProductId) {
        this.adminProductId = adminProductId;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public String getCpuPrice() {
        return cpuPrice;
    }

    public void setCpuPrice(String cpuPrice) {
        this.cpuPrice = cpuPrice;
    }

    public String getCpuCoolerName() {
        return cpuCoolerName;
    }

    public void setCpuCoolerName(String cpuCoolerName) {
        this.cpuCoolerName = cpuCoolerName;
    }

    public String getCpuCoolerPrice() {
        return cpuCoolerPrice;
    }

    public void setCpuCoolerPrice(String cpuCoolerPrice) {
        this.cpuCoolerPrice = cpuCoolerPrice;
    }

    public String getMotherboardName() {
        return motherboardName;
    }

    public void setMotherboardName(String motherboardName) {
        this.motherboardName = motherboardName;
    }

    public String getMotherboardPrice() {
        return motherboardPrice;
    }

    public void setMotherboardPrice(String motherboardPrice) {
        this.motherboardPrice = motherboardPrice;
    }

    public String getMemoryName() {
        return memoryName;
    }

    public void setMemoryName(String memoryName) {
        this.memoryName = memoryName;
    }

    public String getMemoryPrice() {
        return memoryPrice;
    }

    public void setMemoryPrice(String memoryPrice) {
        this.memoryPrice = memoryPrice;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStoragePrice() {
        return storagePrice;
    }

    public void setStoragePrice(String storagePrice) {
        this.storagePrice = storagePrice;
    }

    public String getVideoCardName() {
        return videoCardName;
    }

    public void setVideoCardName(String videoCardName) {
        this.videoCardName = videoCardName;
    }

    public String getVideoCardPrice() {
        return videoCardPrice;
    }

    public void setVideoCardPrice(String videoCardPrice) {
        this.videoCardPrice = videoCardPrice;
    }

    public String getComputerCaseName() {
        return computerCaseName;
    }

    public void setComputerCaseName(String computerCaseName) {
        this.computerCaseName = computerCaseName;
    }

    public String getComputerCasePrice() {
        return computerCasePrice;
    }

    public void setComputerCasePrice(String computerCasePrice) {
        this.computerCasePrice = computerCasePrice;
    }

    public String getPowerSupplyName() {
        return powerSupplyName;
    }

    public void setPowerSupplyName(String powerSupplyName) {
        this.powerSupplyName = powerSupplyName;
    }

    public String getPowerSupplyPrice() {
        return powerSupplyPrice;
    }

    public void setPowerSupplyPrice(String powerSupplyPrice) {
        this.powerSupplyPrice = powerSupplyPrice;
    }

}
