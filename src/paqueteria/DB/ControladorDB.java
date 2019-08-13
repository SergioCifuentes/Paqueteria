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

/**
 *
 * @author sergio
 */
public class ControladorDB {

    private final static String STATEMENT_USUARIO_POR_NOMBRE = "SELECT * FROM Usuario WHERE userName = ?";
    private final static String STATEMENT_USUARIO_POR_JERARQUIA = "SELECT * FROM Usuario WHERE jerarquia = ?";
    private final static String STATEMENT_PRECIO_ADMIN_ACTUALES = "SELECT * FROM PreciosAdmin ORDER BY FECHA DESC";
    private final static String STATEMENT_PRECIO_PUNTO_POR_CODIGO = "SELECT * FROM PrecioPunto WHERE codigoPuntoControl = ? ORDER BY FECHA";
    private final static String STATEMENT_PRECIO_DESTINO_POR_CODIGO = "SELECT * FROM PrecioDestino WHERE codigoDestino = ? ORDER BY FECHA";
    private final static String STATEMENT_PUNTOS_DE_CONTROL_POR_RUTA = "SELECT * FROM PuntosDeControl WHERE codigoRuta = ?";
    private final static String STATEMENT_DESTINO_POR_CODIGO = "SELECT * FROM Destino WHERE codigo = ?";
    private final static String STATEMENT_GUARDAR_USUARIO = "INSERT INTO Usuario VALUES (?,?,?)";
    private final static String STATEMENT_GUARDAR_DESTINO = "INSERT INTO Destino VALUES (?,?)";
    private final static String STATEMENT_GUARDAR_PRECIO_ADMIN = "INSERT INTO PreciosAdmin VALUES (?,?,?,?)";
    private final static String STATEMENT_GUARDAR_PRECIO_DESTINO = "INSERT INTO PrecioDestino VALUES (?,?,?)";
    private final static String STATEMENT_OBTENER_RUTAS = "SELECT * FROM Ruta";
    private final static String STATEMENT_OBTENER_PUNTOS = "SELECT * FROM PuntoDeControl";
    private final static String STATEMENT_OBTENER_DESTINOS = "SELECT * FROM Destino";
    private final static String STATEMENT_OBTENER_RUTAS_POR_CODIGO = "SELECT * FROM Ruta WHERE codigo = ?";
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
                userNameValido = new Administrador(resultado2.getString("userName"), resultado2.getString("contrasena"), resultado2.getInt("jerarquia"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userNameValido;
    }
        public static ArrayList<Usuario> obteenerUsuarioPorJerarquia(int jerarquia) {
        ArrayList<Usuario> usuario = new ArrayList<>();
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_USUARIO_POR_JERARQUIA);
            declaracionPreparada.setString(1,String.valueOf( jerarquia));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            if (resultado2.next()) {
                usuario.add(new Usuario(resultado2.getString("userName"), resultado2.getString("contrasena"),jerarquia));
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
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_DESTINO);
            declaracionPreparada.setString(1, destino.getNombre());
            declaracionPreparada.setString(2, String.valueOf(destino.getCodigo()));
            declaracionPreparada.executeUpdate();
            declaracionPreparada = coneccion.prepareStatement(STATEMENT_GUARDAR_PRECIO_DESTINO);
            Tarifa tarifa = destino.getPrecio().get(destino.getPrecio().size()-1);
            declaracionPreparada.setString(1,String.valueOf(tarifa.getFecha()));
            declaracionPreparada.setString(2, String.valueOf(tarifa.getPrecio()));
            declaracionPreparada.setString(3,String.valueOf(destino.getCodigo()));
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Guardar");
        }
    }
    public static void guardarPreciosAdmin(LocalDateTime fecha,float precioLibra,float precioPriorizacion,float precioOperacion) {
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

    public static ArrayList<Ruta> obtenerRutas() {
        ArrayList<Ruta> rutas = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_OBTENER_RUTAS);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                int codigoRuta = resultado2.getInt("codigo");
                rutas.add(new Ruta(codigoRuta, resultado2.getBoolean("estado"), null, obtenerPuntosPorRuta(codigoRuta)));
            }
        } catch (Exception e) {
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
                puntoDeControl = new PuntoDeControl(codigo, resultado2.getInt("numeroEnRuta"), resultado2.getInt("cantidadDePaquetes"),
                        verificarUserName(resultado2.getString("userNameUsuario")), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_PUNTO));
            }
        } catch (Exception e) {
        }
        return puntoDeControl;
    }

    public static ArrayList<PuntoDeControl> obtenerPuntosPorRuta(int codigoRuta) {
        ArrayList<PuntoDeControl> puntosDeControl = null;
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PUNTOS_DE_CONTROL_POR_RUTA);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado = declaracionPreparada.executeQuery();
            while (resultado.next()) {
                int codigo = resultado.getInt("codigo");
                puntosDeControl.add(new PuntoDeControl(codigo, resultado.getInt("numeroEnRuta"), resultado.getInt("cantidadDePaquetes"),
                        verificarUserName(resultado.getString("userNameUsuario")), obtenerPreciosPorCodigo(codigo, TIPO_PRECIO_PUNTO)));
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
        final int NUMERO_PRECIOS=3;
        float[] precios = new float[NUMERO_PRECIOS];
        try {
            PreparedStatement declaracionPreparada = coneccion.prepareStatement(STATEMENT_PRECIO_ADMIN_ACTUALES);
            ResultSet resultado = declaracionPreparada.executeQuery();
            if (resultado.next()) {
                precios[0]=resultado.getFloat(2);
                precios[1]=resultado.getFloat(3);
                precios[2]=resultado.getFloat(4);
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
                fecha= resultado.getObject("fecha",LocalDateTime.class);
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
}
