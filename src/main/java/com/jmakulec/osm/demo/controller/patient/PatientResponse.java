package com.jmakulec.osm.demo.controller.patient;


import lombok.*;

@Data
@ToString
@EqualsAndHashCode
public class PatientResponse {
    private Long id;
    private String name;
    private String surname;
    private Double heightset;
}
