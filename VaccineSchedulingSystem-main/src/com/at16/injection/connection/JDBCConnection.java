/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at16.injection.connection;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Lowz
 */
public class JDBCConnection {

    private static Connection con;
        public static String DBName() throws IOException{ 
        File dir = new File("config");
        if(!dir.exists()){
            dir.mkdir();
        }
        File DBName = new File("config/DBName.txt");
        if(!DBName.exists()){
            DBName.createNewFile();
        }
        Scanner sc = new Scanner(DBName);
        while(sc.hasNext()){
            String name = sc.next();
            return name;
        }
        return null;
    }
    
    public static String User() throws IOException{
        File user = new File("config/user.txt");
        if(!user.exists()){
            user.createNewFile();
        }
        Scanner sc = new Scanner(user);
        while(sc.hasNext()){
            String username = sc.next();
            return username;
        }
        return null;
    }
    
    public static String Password() throws IOException{
        File password = new File("config/password.txt");
        if(!password.exists()){
            password.createNewFile();
        }
        Scanner sc = new Scanner(password);
        while(sc.hasNext()){
            String pass = sc.next();
            return pass;
        }
        return null;
    }
    

    public static Connection getJDBCConnection() throws IOException {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName="+DBName()+";user="+User()+";password="+Password()+"";
            Connection con = DriverManager.getConnection(dbURL);
            return con;
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        return con;
    }
}
