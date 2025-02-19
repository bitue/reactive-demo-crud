package com.reactive.reactive_flux.service;
import com.reactive.reactive_flux.entities.Patient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PatientService {
    public Mono<Patient> save(Patient patient);
    public Mono<Patient> update(Patient patient, Long id);
    public Mono<Void> delete(Long id);
    public Flux<Patient> findAll();
    public Mono<Patient> findById(Long id);
    public Flux<Patient> findByNameStartWith(String firstName);

}
