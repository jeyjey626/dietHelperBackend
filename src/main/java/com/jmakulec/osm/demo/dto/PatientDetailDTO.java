package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jmakulec.osm.demo.domain.Exam;
import com.jmakulec.osm.demo.domain.Patient;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class PatientDetailDTO {
    private Long id_patient;

    private String name;

    private String surname;

    private Double height;

    private List<ExamListDTO> examList;

    public PatientDetailDTO(Patient patient){
        this.id_patient = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.height = patient.getHeightset();
        this.examList = patient.getExams().stream().map(ExamListDTO::new).collect(Collectors.toList());
    }
}

