package com.hospital.repositories;

import org.springframework.data.repository.CrudRepository;

import com.hospital.entities.Patient;

public interface PatientRepository extends CrudRepository<Patient, String> {

}
