package com.jmakulec.osm.demo.service.Exam;

import com.jmakulec.osm.demo.controller.exam.ExamRequest;
import com.jmakulec.osm.demo.domain.Exam;
import com.jmakulec.osm.demo.dto.ExamListDTO;
import com.jmakulec.osm.demo.repository.ExamRepository;
import com.jmakulec.osm.demo.repository.PatientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Transactional
    public List<Exam> examListForPatient(long id)throws ObjectNotFoundException {

        return  examRepository.findByPatientIdOrderByDateAsc(id);
    }

    @Transactional
    public ExamListDTO add(ExamRequest request) throws ObjectNotFoundException{
        Exam exam = createExamFromRequest(request);
        examRepository.save(exam);
        return new ExamListDTO(exam);
    }

    public Exam createExamFromRequest(ExamRequest request){
        Exam exam = new Exam();
        exam.setDate(request.getDate());
        exam.setPatient(patientRepository.getOne(request.getPatient_id()));
        exam.setHeight(request.getHeight());
        exam.setWeight(request.getWeight());
        return exam;
    }
}
