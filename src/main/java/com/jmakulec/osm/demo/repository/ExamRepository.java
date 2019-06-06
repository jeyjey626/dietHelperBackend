package com.jmakulec.osm.demo.repository;

import com.jmakulec.osm.demo.domain.Exam;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

    //Exam findByP atientAndOrOrderByDate(long id) throws ObjectNotFoundException;

    List<Exam> findByPatientIdOrderByDateAsc(long patientId) throws ObjectNotFoundException;
    List<Exam> findByPatientId(long patientId) throws ObjectNotFoundException;
    //List<Exam> findByDateBetween(LocalDate start, LocalDate stop);

}
