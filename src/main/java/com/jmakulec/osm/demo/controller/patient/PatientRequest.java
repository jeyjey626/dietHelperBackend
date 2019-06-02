package com.jmakulec.osm.demo.controller.patient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class PatientRequest {
    private String name;
    private String surname;
    private Double heightset;

}
