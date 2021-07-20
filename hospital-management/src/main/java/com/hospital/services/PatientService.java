package com.hospital.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hospital.entities.Patient;
import com.hospital.repositories.PatientRepository;

@Service
public class PatientService {

	@Autowired
	private PatientRepository patientRepo;

	public List<Patient> getAllPatient() {
		List<Patient> patient = new ArrayList<>(Arrays.asList());
		patientRepo.findAll().forEach(patient::add);
		return patient;
	}

	public Patient getPatient(String id) {
		return patientRepo.findById(id).get();
	}

	public Patient addPatient(Patient p) {
		return patientRepo.save(p);
	}

	public void patientDelete(String id) {
		patientRepo.deleteById(id);
	}

	public Patient updatePatient(Patient p, String id) {
		Optional<Patient> optionalUser = patientRepo.findById(id);
		if (!optionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Patient id does not exists");
		}
		Patient exPatient = optionalUser.get();
		exPatient.setStatus(p.getStatus());
		return patientRepo.save(exPatient);
	}

}
