/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at16.injection.entities;

import java.sql.Date;

/**
 *
 * @author Lowz
 */
public class Person {

    private String fullName;
    private String address;
    private Date Dob;
    private String license;
    private String phone;
    private String sex;

    public Person() {

    }

    public Person(String fullName, String address, Date dob, String license, String phone, String sex) {
        this.fullName = fullName;
        this.address = address;
        Dob = dob;
        this.license = license;
        this.phone = phone;
        this.sex = sex;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return Dob;
    }

    public void setDob(Date dob) {
        Dob = dob;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
