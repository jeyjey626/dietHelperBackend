package com.jmakulec.osm.demo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamListDTO {
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

    }
}
