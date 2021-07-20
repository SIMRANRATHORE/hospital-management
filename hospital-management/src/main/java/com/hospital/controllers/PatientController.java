package com.hospital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.entities.Patient;
import com.hospital.services.PatientService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping(value="/api")
public class PatientController {
	@Autowired
	private PatientService patientService;
	@RequestMapping("/patients")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}
	
	@RequestMapping("/patient-id/{id}")
	public Patient getPatientById(@PathVariable String id) {
		return patientService.getPatient(id);
	}
	
	@RequestMapping(method =RequestMethod.POST,value= "/add-patient")
	public Patient addPatient(@RequestBody Patient p) {
		return patientService.addPatient(p);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update-patient/{id}")
	public Patient updatePatient(@RequestBody Patient p,@PathVariable String id) {
		return patientService.updatePatient(p, id);
	}
	
	@RequestMapping(method= RequestMethod.DELETE,value="/delete-patient/{id}")
		public void deletePatient(@PathVariable String id ) {
			patientService.patientDelete(id);
		}
}
