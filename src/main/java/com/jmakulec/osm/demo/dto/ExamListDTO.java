package com.jmakulec.osm.demo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.text.DecimalFormat;
import java.time.LocalDate;

@Data
public class ExamListDTO {

    private String bmi;
    private Long exam_id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double weight;

    private Double height;

    public ExamListDTO(Exam exam){
        this.exam_id = exam.getId();
        this.date = exam.getDate();
        this.height = exam.getHeight();
        this.weight = exam.getWeight();
        double work = exam.getHeight()/100;
        double work2 = work*work;
        double work3 = exam.getWeight()/work2;
        DecimalFormat d2form = new DecimalFormat("###.00");
        this.bmi = d2form.format(work3);

    }
}
