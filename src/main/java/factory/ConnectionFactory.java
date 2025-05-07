/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Family
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
           return DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "fatec");
        // return DriverManager.getConnection("jdbc:mysql://192.168.15.13/cadastro", "user", "fatec123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
