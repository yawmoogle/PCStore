package com.podProject.repository;


import com.podProject.model.ComputerProcessor;
import com.podProject.model.MotherBoard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface computerProcessorRepo extends JpaRepository<ComputerProcessor, Long> {
    Optional<ComputerProcessor> findByName(String name);
    List<ComputerProcessor> findBySocketType(String socketCPU);
}
