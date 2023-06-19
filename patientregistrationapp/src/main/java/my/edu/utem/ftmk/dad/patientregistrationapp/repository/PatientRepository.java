package my.edu.utem.ftmk.dad.patientregistrationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.patientregistrationapp.model.Patient;

//Repository interface for performing CRUD operations on the Patient entity.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
