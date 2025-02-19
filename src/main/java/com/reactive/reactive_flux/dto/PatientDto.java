package com.reactive.reactive_flux.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PatientDto {
    private Long patientId;

    private String name;

    private String gender;

    private String patientType;

    private String address;

    private String email;
}
