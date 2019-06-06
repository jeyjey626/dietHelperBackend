package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamBMIDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double bmi;

    public ExamBMIDTO(Exam exam){

        double work = exam.getHeight()/100;
        double work2 = work*work;
        double work3 = exam.getWeight()/work2;
        this.date = exam.getDate();
        this.bmi = work3;

    }
}
