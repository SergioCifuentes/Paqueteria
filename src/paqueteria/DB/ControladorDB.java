/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteria.Usuario.Administrador;
import paqueteria.Usuario.Operador;
import paqueteria.Usuario.Recepcionista;
import paqueteria.Usuario.Usuario;

/**
 *
 * @author sergio
 */
public class ControladorDB {
    private final static String STATEMENT_USUARIO_POR_NOMBRE="SELECT * FROM Usuario WHERE userName = ?";
    private final static String STATEMENT_GUARDAR_USUARIO="INSERT INTO Usuario VALUES (?,?,?)";
    private final static String USER = "root";
    private final static String PASSWORD = "danielito";
    private final static String STRING_CONNECTION = "jdbc:mysql://localhost:3306/paquetes";

    private static Connection coneccion = null;

    public ControladorDB() {
        try {
            coneccion = DriverManager.getConnection(STRING_CONNECTION, USER, PASSWORD);
//            PreparedStatement delaracionPreparada = coneccion.prepareStatement("SELECT * FROM Usuario WHERE userName = ?");
//            delaracionPreparada.setString(1, "usuario1");
//            ResultSet resultado2 = delaracionPreparada.executeQuery();
//            int numeroFila=1;
//            System.out.println("sad");
//            while (resultado2.next()) {
//                System.out.println("s");
//                System.out.printf("Fila %d - %s - %d - %s\n",
//                        numeroFila,
//                        resultado2.getString("userName"),
//                        resultado2.getInt("jerarquia"),
//                        resultado2.getString("contrasena"));                
//                numeroFila++;
//            }
        } catch (SQLException e) {
            System.out.println("Error Al conectar DB");
        }
    }
    public static Usuario verificarUserName(String userName){        
        Usuario userNameValido = null;
        try {            
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_USUARIO_POR_NOMBRE);
            declaracionPreparada.setString(1, userName);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            if (resultado2.next()) {
                switch (resultado2.getInt("jerarquia")) {
                    case 1:
                        userNameValido= new Administrador(resultado2.getString("userName"),resultado2.getString("contrasena"), 1);
                        break;
                    case 2:
                        userNameValido= new Operador(resultado2.getString("userName"),resultado2.getString("contrasena"), 2);
                        break;
                    case 3:
                        userNameValido= new Recepcionista(resultado2.getString("userName"),resultado2.getString("contrasena"), 3);
                        break;
                    default:
                        throw new AssertionError();
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userNameValido;
    }
    public static void guardarUsuario(Usuario user){
        try {
//            Statement declaracion = coneccion.createStatement();
//            declaracion.executeUpdate(STATEMENT_GUARDAR_USUARIO);
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_USUARIO);
            declaracionPreparada.setString(1,user.getUserName());
            declaracionPreparada.setString(2,String.valueOf(user.getJerarquia()));
            declaracionPreparada.setString(3,user.getPassword());
            System.out.println(declaracionPreparada);
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }
        
    }
}
