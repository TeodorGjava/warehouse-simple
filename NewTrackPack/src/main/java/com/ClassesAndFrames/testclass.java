/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ClassesAndFrames;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author LL
 */
public class testclass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/DB;IFEXISTS=TRUE", "test", "test");
            String querry = "select * from UNTITLED ";
            
    }
    
}
