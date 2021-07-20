package com.hospital.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import org.hibernate.annotations.GenericGenerator;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String fName;
	private String lName;
	private String gender;
	private String status;
	
	public Patient() {}
	
	public Patient(String fName, String lName, String gender, String status) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.gender = gender;
		this.status = status;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", fName=" + fName + ", lName=" + lName + ", gender=" + gender + ", status="
				+ status + "]";
	}

}
