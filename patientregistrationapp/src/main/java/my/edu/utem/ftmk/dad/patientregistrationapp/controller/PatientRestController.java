package my.edu.utem.ftmk.dad.patientregistrationapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.patientregistrationapp.model.Patient;
import my.edu.utem.ftmk.dad.patientregistrationapp.repository.PatientRepository;

//handle HTTP requests related to patient data
@RestController
@RequestMapping("/api/patients")
public class PatientRestController {
    
    @Autowired
    private PatientRepository patientRepository;
    
    //handles a GET request to the base URL ("/api/patients")
    //find all patients data
    //return them as list
    @GetMapping
    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }
    
    //handles a GET request to URL ("/api/patients/{patientId}")
    //find specific patient data based on id
    //return the patient data
    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable int patientId) {
        return patientRepository.findById(patientId).orElse(null);
    }
    
    //handle POST request to the base URL ("/api/patients") 
    //inserts a new patient
    //receives the patient data as JSON
    //return saved patient data as response
    @PostMapping
    public Patient insertPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }
    
    //handles a DELETE request to ("/api/patients/{patientId}")
    //delete patient data with specific id
    //return response ok
    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        patientRepository.deleteById(patientId);
        return ResponseEntity.ok().build();
    }
    
    //handles a PUT request to ("/api/patients/{patientId}")
    //receives updated patient data as a JSON
    //updated patient data returned as the response
    @PutMapping("/{patientId}")
    public Patient updatePatient(@PathVariable int patientId, @RequestBody Patient patient) {
        patient.setPatient_id(patientId);
        return patientRepository.save(patient);
    }
}
