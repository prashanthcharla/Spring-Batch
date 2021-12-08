package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.dto.LastName;

@Repository
public interface LastNameRepository extends JpaRepository<LastName, Integer> {

}
