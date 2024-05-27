package com.podProject.service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.podProject.config.InitialStartupConfig;
import com.podProject.model.*;
import com.podProject.repository.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {
    private static final Logger logger = LogManager.getLogger(ComponentService.class);

    //CPU
    @Autowired
    computerProcessorRepo cpuRepo;

    //cases
    @Autowired
    computerCaseRepo caseRepo;

    //cooler
    @Autowired
    coolerRepo coolerRepo;

    //memory
    @Autowired
    memoryRepo memoryRepo;

    //motherboard
    @Autowired
    motherBoardRepo motherBoardRepo;

    //powerSupply
    @Autowired
    psuRepo psuRepo;

    //storage
    @Autowired
    storageRepo storageRepo;

    //cideoCard
    @Autowired
    videoCardRepo videoCardRepo;



    // display all CPU
    public List<ComputerProcessor> displayAllCpu() {
        return cpuRepo.findAll();
    }

    public List<ComputerCase> displayAllCases() {
        return caseRepo.findAll();
    }

    public List<Cooler> displayAllCoolers() {
        return coolerRepo.findAll();
    }

    public List<Memory> displayAllMemory() {
        return memoryRepo.findAll();
    }

    public List<MotherBoard> displayAllMotherboard() {
        return motherBoardRepo.findAll();
    }

    public List<PowerSupply> displayAllPowerSupply() {
        return psuRepo.findAll();
    }

    public List<Storage> displayAllStorage() {
        return storageRepo.findAll();
    }

    public List<VideoCard> displayAllVideoCards() {
        return videoCardRepo.findAll();
    }

    //findById

    public Optional<ComputerProcessor> getCpuById(long id) {
    	return cpuRepo.findById(id);
    }

    public Optional<ComputerCase> getCaseById(long id) {
    	return caseRepo.findById(id);
    }

    public Optional<Cooler> getCoolerById(long id) {
    	return coolerRepo.findById(id);
    }

    public Optional<Memory> getMemoryById(long id) {
    	return memoryRepo.findById(id);
    }

    public Optional<MotherBoard> getMotherBoardById(long id) {
    	return motherBoardRepo.findById(id);
    }

    public Optional<PowerSupply> getPowerSupplyById(long id) {
    	return psuRepo.findById(id);
    }

    public Optional<Storage> getStorageById(long id) {
    	return storageRepo.findById(id);
    }

    public Optional<VideoCard> getVideoCardById(long id) {
    	return videoCardRepo.findById(id);
    }




    public boolean saveEntry(ComputerProcessor computerProcessor) {
        cpuRepo.save(new ComputerProcessor(computerProcessor.getName(), computerProcessor.getCoreCount(),
                computerProcessor.getPerformanceCoreClock(), computerProcessor.getPerformanceCoreBoostClock(),
                computerProcessor.getTDP(), computerProcessor.getIntegratedGraphics(), computerProcessor.isSmt(),
                computerProcessor.getPrice(), computerProcessor.getSocketType()));
        return true;
    }
    // Method to get CPU socket type by CPU name
    public String getSocketTypeByCPUName(String cpuName) {
        Optional<ComputerProcessor> cpu = cpuRepo.findByName(cpuName);
        if (cpu.isPresent()) {
            return cpu.get().getSocketType();
        }
        return null;
    }

    // Method to get motherboards by socket type
    public List<MotherBoard> getMotherboardsBySocketType(String socketType) {
        return motherBoardRepo.findBySocketCPU(socketType);
    }

    // Method to get motherboard by name
    public String getSocketTypeByMotherboardName(String motherboardName){
        Optional<MotherBoard> motherboard = motherBoardRepo.findByName(motherboardName);
        if (motherboard.isPresent()) {
            return motherboard.get().getSocketCPU();
        }
        return null;
    }
    // Method to get cpu by socket cpu 
    public List<ComputerProcessor> getComputerProcessorsBySocketCPU(String socketCPU){
        return cpuRepo.findBySocketType(socketCPU);
    }

}
