/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sergio
 */
public class TransferenciasDB {

    private final static String STATEMENT_SUBIR_ESTADO_POR_CODIGO = "UPDATE Paquete SET estado =estado+1 WHERE codigo =?";
    private final static String USER = "root";
    private final static String PASSWORD = "danielito";
    private final static String STRING_CONNECTION = "jdbc:mysql://localhost:3306/paquetes";
    private static Connection coneccion2 = null;

    public TransferenciasDB() {
        try {
            coneccion2 = DriverManager.getConnection(STRING_CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error Al conectar DB");
        }
    }

    public  static void moverEstadoDePaquete(int codigo){
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_SUBIR_ESTADO_POR_CODIGO);
            declaracionPreparada.setString(1, String.valueOf(codigo));
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al mover");
        }

    }
}
