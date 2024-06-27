package com.MyAssesment.ServiceStructure;

import java.util.List;

import com.MyAssesment.Entity.DoctorEntity;
import com.MyAssesment.Entity.PatientEntity;
import com.MyAssesment.ResponseStructure.ResponseStrucutre;



public interface Service {
	ResponseStrucutre<DoctorEntity> addDoctor(DoctorEntity de);
	ResponseStrucutre<PatientEntity> addPatient(PatientEntity pe);
	ResponseStrucutre<List<DoctorEntity>> suggestDoctors(int id);
	ResponseStrucutre<DoctorEntity> deleteDoctor(int id);
    ResponseStrucutre<PatientEntity> deletePatient(int id);

}
