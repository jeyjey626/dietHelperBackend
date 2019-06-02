package com.jmakulec.osm.demo.domain;


import lombok.Data;
import java.util.List;
import javax.persistence.*;

@Entity
@Data
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Double heightset;

    @OneToMany
    @JoinColumn(name = "patient_id")
    private List<Exam> exams;
}
