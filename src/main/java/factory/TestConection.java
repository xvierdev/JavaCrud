/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author Família
 */
public class TestConection {

    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();
        try {
            cf.getConnection();
            System.out.println("Success");
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
