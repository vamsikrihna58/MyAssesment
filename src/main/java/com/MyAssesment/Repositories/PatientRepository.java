package com.MyAssesment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyAssesment.Entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Integer>{

}
