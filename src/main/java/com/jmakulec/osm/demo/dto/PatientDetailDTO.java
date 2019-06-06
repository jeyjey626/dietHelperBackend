package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jmakulec.osm.demo.domain.Exam;
import com.jmakulec.osm.demo.domain.Patient;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@JsonInclude(NON_NULL)
public class PatientDetailDTO {
    private List<ExamListDTO> examList;
    private Long id_patient;

    private String name;

    private String surname;

    private Double height;

    private List<ExamShortDTO> examShortDTOList;


    private List<ExamBMIDTO> BMIList;

    public PatientDetailDTO(Patient patient){
        this.id_patient = patient.getId();
        this.name = patient.getName();
        this.surname = patient.getSurname();
        this.height = patient.getHeightset();
        if (patient.getExams() != null) {
            this.examList = patient.getExams().stream().map(ExamListDTO::new).collect(Collectors.toList());
            examList.sort((Comparator.comparing(ExamListDTO::getDate)));
            this.BMIList = patient.getExams().stream().map(ExamBMIDTO::new).collect(Collectors.toList());
            BMIList.sort((Comparator.comparing(ExamBMIDTO::getDate)));
            this.examShortDTOList = patient.getExams().stream().map(ExamShortDTO::new).collect(Collectors.toList());
            examShortDTOList.sort((Comparator.comparing(ExamShortDTO::getDate)));
        }
    }
}

