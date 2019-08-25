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
import java.time.LocalDateTime;
import java.util.ArrayList;
import static paqueteria.DB.ControladorDB.verificarPaquete;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Ruta.Tarifa;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class TransferenciasDB {

    private final static String STATEMENT_SUBIR_ESTADO_POR_CODIGO = "UPDATE Paquete SET estado =estado+1 WHERE codigo =?";
    private final static String STATEMENT_CAMBIAR_ESTADO_RUTA = "UPDATE Ruta SET estado =? WHERE codigo =?";
    private final static String STATEMENT_ELIMINAR_PUNTOS_POR_RUTA = "DELETE FROM PuntoDeControl WHERE codigoRuta =?";
    private final static String STATEMENT_ELIMINAR_PUNTOS = "DELETE FROM PuntoDeControl WHERE codigo = ?";
    private final static String STATEMENT_REGISTRAR_RETIRO = "UPDATE Paquete SET fechaRecibido =? WHERE codigo =?";
    private final static String STATEMENT_UPDATE_CODIGO_PUNTO = "UPDATE Paquete SET codigoPunto =?  WHERE codigo =?";
    private final static String STATEMENT_UPDATE_NUMERO_COLA = "UPDATE Paquete SET numeroEnCola =? WHERE codigo =?";
    private final static String STATEMENT_UPDATE_PRECIO_PERDIDO = "UPDATE Paquete SET precioPerdido =precioPerdido+? WHERE codigo =?";
    private final static String STATEMENT_PAQUETE_POR_PUNTO = "SELECT * FROM Paquete WHERE codigoPunto = ?";
    private final static String STATEMENT_PAQUETE_POR_RUTA_ACTIVOS = "SELECT * FROM Paquete WHERE codigoRuta = ? AND estado<3";
    private final static String STATEMENT_PAQUETE_POR_RUTA= "SELECT * FROM Paquete WHERE codigoRuta = ? ";
    private final static String STATEMENT_PAQUETE_POR_RUTA_SALIDOS = "SELECT * FROM Paquete WHERE codigoRuta = ? AND estado>=3";
    private final static String STATEMENT_PAQUETE_POR_CLIENTE = "SELECT * FROM Paquete WHERE codigoCliente = ?";
    private final static String STATEMENT_PUNTOS_DE_CONTROL = "SELECT * FROM PuntoDeControl ORDER BY codigoRuta ";

    private static Connection coneccion2 = null;

    public TransferenciasDB() {
        try {
            coneccion2 = DriverManager.getConnection(STRING_CONNECTION, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error Al conectar DB");
        }
    }

    public static void moverEstadoDePaquete(int codigo) {
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_SUBIR_ESTADO_POR_CODIGO);
            declaracionPreparada.setString(1, String.valueOf(codigo));
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al mover");
        }

    }

    public static void registrarRetiroDePaquete(int codigo) {
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_REGISTRAR_RETIRO);
            declaracionPreparada.setString(1, String.valueOf(LocalDateTime.now()));
            declaracionPreparada.setString(2, String.valueOf(codigo));
            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Retirar");
        }

    }

    public static ArrayList<Paquete> obtenerPaquetesPorPunto(int codigoPunto) {
        ArrayList<Paquete> codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_PUNTO);
            declaracionPreparada.setString(1, String.valueOf(codigoPunto));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(verificarPaquete(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }

    public static ArrayList<Paquete> obtenerPaquetesActivosPorRuta(int codigoRuta) {
        ArrayList<Paquete> codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_ACTIVOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(verificarPaquete(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }
    
    public static ArrayList<Paquete> obtenerPaquetesNoActivosPorRuta(int codigoRuta) {
        ArrayList<Paquete> codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_SALIDOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(verificarPaquete(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }
    public static ArrayList<Paquete> obtenerPaquetesPorCliente(int codigoCliente) {
        ArrayList<Paquete> codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_CLIENTE);
            declaracionPreparada.setString(1, String.valueOf(codigoCliente));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                codigos.add(verificarPaquete(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }        

    public static float obtenerTarifaDePaquete(Paquete paquete) {
        ArrayList<Tarifa> tarifas = ControladorDB.obtenerPreciosPorCodigo(paquete.getPunto().getCodigo(), ControladorDB.TIPO_PRECIO_PUNTO);
        for (int i = 0; i < tarifas.size(); i++) {
            if (paquete.getFechaIngresado().isBefore(tarifas.get(i).getFecha())) {
                return tarifas.get(i - 1).getPrecio();
            }
        }
        return tarifas.get(tarifas.size() - 1).getPrecio();
    }

    public static void procesarPaquete(Paquete paquete, float tarifa) {
        //En caso de que el paquete ya este en su ultimo punto de control
        try {
            coneccion2.setAutoCommit(false);
            PreparedStatement declaracionPaqueteCodigo = coneccion2.prepareStatement(STATEMENT_UPDATE_CODIGO_PUNTO);
            PreparedStatement declaracionPaqueteNumero = coneccion2.prepareStatement(STATEMENT_UPDATE_NUMERO_COLA);
            PreparedStatement declaracionPrecio = coneccion2.prepareStatement(STATEMENT_UPDATE_PRECIO_PERDIDO);

            if (paquete.getPunto().getNumero() == ControladorDB.obtenerPuntosPorRuta(paquete.getRuta().getCodigo()).size()) {
                moverEstadoDePaquete(paquete.getCodigo());
                registrarRetiroDePaquete(paquete.getCodigo());
                declaracionPaqueteCodigo.setString(1, null);
                declaracionPaqueteNumero.setString(1, null);
            } else {
                int codigoSiguientePunto = obtenerSiguientePunto(paquete.getPunto()).getCodigo();
                declaracionPaqueteCodigo.setString(1, String.valueOf(codigoSiguientePunto));
                declaracionPaqueteNumero.setString(1, String.valueOf(obtenerPaquetesPorPunto(codigoSiguientePunto).size() + 1));
            }
            declaracionPrecio.setString(1, String.valueOf(tarifa));
            declaracionPrecio.setString(2, String.valueOf(paquete.getCodigo()));
            declaracionPaqueteCodigo.setString(2, String.valueOf(paquete.getCodigo()));
            declaracionPaqueteNumero.setString(2, String.valueOf(paquete.getCodigo()));
            declaracionPrecio.executeUpdate();
            declaracionPaqueteCodigo.executeUpdate();
            declaracionPaqueteNumero.executeUpdate();
            coneccion2.commit();
            coneccion2.setAutoCommit(true);
        } catch (SQLException ex) {
            System.out.println("Error Al Guardar");
            try {
                coneccion2.rollback();
            } catch (SQLException ex1) {
                System.out.println("Error RollBack");
            }
        }

    }

    public static PuntoDeControl obtenerSiguientePunto(PuntoDeControl puntoAnterior) {
        System.out.println(puntoAnterior.getCodigoRuta());
        ArrayList<PuntoDeControl> puntosDeRuta = ControladorDB.obtenerPuntosPorRuta(puntoAnterior.getCodigoRuta());
        return puntosDeRuta.get(puntoAnterior.getNumero());
    }

    public static void ingresarPaqueteDesdeBodega(Paquete paquete, PuntoDeControl puntoSiguinte) {
        try {
            coneccion2.setAutoCommit(false);
            moverEstadoDePaquete(paquete.getCodigo());
            PreparedStatement declaracionPaqueteCodigo = coneccion2.prepareStatement(STATEMENT_UPDATE_CODIGO_PUNTO);
            PreparedStatement declaracionPaqueteNumero = coneccion2.prepareStatement(STATEMENT_UPDATE_NUMERO_COLA);
            declaracionPaqueteCodigo.setString(1, String.valueOf(puntoSiguinte.getCodigo()));
            declaracionPaqueteNumero.setString(1, String.valueOf(obtenerPaquetesPorPunto(puntoSiguinte.getCodigo()).size() + 1));
            declaracionPaqueteCodigo.setString(2, String.valueOf(paquete.getCodigo()));
            declaracionPaqueteNumero.setString(2, String.valueOf(paquete.getCodigo()));
            declaracionPaqueteCodigo.executeUpdate();
            declaracionPaqueteNumero.executeUpdate();
            coneccion2.commit();
            coneccion2.setAutoCommit(true);
        } catch (SQLException ex) {
            try {
                coneccion2.rollback();
            } catch (SQLException ex1) {
                System.out.println("Error RollBack");
            }
        }
    }

    public static void cambiarEstadoRuta(int codigoRuta, int estado) {
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_CAMBIAR_ESTADO_RUTA);
            declaracionPreparada.setString(1, String.valueOf(estado));
            declaracionPreparada.setString(2, String.valueOf(codigoRuta));

            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Cambiar");
        }

    }

    public static void actualizarPuntos(int codigoRuta,ArrayList<PuntoDeControl> puntos) {
            eliminarPuntosPorRuta(codigoRuta);
            for (int i = 0; i < puntos.size(); i++) {
                ControladorDB.guardarPuntoDeControl(puntos.get(i));                
            }
    }
    public static void actualizarPunto(PuntoDeControl punto) {
            eliminarPunto(punto.getCodigo());
             ControladorDB.guardarPuntoDeControl(punto);                
    
    }
    public static void eliminarPuntosPorRuta(int codigoRuta) {
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_ELIMINAR_PUNTOS_POR_RUTA);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));

            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar");
        }
    }
    public static void eliminarPunto(int codigoPunto) {
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_ELIMINAR_PUNTOS);
            declaracionPreparada.setString(1, String.valueOf(codigoPunto));

            declaracionPreparada.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error Al Eliminar");
        }
    }    
    public static ArrayList<PuntoDeControl> obtenerTodosLosPuntos() {
        ArrayList<PuntoDeControl> puntos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PUNTOS_DE_CONTROL);
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                puntos.add(ControladorDB.obtenerPuntoDeControl(resultado2.getInt("codigo")));
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return puntos;
    }
    public static float  obtenerGananciasPorRuta(int codigoRuta) {
        float ganancias = 0;
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_ACTIVOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                ganancias=ganancias+verificarPaquete(resultado2.getInt("codigo")).getPrecioPagado();
            }
            declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_SALIDOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado3 = declaracionPreparada.executeQuery();
            while (resultado3.next()) {
                ganancias=ganancias+verificarPaquete(resultado3.getInt("codigo")).getPrecioPagado();
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return ganancias;
    }    
    public static float  obtenerPerdidaPorRuta(int codigoRuta) {
        float perdida = 0;
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_ACTIVOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                perdida=perdida+verificarPaquete(resultado2.getInt("codigo")).getPrecioPerdido();
            }
            declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA_SALIDOS);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado3 = declaracionPreparada.executeQuery();
            while (resultado3.next()) {
                perdida=perdida+verificarPaquete(resultado3.getInt("codigo")).getPrecioPerdido();
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return perdida;
    }
    public static float  obtenerGananciasPorRutaFecha(int codigoRuta,LocalDateTime inicio,LocalDateTime fin) {
        float ganancias = 0;
        ArrayList<Paquete> paquetesFecha = obtenerPaquetesPorRutaFecha(codigoRuta, inicio, fin);
        for (int i = 0; i < paquetesFecha.size(); i++) {
            ganancias= ganancias+paquetesFecha.get(i).getPrecioPagado();            
        }
        return ganancias;
    }
    public static float  obtenerPerdidaPorRutaFecha(int codigoRuta,LocalDateTime inicio,LocalDateTime fin) {
        float perdidas = 0;
        ArrayList<Paquete> paquetesFecha = obtenerPaquetesPorRutaFecha(codigoRuta, inicio, fin);
        for (int i = 0; i < paquetesFecha.size(); i++) {
            perdidas= perdidas+paquetesFecha.get(i).getPrecioPerdido();            
        }
        return perdidas;
    }
        public static ArrayList<Paquete> obtenerPaquetesPorRutaFecha(int codigoRuta,LocalDateTime inicio,LocalDateTime fin) {
        ArrayList<Paquete> codigos = new ArrayList();
        try {
            PreparedStatement declaracionPreparada = coneccion2.prepareStatement(STATEMENT_PAQUETE_POR_RUTA);
            declaracionPreparada.setString(1, String.valueOf(codigoRuta));
            ResultSet resultado2 = declaracionPreparada.executeQuery();
            while (resultado2.next()) {
                Paquete pack=verificarPaquete(resultado2.getInt("codigo"));
                if (pack.getFechaIngresado().isBefore(fin)&&pack.getFechaIngresado().isAfter(inicio)) {
                    codigos.add(pack);
                }
                
            }
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return codigos;
    }
    private final static String USER = "root";
    private final static String PASSWORD = "danielito";
    private final static String STRING_CONNECTION = "jdbc:mysql://localhost:3306/paquetes";
}
