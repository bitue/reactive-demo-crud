package com.reactive.reactive_flux.repository;
import com.reactive.reactive_flux.entities.Patient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {
}
