package com.MyAssesment.Entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class DoctorEntity {
	
		@Id
		@GenericGenerator(name = "auto", strategy = "increment")
		@GeneratedValue(generator = "auto")
		private int id;
		private String name;
		private String email;
		private String phonenumber;
		private String city;
		private String speciality;
		@Override
		public String toString() {
			return "DoctorEntity [id=" + id + ", name=" + name + ", email=" + email + ", phonenumber=" + phonenumber
					+ ", speciality=" + speciality + "]";
		}

}
