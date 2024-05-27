package com.podProject.config;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.podProject.model.*;
import com.podProject.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class InitialStartupConfig {
    @Autowired
    private computerProcessorRepo computerProcessorRepo;

    @Autowired
    private computerCaseRepo computerCaseRepo;

    @Autowired
    private memoryRepo memoryRepo;

    @Autowired
    private psuRepo powerSupplyRepo;

    @Autowired
    private storageRepo storageRepo;

    @Autowired
    private motherBoardRepo motherBoardRepo;

    @Autowired
    private coolerRepo coolerRepo;

    @Autowired
    private videoCardRepo videoCardRepo;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final String JSON_DIR = "src/main/resources/json/";

    String fileSeparator = FileSystems.getDefault().getSeparator();

    private static final Logger logger = LogManager.getLogger(InitialStartupConfig.class);
    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public InitialStartupConfig(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    @Transactional
    public void init() throws IOException {

        initializeData(ComputerProcessor.class, computerProcessorRepo, "CPU.json");
        initializeData(ComputerCase.class, computerCaseRepo, "COMPUTERCASE.json");
        initializeData(Memory.class, memoryRepo, "RAM.json");
        initializeData(Storage.class, storageRepo, "STORAGE.json");
        initializeData(PowerSupply.class, powerSupplyRepo, "PSU.json");
        initializeData(MotherBoard.class, motherBoardRepo, "MOBO.json");
        initializeData(Cooler.class, coolerRepo, "COOLER.json");
        initializeData(VideoCard.class, videoCardRepo, "GPU.json");
    }

    @PostConstruct
    @Transactional
    public void createAdminAccount() {
            // Check if a specific admin account already exists
            if (adminRepository.findByAdminusername("admin").isEmpty()) {
                Admin admin = new Admin();
                admin.setAdminusername("admin");
                admin.setAdminpassword(passwordEncoder.encode("123")); // Use a strong default password
                adminRepository.save(admin);

        }
    }

    @Transactional
    private <T> void initializeData(Class<T> type, JpaRepository<T, Long> repository, String jsonFileName) throws IOException {
        List<T> existing = repository.findAll();
        if (existing.isEmpty()) {
            List<T> items = loadJsonData(type, JSON_DIR + jsonFileName);
            repository.saveAll(items);
            for (T item : items) {
                logger.info("Item class: " + item.getClass().getName());
            }
            logger.info("Loaded " + items.size() + " items of " + type.getSimpleName());
        }
    }

    private <T> List<T> loadJsonData(Class<T> type, String filePath) throws IOException {
        try {
            String properPath = filePath.replace("/", fileSeparator);
            File file = new File(properPath);
            logger.info("Loading JSON file from: " + file.getPath());
            JavaType javaType = TypeFactory.defaultInstance().constructCollectionType(List.class, type);
            List<T> items = objectMapper.readValue(file, javaType);
            logger.info((items));
            return items;
        } catch (IOException e) {
            logger.error("Failed to load or parse JSON file: " + filePath, e);
            throw e;
        }
    }



}