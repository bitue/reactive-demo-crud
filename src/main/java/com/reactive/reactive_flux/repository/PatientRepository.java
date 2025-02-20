package com.reactive.reactive_flux.repository;
import com.reactive.reactive_flux.entities.Patient;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PatientRepository extends ReactiveCrudRepository<Patient, Long> {

    //findQuery Methods
    public Mono<Patient> findByName(String name);
    public Mono<Patient> findByNameStartingWith(String name);
    public Flux<Patient> findByNameContaining(String name);
    public Flux<Patient> findByNameContainingIgnoreCase(String name);
    // public Flux<Patient> findByNameContainingIgnoreCaseAndNameStartingWith(Mono<String> name, Mono<String> name2);

    // Query Methods

    @Query("SELECT * FROM Patient WHERE gender=:gender AND patientType=:patientType")
    public Flux<Patient> findByPatientTypeAndGenderQueryCustom(String patientType, String gender);
}
