package com.podProject.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseComponentRepository<T, ID> extends JpaRepository<T, ID>{


    // find all components by id
    <S extends T> List<S> findAll(Example<S> example);

    Optional<T> findById(ID id);

    Optional<T> findByName(String name);


}
