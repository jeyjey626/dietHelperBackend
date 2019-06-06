package com.jmakulec.osm.demo.controller.exam;


import com.google.common.collect.Iterables;
import com.jmakulec.osm.demo.domain.Exam;
import com.jmakulec.osm.demo.dto.ExamListDTO;
import com.jmakulec.osm.demo.service.Exam.ExamService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class ExamController {
    @Autowired
    private ExamService examService;

    @GetMapping("/lastexam/{id}")
    public ExamListDTO getLast(@PathVariable Long id){
        List<ExamListDTO> list =  examService.examListForPatient(id).stream()
                .map(ExamListDTO::new)
                .collect(Collectors.toList());
        list.sort((Comparator.comparing(ExamListDTO::getDate)));
        ExamListDTO last = Iterables.getLast(list, null);
        return last;
    }

    @PostMapping("/lastexam")
    public ExamListDTO create(@RequestBody ExamRequest request) throws ObjectNotFoundException {
        return examService.add(request);
    }
}
