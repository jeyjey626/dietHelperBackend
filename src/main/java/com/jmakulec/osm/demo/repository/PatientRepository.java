package com.jmakulec.osm.demo.repository;

import com.jmakulec.osm.demo.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


}
