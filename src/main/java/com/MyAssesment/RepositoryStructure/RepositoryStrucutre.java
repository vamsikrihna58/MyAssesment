package com.MyAssesment.RepositoryStructure;

import java.util.List;

import com.MyAssesment.Entity.DoctorEntity;
import com.MyAssesment.Entity.PatientEntity;
import com.MyAssesment.ResponseStructure.ResponseStrucutre;



public interface RepositoryStrucutre {
	ResponseStrucutre<DoctorEntity> addDoctorAndTheirSpeciality(DoctorEntity de);
	ResponseStrucutre<PatientEntity> addPatientEntitywithTheirSymptom(PatientEntity pe);
	ResponseStrucutre<List<DoctorEntity>> suggestDoctors(int id);
    ResponseStrucutre<DoctorEntity> deleteDoctor(int id);
    ResponseStrucutre<PatientEntity> deletePatient(int id);
		

}
