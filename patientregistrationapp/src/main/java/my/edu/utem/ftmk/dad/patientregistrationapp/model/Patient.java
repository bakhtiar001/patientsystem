package my.edu.utem.ftmk.dad.patientregistrationapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Patient {
  
    // Primary ID which increments
    // automatically when new entry
    // is added into the database
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="patient_id")
    int patient_id;
    
    //Column in patientdb
    @Column(name="patient_name")
    String patient_name;
    
    @Column(name="patient_ic_no")
    String patient_ic_no;
    
    @Column(name="patient_address")
    String patient_address;
    
    @Column(name="patient_tel_no")
    String patient_tel_no;
  
    public Patient()
    {
    }
    
    // Parameterized constructor
	public Patient(String patient_name, 
			String patient_ic_no, 
			String patient_address, 
			String patient_tel_no) {

		this.patient_name = patient_name;
		this.patient_ic_no = patient_ic_no;
		this.patient_address = patient_address;
		this.patient_tel_no = patient_tel_no;
	}

	// Getters and setters of
    // the variables
	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getPatient_name() {
		return patient_name;
	}

	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}

	public String getPatient_ic_no() {
		return patient_ic_no;
	}

	public void setPatient_ic_no(String patient_ic_no) {
		this.patient_ic_no = patient_ic_no;
	}

	public String getPatient_address() {
		return patient_address;
	}

	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}

	public String getPatient_tel_no() {
		return patient_tel_no;
	}

	public void setPatient_tel_no(String patient_tel_no) {
		this.patient_tel_no = patient_tel_no;
	}
}