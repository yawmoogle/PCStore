package com.podProject.repository;

import com.podProject.model.MotherBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface motherBoardRepo extends JpaRepository<MotherBoard, Long> {
        List<MotherBoard> findBySocketCPU(String socketType);
        Optional<MotherBoard> findByName(String motherboardName);
}

