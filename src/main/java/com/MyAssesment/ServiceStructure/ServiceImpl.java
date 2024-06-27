package com.MyAssesment.ServiceStructure;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.MyAssesment.Entity.DoctorEntity;
import com.MyAssesment.Entity.PatientEntity;
import com.MyAssesment.RepositoryStructure.RepositoryStrucutre;
import com.MyAssesment.ResponseStructure.ResponseStrucutre;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	private RepositoryStrucutre rs;
	

	@Override
	public ResponseStrucutre<DoctorEntity> addDoctor(DoctorEntity de) {
	return rs.addDoctorAndTheirSpeciality(de);
		}

	@Override
	public ResponseStrucutre<PatientEntity> addPatient(PatientEntity pe) {
		
		return rs.addPatientEntitywithTheirSymptom(pe);
	}

	@Override
	public ResponseStrucutre<List<DoctorEntity>> suggestDoctors(int id) {
		
		return rs.suggestDoctors(id);
	}

	@Override
	public ResponseStrucutre<DoctorEntity> deleteDoctor(int id) {
		return rs.deleteDoctor(id);
		
	}

	@Override
	public ResponseStrucutre<PatientEntity> deletePatient(int id) {
		return rs.deletePatient(id);
	}



}
