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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteria.Ruta.Destino;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Ruta.Ruta;
import paqueteria.Ruta.Tarifa;
import paqueteria.Usuario.Administrador;
import paqueteria.Usuario.Operador;
import paqueteria.Usuario.Recepcionista;
import paqueteria.Usuario.Usuario;
import paqueteria.paquetes.Cliente;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class ControladorDB {

    private final static String STATEMENT_USUARIO_POR_NOMBRE = "SELECT * FROM Usuario WHERE userName = ?";
    private final static String STATEMENT_USUARIO_POR_JERARQUIA = "SELECT * FROM Usuario WHERE jerarquia = ?";
    private final static String STATEMENT_USUARIO = "SELECT * FROM Usuario";
    private final static String STATEMENT_PRECIO_ADMIN_ACTUALES = "SELECT * FROM PreciosAdmin ORDER BY FECHA DESC";
    private final static String STATEMENT_PRECIO_PUNTO_POR_CODIGO = "SELECT * FROM PrecioPunto WHERE codigoPuntoControl = ? ORDER BY FECHA";
    private final static String STATEMENT_PRECIO_DESTINO_POR_CODIGO = "SELECT * FROM PrecioDestino WHERE codigoDestino = ? ORDER BY FECHA";
    private final static String STATEMENT_PUNTOS_DE_CONTROL_POR_RUTA = "SELECT * FROM PuntoDeControl WHERE codigoRuta = ?";
    private final static String STATEMENT_DESTINO_POR_CODIGO = "SELECT * FROM Destino WHERE codigo = ?";
    private final static String STATEMENT_GUARDAR_USUARIO = "INSERT INTO Usuario VALUES (?,?,?)";
    private final static String STATEMENT_GUARDAR_DESTINO = "INSERT INTO Destino VALUES (?,?)";
    private final static String STATEMENT_GUARDAR_PRECIO_ADMIN = "INSERT INTO PreciosAdmin VALUES (?,?,?,?)";
    private final static String STATEMENT_GUARDAR_CLIENTE = "INSERT INTO Cliente VALUES (?,?,?,?)";
    private final static String STATEMENT_GUARDAR_RUTA = "INSERT INTO Ruta VALUES (?,?,?)";
    private final static String STATEMENT_GUARDAR_PUNTOS_DE_CONTROL = "INSERT INTO PuntoDeControl VALUES (?,?,?,?,?)";
    private final static String STATEMENT_GUARDAR_PRECIO_DESTINO = "INSERT INTO PrecioDestino VALUES (?,?,?)";
    private final static String STATEMENT_GUARDAR_PRECIO_PUNTO = "INSERT INTO PrecioPunto VALUES (?,?,?)";
    private final static String STATEMENT_OBTENER_RUTAS = "SELECT * FROM Ruta";
    private final static String STATEMENT_OBTENER_PUNTOS = "SELECT * FROM PuntoDeControl";
    private final static String STATEMENT_OBTENER_PUNTOS_POR_USUARIO = "SELECT * FROM PuntoDeControl WHERE userNameUsuario = ?";
    private final static String STATEMENT_OBTENER_DESTINOS = "SELECT * FROM Destino";
    private final static String STATEMENT_OBTENER_RUTAS_POR_CODIGO = "SELECT * FROM Ruta WHERE codigo = ?";
    private final static String STATEMENT_DELETE_USUARIO = "DELETE FROM Usuario WHERE userName = ?";
    private final static String STATEMENT_CLIENTE_POR_NIT = "SELECT * FROM Cliente WHERE nit = ?";
    private final static String STATEMENT_OBTENER_CLIENTES = "SELECT * FROM Cliente";
    private final static String STATEMENT_OBTENER_PAQUETES = "SELECT * FROM Paquete";
    private final static String STATEMENT_PAQUETE_POR_CODIGO = "SELECT * FROM Paquete WHERE codigo = ?";
    private final static String USER = "root";
    private final static String PASSWORD = "danielito";
    private final static String STRING_CONNECTION = "jdbc:mysql://localhost:3306/paquetes";
    public final static int TIPO_PRECIO_PUNTO = 1;
    public final static int TIPO_PRECIO_DESTINO = 2;
    private static Connection coneccion = null;

    public ControladorDB() {
        try {
            coneccion = DriverManager.getConnection(STRING_CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error Al conectar DB");
        }
    }

    public static Usuario verificarUserName(String userName) {
        Usuario userNameValido = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_USUARIO_POR_NOMBRE);
            declaracionPreparada.setString(1, userName);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            if (resultado2.next()) {
                switch(resultado2.getInt("jerarquia")){
                    case 1:
                         userNameValido = new Administrador(resultado2.getString("userName"), resultado2.getString("contrasena"), resultado2.getInt("jerarquia"));
                        break;
                    case 2:
                         userNameValido = new Operador(resultado2.getString("userName"), resultado2.getString("contrasena"), resultado2.getInt("jerarquia"));
                        break;
                    case 3:
                         userNameValido = new Recepcionista(resultado2.getString("userName"), resultado2.getString("contrasena"), resultado2.getInt("jerarquia"));
                        break;
                }
               
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userNameValido;
    }

    public static ArrayList<Usuario> obtenerUsuarioPorJerarquia(int jerarquia) {
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_USUARIO_POR_JERARQUIA);
            declaracionPreparada.setString(1, String.valueOf(jerarquia));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            if (resultado2.next()) {
                usuario.add(new Usuario(resultado2.getString("userName"), resultado2.getString("contrasena"), jerarquia));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static ArrayList<Usuario> obtenerUsuarios() {
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_USUARIO);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {                
                usuario.add(new Usuario(resultado2.getString("userName"), resultado2.getString("contrasena"), resultado2.getInt("jerarquia")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    public static ArrayList obtenerCodigoDeRutas() {
        ArrayList codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_RUTAS);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(resultado2.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }

    public static ArrayList obtenerCodigoDePuntosDeControl() {
        ArrayList codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_PUNTOS);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(resultado2.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }
    public static ArrayList<PuntoDeControl> obtenerPuntosDeControlPorOperador(Usuario operador) {
        ArrayList<PuntoDeControl> codigos = new ArrayList();
        try {
            PreparedStatement declaracionUsuario = coneccion.prepareStatement(STATEMENT_OBTENER_PUNTOS_POR_USUARIO);
            declaracionUsuario.setString(1, operador.getUserName());
            ResultSet resultado2 = declaracionUsuario.executeQuery();
            while (resultado2.next()) {
                 codigos.add(obtenerPuntoDeControl(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }    

    public static ArrayList obtenerCodigoDeDestinos() {
        ArrayList codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_DESTINOS);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(resultado2.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }

    public static void guardarUsuario(Usuario user) {
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_USUARIO);
            declaracionPreparada.setString(1, user.getUserName());
            declaracionPreparada.setString(2, String.valueOf(user.getJerarquia()));
            declaracionPreparada.setString(3, user.getPassword());
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }

    }

    public static void guardarDestino(Destino destino) {
        try {
            coneccion.setAutoCommit(false);
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_DESTINO);
            declaracionPreparada.setString(1, destino.getNombre());
            declaracionPreparada.setString(2, String.valueOf(destino.getCodigo()));
            declaracionPreparada.executeUpdate();
            declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_PRECIO_DESTINO);
            Tarifa tarifa = destino.getPrecio().get(destino.getPrecio().size() - 1);
            declaracionPreparada.setString(1, String.valueOf(tarifa.getFecha()));
            declaracionPreparada.setString(2, String.valueOf(tarifa.getPrecio()));
            declaracionPreparada.setString(3, String.valueOf(destino.getCodigo()));
            declaracionPreparada.executeUpdate();
            coneccion.commit();
            coneccion.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
            try {
                coneccion.rollback();
            } catch (SQLException ex) {
                System.out.println("Error Rollback");
            }

        }
    }

    public static void guardarPreciosAdmin(LocalDateTime fecha, float precioLibra, float precioPriorizacion, float precioOperacion) {
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_PRECIO_ADMIN);
            declaracionPreparada.setString(1, String.valueOf(fecha));
            declaracionPreparada.setString(2, String.valueOf(precioLibra));
            declaracionPreparada.setString(3, String.valueOf(precioPriorizacion));
            declaracionPreparada.setString(4, String.valueOf(precioOperacion));
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }
    }

    public static void guardarRuta(Ruta ruta) {
        try {
            coneccion.setAutoCommit(false);
            PreparedStatement declaracionPreparadaRuta = coneccion.prepareStatement(STATEMENT_GUARDAR_RUTA);
            declaracionPreparadaRuta.setString(1, String.valueOf(ruta.getCodigo()));
            if (ruta.isEstado()) {
                declaracionPreparadaRuta.setString(2, "1");
            } else {
                declaracionPreparadaRuta.setString(2, "2");
            }

            declaracionPreparadaRuta.setString(3, String.valueOf(ruta.getDestino().getCodigo()));
            declaracionPreparadaRuta.executeUpdate();
            for (int i = 0; i < ruta.getPuntos().size(); i++) {
                guardarPuntoDeControl(ruta.getPuntos().get(i));

            }
            coneccion.commit();
            coneccion.setAutoCommit(true);
        } catch (SQLException e) {

            System.out.println("Error Al Guardar");
            try {
                coneccion.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void guardarPuntoDeControl(PuntoDeControl punto) {
        try {
            PreparedStatement declaracionPunto = coneccion.prepareStatement(STATEMENT_GUARDAR_PUNTOS_DE_CONTROL);
            declaracionPunto.setString(1, String.valueOf(punto.getCodigo()));
            declaracionPunto.setString(2, String.valueOf(punto.getNumero()));
            declaracionPunto.setString(3, String.valueOf(punto.getCodigoRuta()));
            declaracionPunto.setString(4, String.valueOf(punto.getCapacidad()));
            declaracionPunto.setString(5, punto.getUser().getUserName());
            declaracionPunto.executeUpdate();
            declaracionPunto = coneccion.prepareStatement(STATEMENT_GUARDAR_PRECIO_PUNTO);
            Tarifa tarifa = punto.getPrecio().get(punto.getPrecio().size() - 1);
            declaracionPunto.setString(1, String.valueOf(tarifa.getFecha()));
            declaracionPunto.setString(2, String.valueOf(tarifa.getPrecio()));
            declaracionPunto.setString(3, String.valueOf(punto.getCodigo()));
            declaracionPunto.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }
    }

    public static ArrayList<Ruta> obtenerRutas() {
        ArrayList<Ruta> rutas = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_RUTAS);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                int codigoRuta = resultado2.getInt("codigo");
                rutas.add(new Ruta(codigoRuta, resultado2.getBoolean("estado"),obtenerDestinoPorCodigo(resultado2.getInt("codigoDestino")), obtenerPuntosPorRuta(codigoRuta)));
            }
        } catch (SQLException e) {
            System.out.println("Error Al Cargar");
        }
        return rutas;
    }

    public static Ruta obtenerRutas(int codigo) {
        Ruta ruta = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_RUTAS_POR_CODIGO);
            declaracionPreparada.setString(1, String.valueOf(codigo));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                int codigoRuta = resultado2.getInt("codigo");
                ruta = new Ruta(codigoRuta, resultado2.getBoolean("estado"), null, obtenerPuntosPorRuta(codigoRuta));
            }
        } catch (Exception e) {
        }
        return ruta;
    }

    public static PuntoDeControl obtenerPuntoDeControl(int codigo) {
        PuntoDeControl puntoDeControl = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_RUTAS_POR_CODIGO);
            declaracionPreparada.setString(1, String.valueOf(codigo));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                puntoDeControl = new PuntoDeControl(codigo, resultado2.getInt("cantidadDePaquetes"),
                        verificarUserName(resultado2.getString("userNameUsuario")), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_PUNTO));

                puntoDeControl.setCodigoRuta(resultado2.getInt("numeroEnRuta"));
            }
        } catch (Exception e) {
        }
        return puntoDeControl;
    }

    public static ArrayList<PuntoDeControl> obtenerPuntosPorRuta(int codigoRuta) {
        ArrayList<PuntoDeControl> puntosDeControl = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PUNTOS_DE_CONTROL_POR_RUTA);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                PuntoDeControl punto = new PuntoDeControl(codigo, resultado.getInt("cantidadDePaquetes"),
                        verificarUserName(resultado.getString("userNameUsuario")), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_PUNTO));

                puntosDeControl.add(punto);
                punto.setCodigoRuta(resultado.getInt("numeroEnRuta"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return puntosDeControl;

    }

    public static Destino obtenerDestinoPorCodigo(int codigo) {
        Destino destino = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_DESTINO_POR_CODIGO);
            declaracionPreparada.setString(1, String.valueOf(codigo));
            ResultSet resultado = declaracionPreparada.executeQuery();
            if (resultado.next()) {
                destino = new Destino(resultado.getInt("codigo"), resultado.getString("nombre"), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_DESTINO));
            }
        } catch (Exception e) {
        }
        return destino;
    }

    public static ArrayList<Destino> obtenerDestino() {
        ArrayList<Destino> destino = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_DESTINOS);
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                destino.add(new Destino(codigo, resultado.getString("nombre"), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_DESTINO)));
            }
        } catch (SQLException e) {
        }
        return destino;
    }

    //1.Por Libra 2.Por priorizacion 3.OperacionGlobal
    public static float[] obtenerPrecioActuales() {
        final int NUMERO_PRECIOS = 3;
        float[] precios = new float[NUMERO_PRECIOS];
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PRECIO_ADMIN_ACTUALES);
            ResultSet resultado = declaracionPreparada.executeQuery();
            if (resultado.next()) {
                precios[0] = resultado.getFloat(2);
                precios[1] = resultado.getFloat(3);
                precios[2] = resultado.getFloat(4);
            }
        } catch (SQLException e) {
            System.out.println("Error ");
        }
        return precios;
    }

    public static LocalDateTime obtenerFechaDePrecioActuales() {
        LocalDateTime fecha = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PRECIO_ADMIN_ACTUALES);
            ResultSet resultado = declaracionPreparada.executeQuery();
            if (resultado.next()) {
                fecha = resultado.getObject("fecha", LocalDateTime.class);
            }
        } catch (SQLException e) {
            System.out.println("Error ");
        }
        return fecha;
    }

    public static ArrayList<Tarifa> obtenerPreciosPorCodigo(int codigo, int tipo) {
        ArrayList<Tarifa> precios = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = null;
            if (tipo == TIPO_PRECIO_PUNTO) {
                declaracionPreparada = coneccion.prepareStatement(STATEMENT_PRECIO_PUNTO_POR_CODIGO);
            } else if (tipo == TIPO_PRECIO_DESTINO) {
                declaracionPreparada = coneccion.prepareStatement(STATEMENT_PRECIO_DESTINO_POR_CODIGO);
            }
            declaracionPreparada.setString(1, String.valueOf(codigo));
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                precios.add(new Tarifa(resultado.getFloat("tarifa"), resultado.getObject("fecha", LocalDateTime.class)));
            }
        } catch (SQLException e) {
        }
        return precios;
    }
    public static void eliminarUsuario(Usuario user){
        try {
            PreparedStatement declaracionDeleteUser=coneccion.prepareStatement(STATEMENT_DELETE_USUARIO);
            declaracionDeleteUser.setString(1,user.getUserName());
            declaracionDeleteUser.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar");
        }
    }
    public static Cliente verificarCliente(int nit) {
        Cliente userNameValido = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_CLIENTE_POR_NIT);
            declaracionPreparada.setString(1,String.valueOf( nit));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            if (resultado2.next()) { 
                         userNameValido = new Cliente(resultado2.getInt("nit"),resultado2.getInt("codigo"),resultado2.getString("nombre"),resultado2.getString("direccion"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userNameValido;
    }  
    public static ArrayList obtenerCodigoDeClientes() {
        ArrayList codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_CLIENTES);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(resultado2.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    } 
    public static void guardarCliente(Cliente cliente) {
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_CLIENTE);
            declaracionPreparada.setString(1, String.valueOf(cliente.getCodigo()));
            if (cliente.getNit()==0) {
               declaracionPreparada.setString(3, null); 
            }else{
                declaracionPreparada.setString(3,String.valueOf(cliente.getNit())); 
            }            
            declaracionPreparada.setString(4, cliente.getNombre());
            declaracionPreparada.setString(2, cliente.getDireccion());
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }
    }
    public static Paquete verificarPaquete(int nit) {
        Paquete userNameValido = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PAQUETE_POR_CODIGO);
            declaracionPreparada.setString(1,String.valueOf( nit));
            ResultSet resultado = declaracionPreparada.executeQuery();
            if (resultado.next()) { 
                         userNameValido = new Paquete(resultado.getInt("codigo"),resultado.getInt("peso"),
                                 obtenerRutas(resultado.getInt("codigoRuta")),verificarCliente(resultado.getInt("codigoCliente")),
                                 resultado.getBoolean("priorizado"), resultado.getObject("fechaIngreso", LocalDateTime.class),
                                 resultado.getInt("numeroENCola"),resultado.getInt("estado"),resultado.getFloat("precioPerdido"),
                                 resultado.getFloat("precioPagado"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userNameValido;
    }  
    public static ArrayList obtenerCodigoDePaquetes() {
        ArrayList codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_PAQUETES);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(resultado2.getInt("codigo"));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }    
}
