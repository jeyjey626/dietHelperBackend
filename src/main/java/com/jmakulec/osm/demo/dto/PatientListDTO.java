package com.jmakulec.osm.demo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jmakulec.osm.demo.domain.Patient;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class PatientListDTO {
    private Long id_patient;

    private String name;

    private String surname;

    public PatientListDTO(Patient patient){
        this.id_patient = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
    }
}
