/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at16.injection.entities;

import  java.sql.Date;

/**
 *
 * @author Lowz
 */
public class Patient extends Person {

    private int objectCode;
    private String backgroundIllness;
    private Date dateInjection;
    private int number;
    private String shift;

    public Patient() {

    }

    public Patient(int objectCode,String backgroundIllness, Date dateInjection, int number, String shift, String fullName, String address, Date dob, String license, String phone, String sex) {
        super(fullName, address, dob, license, phone, sex);
        this.objectCode = objectCode;
        this.backgroundIllness = backgroundIllness;
        this.dateInjection = dateInjection;
        this.number = number;
        this.shift = shift;
    }


    public int getObjectCode() {
        return objectCode;
    }

    public void setObjectCode(int objectCode) {
        this.objectCode = objectCode;
    }

    public String getBackgroundIllness() {
        return backgroundIllness;
    }

    public void setBackgroundIllness(String backgroundIllness) {
        this.backgroundIllness = backgroundIllness;
    }

    public int getNumber() {
        return number;
    }

    public String getShift() {
        return shift;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Date getDateInjection() {
        return dateInjection;
    }

    public void setDateInjection(Date dateInjection) {
        this.dateInjection = dateInjection;
    }
    
}
