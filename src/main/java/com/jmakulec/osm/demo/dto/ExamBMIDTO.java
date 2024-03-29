package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ExamBMIDTO {
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long exam_id;
    private Double bmi;

    public ExamBMIDTO(Exam exam){
        this.exam_id = exam.getId();
        double work = exam.getHeight()/100;
        double work2 = work*work;
        double work3 = exam.getWeight()/work2;
        this.date = exam.getDate();
        this.bmi = work3;

    }
}
