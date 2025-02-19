package com.reactive.reactive_flux.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("patient")
public class Patient {

    @Id
    @Column("patientId")
    Long patientId ;

    private String name ;

    private String gender ;

    @Column("patientType")
    private String patientType ;

    private String address ;

    private  String email ;
}
