package com.MyAssesment.Entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Entity
@Data
public class PatientEntity {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	@Size(min=3)
	private String name;
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9]*@gmail[.]com",message="invalid")
	private String email;
    @Size(min=10)
	private String phoneNumber;
    @Size(max=20)
	private String city;
	private String symptom;
	@Override
	public String toString() {
		return "PatientEntity [id=" + id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", city=" + city + ", symptom=" + symptom + "]";
	}
	

}
