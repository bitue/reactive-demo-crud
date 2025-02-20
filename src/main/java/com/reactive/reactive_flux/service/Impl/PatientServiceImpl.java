package com.reactive.reactive_flux.service.Impl;
import com.reactive.reactive_flux.entities.Patient;
import com.reactive.reactive_flux.repository.PatientRepository;
import com.reactive.reactive_flux.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository ;

    @Override
    public Mono<Patient> save(Patient patient) {
        return patientRepository.save(patient);

    }

    @Override
    public Mono<Patient> update(Patient patient, Long id) {
        return patientRepository.findById(id)
                .flatMap(existingPatient -> {
                    existingPatient.setName(patient.getName());
                    existingPatient.setGender(patient.getGender());
                    existingPatient.setPatientType(patient.getPatientType());
                    existingPatient.setAddress(patient.getAddress());
                    existingPatient.setEmail(patient.getEmail());

                    return patientRepository.save(existingPatient);
                });
    }

    @Override
    public Mono<Void> delete(Long id) {
        return patientRepository.findById(id)
                .flatMap(patientRepository::delete);
    }

    @Override
    public Flux<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Mono<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public Flux<Patient> findByNameContainIgnoreCase(String name) {
        return patientRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Flux<Patient> findByPatientTypeAndGender(String patientType, String gender) {
        return patientRepository.findByPatientTypeAndGenderQueryCustom(patientType, gender);
    }
}
