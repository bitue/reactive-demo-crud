package com.reactive.reactive_flux.controller;
import com.reactive.reactive_flux.entities.Patient;
import com.reactive.reactive_flux.service.PatientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.Duration;


@RestController()
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public Mono<Patient> addPatient(@RequestBody Patient patient) {
        return patientService.save(patient);
    }

    @GetMapping
    public Flux<Patient> getAllPatient (){
        return patientService.findAll();

    };

    @GetMapping("/{patientId}")
    public Mono<Patient> getPatientById(@PathVariable("patientId") long patientId) {
        return patientService.findById(patientId) ;
    }

    @PutMapping("/{patientId}")
    public Mono<Patient> updatePatient(@PathVariable long patientId, @RequestBody Patient patient){
        return patientService.update(patient, patientId);
    }

    @DeleteMapping("/{patientId}")
    public Mono<Void>  deletePatient (@PathVariable Long patientId){
        return patientService.delete(patientId);
    }

    @GetMapping("/lazyLoad")
    public Flux<Patient> lazyLoad(){
        return patientService.findAll().delayElements(Duration.ofMillis(2000)).log().doOnComplete(()-> System.out.println(Thread.currentThread().getName()));
    }
}
