package com.MyAssesment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyAssesment.Entity.DoctorEntity;
import com.MyAssesment.Entity.PatientEntity;
import com.MyAssesment.ResponseStructure.ResponseStrucutre;
import com.MyAssesment.ServiceStructure.Service;
@RestController
@RequestMapping("/App")
public class ControllerClass {

	@Autowired
	private Service sr;
	
	@PostMapping("/saveDoctor")
	public @ResponseBody ResponseStrucutre<DoctorEntity> addDoctor(@RequestBody DoctorEntity de) {
		System.out.println(de);
		return sr.addDoctor(de);
		
	}
	
	@PostMapping("/savePatient")
	public @ResponseBody ResponseStrucutre<PatientEntity> addPatient(@RequestBody PatientEntity pe) {
		return sr.addPatient(pe);
		
	}
	@GetMapping("/suggestdoctor/{id}")
	public @ResponseBody ResponseStrucutre<List<DoctorEntity>> suggest(@PathVariable("id") int id) {
		return sr.suggestDoctors(id);
	}
	@PostMapping("/deletedoctor/{id}")
	public @ResponseBody ResponseStrucutre<DoctorEntity> deleteDoctor(@PathVariable("id") int id) {
		return sr.deleteDoctor(id);
		
	}

	
	@PostMapping("/deletepatient/{id}")
	public @ResponseBody ResponseStrucutre<PatientEntity> deletePatient(@PathVariable("id") int id) {
		return sr.deletePatient(id);
		
	}

}
