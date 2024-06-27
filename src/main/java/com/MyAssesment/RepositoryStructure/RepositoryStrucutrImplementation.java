package com.MyAssesment.RepositoryStructure;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.MyAssesment.Entity.DoctorEntity;
import com.MyAssesment.Entity.PatientEntity;
import com.MyAssesment.Repositories.DoctorRepository;
import com.MyAssesment.Repositories.PatientRepository;
import com.MyAssesment.ResponseStructure.ResponseStrucutre;


@Repository
public class RepositoryStrucutrImplementation implements RepositoryStrucutre {
	@Autowired
	private PatientRepository pr;//RepositoryStructure RepositoryStrucutre
	
	@Autowired
	private DoctorRepository dr;

	@Override
	public ResponseStrucutre<DoctorEntity> addDoctorAndTheirSpeciality(DoctorEntity de) {
		ResponseStrucutre<DoctorEntity> rd = new ResponseStrucutre<>();
		 String city=de.getCity().toUpperCase();
		if(city.equals("DELHI") ||city.equals("NOIDA") ||city.equals("FARIDABAD")  ) {
		 String s= de.getSpeciality().toUpperCase();
		 de.setSpeciality(s);
		 dr.save(de);
		 rd.setData(de);
		 rd.setStatusCode(HttpStatus.OK.value());
		 rd.setMessage("Doctor details are added");
		
		return rd;
	}
		rd.setMessage("Sorry city can have 3 values i.e delhi,noida,faridabad");
		rd.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
		return rd;
	}

	@Override
	public ResponseStrucutre<PatientEntity> addPatientEntitywithTheirSymptom(PatientEntity pe) {
		ResponseStrucutre<PatientEntity> rd = new ResponseStrucutre<>();
		pr.save(pe);
		rd.setData(pe);
		rd.setStatusCode(HttpStatus.OK.value());
		rd.setMessage("Patient details are added");
		
		return rd;
		
	}

	@Override
	public ResponseStrucutre<List<DoctorEntity>> suggestDoctors(int id) {
		Optional<PatientEntity> fi = pr.findById(id);
		String sy= fi.get().getSymptom().toLowerCase();
		String city=fi.get().getCity().toUpperCase();
		ResponseStrucutre<List<DoctorEntity>> rf= new ResponseStrucutre<List<DoctorEntity>>();
		if((city.equals("DELHI") || city.equals("NOIDA") || city.equals("FARIDABAD"))){
 		   if(sy.equals("arthritis") ||sy.equals("back pain")|| sy.equals("tissue injuries") ) {
 	          rf.setData(dr.findBySpeciality("ORTHOPAEDIC"));
 			  rf.setStatusCode(HttpStatus.OK.value());
 			  rf.setMessage("All All doctors details");
 			  return rf;
 		   }
 		   if(sy.equals("ear pain") ||sy.equals("nose pain")|| sy.equals("throat isuue") ) {
 			  rf.setData(dr.findBySpeciality("ENT"));
 			  rf.setStatusCode(HttpStatus.OK.value());
 			  rf.setMessage("All All doctors details");
 			  System.out.println(rf);
 			  return rf;
 			   
 		   }
 		   if(sy.equals("skin infection") ||sy.equals("skin burn") ) {
 			  rf.setData(dr.findBySpeciality("DERMATOLOGY"));
 			  rf.setStatusCode(HttpStatus.OK.value());
 			  rf.setMessage("All All doctors details");
 			  return rf;
 			     
 		   }
 		   if(sy.equals("dysmenorrhea")) {
 			  rf.setData(dr.findBySpeciality("GYNECOLOGY"));
 			  System.out.println(dr.findBySpeciality("Gynecology"));
 			  rf.setStatusCode(HttpStatus.OK.value());
 			  rf.setMessage("All doctors details");
 			  return rf;
 			   
 		   }
 		   else {
 			   rf.setMessage("There isn’t any doctor present  for your symptom");
 			   rf.setStatusCode(HttpStatus.NOT_FOUND.value());
 			   return rf;
 			   
 		   }
 		   
 		   
 		   
 	   }
 	   else {
 		   rf.setStatusCode(HttpStatus.NOT_FOUND.value());
 		   rf.setMessage("We are still waiting to expand to your location");
 		   return rf;
 	   }
 	     
		
		
	
		

	}

	@Override
	public ResponseStrucutre<DoctorEntity> deleteDoctor(int id) {
		ResponseStrucutre<DoctorEntity> rd = new ResponseStrucutre<>();
		Optional<DoctorEntity> findById = dr.findById(id);
		if(findById.isPresent()) {
		dr.deleteById(id);
		rd.setData(findById.get());
		rd.setStatusCode(HttpStatus.OK.value());
		rd.setMessage("doctor details are deleted");
		return rd;
		}
		else {
			rd.setStatusCode(HttpStatus.NOT_FOUND.value());
			rd.setMessage("there is no doctor in this id");
			return rd;
		}
		
	}

	@Override
	public ResponseStrucutre<PatientEntity> deletePatient(int id) {
		ResponseStrucutre<PatientEntity> rd = new ResponseStrucutre<>();
		Optional<PatientEntity> findById = pr.findById(id);
		if(findById.isPresent()) {
		pr.deleteById(id);
		rd.setData(findById.get());
		rd.setStatusCode(HttpStatus.OK.value());
		rd.setMessage("patient details are deleted");
		return rd;
		}
		else {
			rd.setStatusCode(HttpStatus.NOT_FOUND.value());
			rd.setMessage("there is no patient in this id");
			return rd;
		}
	}
	


}
