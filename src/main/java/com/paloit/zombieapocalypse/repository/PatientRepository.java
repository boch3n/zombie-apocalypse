package com.paloit.zombieapocalypse.repository;

import com.paloit.zombieapocalypse.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {}
