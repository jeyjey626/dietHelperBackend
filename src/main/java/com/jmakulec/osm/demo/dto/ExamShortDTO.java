package com.jmakulec.osm.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jmakulec.osm.demo.domain.Exam;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ExamShortDTO {
    private Long exam_id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Double weight;

    public ExamShortDTO(Exam exam){
        this.exam_id = exam.getId();
        this.date = exam.getDate();
        this.weight = exam.getWeight();

    }
}
