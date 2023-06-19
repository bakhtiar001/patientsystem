package my.edu.utem.ftmk.dad.patientregistrationapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import my.edu.utem.ftmk.dad.patientregistrationapp.model.Patient;

//handle UI-related requests and rendering views
@Controller
public class PatientMenuController {
    
    private String baseUrl = "http://localhost:8080/api/patients";
    
    @Autowired
    private RestTemplate restTemplate;
    

    @GetMapping("/patients")
    public String getPatients(Model model) {
        ResponseEntity<Patient[]> response = restTemplate.getForEntity(baseUrl, Patient[].class);
        List<Patient> patientList = Arrays.asList(response.getBody());
        model.addAttribute("patients", patientList);
        return "patients";
    }
    
    @GetMapping("/patient/{patientId}")
    public String getPatient(@PathVariable int patientId, Model model) {
        String url = baseUrl + "/" + patientId;
        Patient patient = restTemplate.getForObject(url, Patient.class);
        model.addAttribute("patient", patient);
        return "patient";
    }
    
    @GetMapping("/patient/new")
    public String showNewPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "new-patient";
    }
    
    @PostMapping("/patient/save")
    public String savePatient(@ModelAttribute Patient patient) {
        if (patient.getPatient_id() == 0) {
            restTemplate.postForObject(baseUrl, patient, Patient.class);
        } else {
            String url = baseUrl + "/" + patient.getPatient_id();
            restTemplate.put(url, patient);
        }
        return "redirect:/patients";
    }
    
    @GetMapping("/patient/edit/{patientId}")
    public String showEditPatientForm(@PathVariable int patientId, Model model) {
        String url = baseUrl + "/" + patientId;
        Patient patient = restTemplate.getForObject(url, Patient.class);
        model.addAttribute("patient", patient);
        return "edit-patient";
    }
    
    @GetMapping("/patient/delete/{patientId}")
    public String deletePatient(@PathVariable int patientId) {
        String url = baseUrl + "/" + patientId;
        restTemplate.delete(url);
        return "redirect:/patients";
    }
}