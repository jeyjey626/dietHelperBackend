package com.jmakulec.osm.demo.service.Patient;

import com.jmakulec.osm.demo.controller.patient.PatientRequest;
import com.jmakulec.osm.demo.domain.Exam;
import com.jmakulec.osm.demo.domain.Patient;
import com.jmakulec.osm.demo.dto.PatientDetailDTO;
import com.jmakulec.osm.demo.repository.ExamRepository;
import com.jmakulec.osm.demo.repository.PatientRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private ExamRepository examRepository;

    @Transactional
    public List<Patient> getAllEmployees() throws ObjectNotFoundException {
        return repository.findAll();
    }

    @Transactional
    public Optional<Patient> getOnePatient(long id) throws ObjectNotFoundException{
        return repository.findById(id);
    }

    @Transactional
    public PatientDetailDTO add(PatientRequest request) throws ObjectNotFoundException{
        Patient patient = createPatientFromRequest(request);
        repository.save(patient);
        return new PatientDetailDTO(patient);
    }



    public Patient createPatientFromRequest(PatientRequest request) throws ObjectNotFoundException{
        Patient patient = new Patient();
        patient.setName(request.getName());
        patient.setSurname(request.getSurname());
        patient.setHeightset(request.getHeightset());
        return patient;
    }

    public void deletePatient(long idPatient) throws ObjectNotFoundException{
        List<Exam> list = examRepository.findByPatientIdOrderByDateAsc(idPatient);
        for (Exam alist:list) {
            examRepository.delete(alist);
        }
        repository.delete(repository.getOne(idPatient));
    }
}
