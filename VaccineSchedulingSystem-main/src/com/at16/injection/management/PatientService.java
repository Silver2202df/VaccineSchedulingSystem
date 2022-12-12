/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at16.injection.management;

import com.at16.injection.connection.PatientDao;
import com.at16.injection.entities.Patient;
import java.util.List;
import java.sql.Date;
/**
 *
 * @author Lowz
 */
public class PatientService {
    private PatientDao patientDao;

    public PatientService() {
        patientDao = new PatientDao();
    }
    
    public List<Patient> getAllPatients(){
        return patientDao.getAllPatients();
    }
    public void addPatient(Patient patient){
        patientDao.addPatient(patient);
    }
    
    public void deletePatient(String lisence){
        patientDao.deletePatient(lisence);
    }
    public Patient getPatientByLicense(String license){
        return patientDao.getPatientByLisence(license);
    }
    public void editPatient(Patient patient){
        patientDao.editPatient(patient);
    }
    public List<Patient> getPatientByName(String name){
        return patientDao.getPatientByName(name);
    }
    public void scheduledInjection(int max, Date start){
        patientDao.scheduledInjection(max, start);
    }
    public void cancelScheduled(){
        patientDao.cancelScheduled();
    }
    public List<String> getYear (){
        return patientDao.getYear();
    }
    public List<Patient> objectfilter (int year, int month, int day ) {
        return patientDao.objectfilter(year, month, day);
    }
}
