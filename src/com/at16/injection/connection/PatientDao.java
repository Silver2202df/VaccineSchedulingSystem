/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at16.injection.connection;

import com.at16.injection.entities.Patient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lowz
 */
public class PatientDao {

    public List<Patient> getAllPatients(){
        List<Patient> patients = new ArrayList<>();

        

        String sql = "select * "
                + "from dbo.Injection order by number";
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();

                patient.setFullName(rs.getString("fullName"));
                patient.setAddress(rs.getString("address"));
                patient.setDob(rs.getDate("Dob"));
                patient.setLicense(rs.getString("license"));
                patient.setPhone(rs.getString("phone"));
                patient.setSex(rs.getString("sex"));
                patient.setObjectCode(rs.getInt("objectCode"));
                patient.setBackgroundIllness(rs.getString("backgroundIllness"));
                patient.setDateInjection(rs.getDate("dateInjection"));
                patient.setShift(rs.getString("shitf"));
                patient.setNumber(rs.getInt("number"));
                

                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
    }

    public void addPatient(Patient patient){
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            
            String sql = "INSERT INTO dbo.Injection "
                    + "(fullName, address, Dob, license, phone, sex, objectCode, backgroundIllness, dateInjection, number, shitf)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
                preparedStatement.setString(1, patient.getFullName());
                preparedStatement.setString(2, patient.getAddress());
                preparedStatement.setDate(3, (Date) patient.getDob());
                preparedStatement.setString(4, patient.getLicense());
                preparedStatement.setString(5, patient.getPhone());
                preparedStatement.setString(6, patient.getSex());
                preparedStatement.setInt(7, patient.getObjectCode());
                preparedStatement.setString(8, patient.getBackgroundIllness());
                preparedStatement.setDate(9, (Date) patient.getDateInjection());
                preparedStatement.setInt(10, patient.getNumber());
                preparedStatement.setString(11, patient.getShift());
                
                int rs = preparedStatement.executeUpdate();
                //System.out.println(rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletePatient(String license){

        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "delete from dbo.Injection "
                    + "where license = ? ";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, license);
                
                String rs = String.valueOf(preparedStatement.executeUpdate());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editPatient(Patient patient){
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "update dbo.Injection "
                    + "set fullName = ?, address = ?, Dob = ?, license = ?, phone = ?, sex = ?, objectCode = ?, backgroundIllness = ? "
                    + "where license = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
                preparedStatement.setString(1, patient.getFullName());
                preparedStatement.setString(2, patient.getAddress());
                preparedStatement.setDate(3, patient.getDob());
                preparedStatement.setString(9, patient.getLicense());
                preparedStatement.setString(5, patient.getPhone());
                preparedStatement.setString(6, patient.getSex());
                preparedStatement.setInt(7, patient.getObjectCode());
                preparedStatement.setString(8, patient.getBackgroundIllness());
                preparedStatement.setString(4, patient.getLicense());
                
                int rs = preparedStatement.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Patient getPatientByLisence(String license){
        try {
            Connection connection = JDBCConnection.getJDBCConnection();
            
            String sql = "select * "
                    + "from dbo.Injection "
                    + "where license = ?";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, license);
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()) {
                    Patient patient = new Patient();
                    
                    patient.setFullName(rs.getString("fullName"));
                    patient.setAddress(rs.getString("address"));
                    patient.setDob(Date.valueOf(rs.getString("dob")));
                    patient.setLicense(rs.getString("license"));
                    patient.setPhone(rs.getString("phone"));
                    patient.setSex(rs.getString("sex"));
                    patient.setObjectCode(rs.getInt("objectCode"));
                    patient.setBackgroundIllness(rs.getString("backgroundIllness"));
                    
                    return patient;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Patient> getPatientByName(String name){
        List<Patient> patients = new ArrayList<>();
        try {
            
            
            Connection connection = JDBCConnection.getJDBCConnection();
            
            String sql = "select * "
                    + "from dbo.Injection "
                    + "where fullName like N'%" + name + "%'";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
                ResultSet rs = preparedStatement.executeQuery();
                
                while (rs.next()) {
                    Patient patient = new Patient();
                    
                    patient.setFullName(rs.getString("fullName"));
                    patient.setAddress(rs.getString("address"));
                    patient.setDob(Date.valueOf(rs.getString("dob")));
                    patient.setLicense(rs.getString("license"));
                    patient.setPhone(rs.getString("phone"));
                    patient.setSex(rs.getString("sex"));
                    patient.setObjectCode(rs.getInt("objectCode"));
                    patient.setBackgroundIllness(rs.getString("backgroundIllness"));
                    patient.setDateInjection(rs.getDate("dateInjection"));
                    patient.setShift(rs.getString("shitf"));
                    patient.setNumber(rs.getInt("number"));
                    
                    
                    patients.add(patient);
                    
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
    }

    public void scheduledInjection(int max, Date start){
        try {
            // SCHEDULE
            List<Patient> patients = new ArrayList<Patient>();
            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "select number,shitf, license "
                    + "from Injection "
                    + "where fullName is not null "
                    + "order by objectCode, YEAR(Dob), backgroundIllness";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                int i = 1, count = 1;
                int j = (max / 2) / 4, x = 1;
                Calendar c1 = Calendar.getInstance();
                c1.setTime(start);
                while (rs.next()) {
                    Patient patient = new Patient();
                    
                    patient.setLicense(rs.getString("license"));
                    patient.setNumber(i);
                    {
                        float y = (float) x / (float) j;
                        if (count <= (max / 2)) {
                            if (y <= 1) {
                                patient.setShift("Sáng 07:00-08:00");
                            }
                            if (y > 1 && y <= 2) {
                                patient.setShift("Sáng 08:00-09:00");
                            }
                            if (y > 2 && y <= 3) {
                                patient.setShift("Sáng 09:00-10:00");
                            }
                            if (y > 3) {
                                patient.setShift("Sáng 10:00-11:00");
                            }
                            if (x == max / 2) {
                                x = 1;
                            } else {
                                x++;
                            }
                        } else {
                            if (y <= 1) {
                                patient.setShift("Chiều 13:00-14:00");
                            }
                            if (y > 1 && y <= 2) {
                                patient.setShift("Chiều 14:00-15:00");
                            }
                            if (y > 2 && y <= 3) {
                                patient.setShift("Chiều 15:00-16:00");
                            }
                            if (y > 3) {
                                patient.setShift("Chiều 16:00-17:00");
                            }
                            if (x == max / 2) {
                                x = 1;
                            } else {
                                x++;
                            }
                        }
                        
                    }
                    if (i % max != 0) {
                        java.sql.Date sqlDate = new java.sql.Date(c1.getTime().getTime());
                        patient.setDateInjection(sqlDate);
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(c1.getTime().getTime());
                        patient.setDateInjection(sqlDate);
                        c1.add(Calendar.DATE, 1);
                        count = 0;
                        
                    }
                    patients.add(patient);
                    i++;
                    count++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //UPDATE DATABASE
            //Connection connection2= JDBCConnection.getJDBCConnection();
            String sql2 = "update Injection"
                    + " set number=?, shitf=?, dateInjection=? "
                    + "where license = ?";
            try {
                for (Patient p : patients) {
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
                    
                    preparedStatement2.setInt(1, p.getNumber());
                    preparedStatement2.setString(2, p.getShift());
                    preparedStatement2.setDate(3, p.getDateInjection());
                    preparedStatement2.setString(4, p.getLicense());
                    
                    preparedStatement2.executeUpdate();
                }
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            //return patients;
        } catch (IOException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void cancelScheduled(){
		try {
                    Connection connection = JDBCConnection.getJDBCConnection();
                    String sql="update Injection "
                            + "set number=null, shitf=null, dateInjection=null";
                    try {
                        PreparedStatement pr= connection.prepareStatement(sql);
                        pr.executeUpdate();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } catch (IOException ex) {
			Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
    public List<String> getYear (){
       
        List<String> data = new ArrayList<>();
        try{
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "select dateInjection "
                + "from dbo.Injection " 
                + "GROUP BY dateInjection";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<String> temp = new ArrayList<>();
            
            while (rs.next()) {
                java.util.Date newDate = rs.getTimestamp("dateInjection");
                if(newDate == null){
                    data.add("null");
                    return data;
                }
                SimpleDateFormat year = new SimpleDateFormat("yyyy");
             
                temp.add(year.format(newDate));
            }

            data.add(temp.get(0));
            for(int i = 1; i < temp.size();i++){
                if (!temp.get(i).equals(temp.get(i-1)))
                {
                    data.add(temp.get(i));
                }
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
        }
            
        } catch (Exception ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return data;
    }
    public List<Patient> objectfilter (int year, int month, int day ){
        List<Patient> patients = new ArrayList<>();
        try{
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "select * "
                + "from dbo.Injection " 
                + "where dateInjection = '"+ year + "-" + month + "-" + day + "'"
                + "order by number";
 try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Patient patient = new Patient();

                patient.setFullName(rs.getString("fullName"));
                patient.setAddress(rs.getString("address"));
                patient.setDob(rs.getDate("Dob"));
                patient.setLicense(rs.getString("license"));
                patient.setPhone(rs.getString("phone"));
                patient.setSex(rs.getString("sex"));
                patient.setObjectCode(rs.getInt("objectCode"));
                patient.setBackgroundIllness(rs.getString("backgroundIllness"));
                patient.setDateInjection(rs.getDate("dateInjection"));
                patient.setNumber(rs.getInt("number"));
                patient.setShift(rs.getString("shitf"));

                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
        } catch (Exception ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return patients;
    }
}
