package com.MyAssesment.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MyAssesment.Entity.DoctorEntity;



public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer>{
	 List<DoctorEntity> findBySpeciality(String speciality);

}
