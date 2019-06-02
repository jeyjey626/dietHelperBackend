package com.jmakulec.osm.demo.controller.patient;


import com.jmakulec.osm.demo.dto.PatientDetailDTO;
import com.jmakulec.osm.demo.dto.PatientListDTO;
import com.jmakulec.osm.demo.service.Patient.PatientService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController

public class PatientController {

    @Autowired
    private PatientService service;


    @GetMapping("/patients")
    public List<PatientListDTO> getAll(){return service.getAllEmployees().stream().map(PatientListDTO::new).collect(Collectors.toList());}

    @PostMapping("/patients")
    public PatientDetailDTO create(@RequestBody PatientRequest request) throws ObjectNotFoundException{
        return service.add(request);
    }

    @GetMapping("patients/{id}")
    public PatientDetailDTO getOnePatient(@PathVariable Long id){ return service.getOnePatient(id).map(PatientDetailDTO::new).orElseThrow(NullPointerException::new);}

}
