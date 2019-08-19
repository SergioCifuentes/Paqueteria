/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.DB;

import java.util.ArrayList;
import paqueteria.DB.ControladorDB;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class GeneradorDeCodigos {

    public static int generarCodigoRuta() {
        int codigo = 110000;
        if (ControladorDB.obtenerCodigoDeRutas() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDeRutas().size();
        }

        while (ControladorDB.obtenerRutas(codigo) != null) {
            codigo++;
        }
        return codigo;
    }

    public static int generarCodigoPuntoDeControl() {
        int codigo = 220000;
        if (ControladorDB.obtenerCodigoDePuntosDeControl() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDePuntosDeControl().size();
        }

        while (ControladorDB.obtenerRutas(codigo) != null) {
            codigo++;
        }
        return codigo;
    }

    public static int generarCodigoPuntoDeControl(ArrayList<PuntoDeControl> puntos) {
        int codigo = 220000;
        if (ControladorDB.obtenerCodigoDePuntosDeControl() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDePuntosDeControl().size();
        }

        while (ControladorDB.obtenerRutas(codigo) != null) {
            codigo++;
        }
        if (puntos != null) {
            boolean auxiliar;
            do {
                auxiliar = false;
                for (int i = 0; i < puntos.size(); i++) {
                    if (codigo == puntos.get(i).getCodigo()) {
                        auxiliar = true;
                        codigo++;
                    }

                }
            } while (auxiliar);
        }

        return codigo;
    }

    public static int generarCodigoDestino() {
        int codigo = 330000;
        if (ControladorDB.obtenerCodigoDeDestinos() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDeDestinos().size();
        }

        while (ControladorDB.obtenerPuntoDeControl(codigo) != null) {
            codigo++;
        }
        return codigo;
    }

    public static int generarCodigoCliente() {
        int codigo = 440000;
        if (ControladorDB.obtenerCodigoDeClientes() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDeClientes().size();
        }
        while (ControladorDB.verificarClientePorNit(codigo) != null) {
            codigo++;
        }
        return codigo;
    }
    public static int generarCodigoPaquete(ArrayList<Paquete> paquetes) {
        int codigo = 550000;
        if (ControladorDB.obtenerCodigoDePaquetes() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDePaquetes().size();
        }
        while (ControladorDB.verificarPaquete(codigo) != null) {
            codigo++;
        }
        if (paquetes != null) {
            boolean auxiliar;
            do {
                auxiliar = false;
                for (int i = 0; i < paquetes.size(); i++) {
                    if (codigo == paquetes.get(i).getCodigo()) {
                        auxiliar = true;
                        codigo++;
                    }

                }
            } while (auxiliar);
        }        
        return codigo;
    }
    public static int generarCodigoPaquete() {
        int codigo = 550000;
        if (ControladorDB.obtenerCodigoDePaquetes() != null) {
            codigo = codigo + ControladorDB.obtenerCodigoDePaquetes().size();
        }
        while (ControladorDB.verificarPaquete(codigo) != null) {
            codigo++;
        }        
        return codigo;
    }      
}
