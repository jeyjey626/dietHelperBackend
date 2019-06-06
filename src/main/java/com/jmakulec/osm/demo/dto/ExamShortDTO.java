package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamShortDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double weight;

    public ExamShortDTO(Exam exam){

        this.date = exam.getDate();
        this.weight = exam.getWeight();

    }
}
