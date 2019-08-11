/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

import paqueteria.DB.ControladorDB;

/**
 *
 * @author sergio
 */
public class GeneradorDeCodigos {

    public static int generarCodigoRuta() {
        int codigo = 110000;
        if (ControladorDB.obtenerCodigoDeRutas()!=null) {
            codigo=codigo+ControladorDB.obtenerCodigoDeRutas().size();
        }
        
        while(ControladorDB.obtenerRutas(codigo)!=null){
            codigo++;
        }
        return codigo;
    }

    public static int generarCodigoPuntoDeControl() {
        int codigo = 220000;
        if (ControladorDB.obtenerCodigoDePuntosDeControl()!=null) {
            codigo=codigo+ControladorDB.obtenerCodigoDePuntosDeControl().size();
        }
        
        while(ControladorDB.obtenerRutas(codigo)!=null){
            codigo++;
        }
        return codigo;
    }

    public static int generarCodigoDestino() {
        int codigo = 330000;
        if (ControladorDB.obtenerCodigoDeDestinos()!=null) {
            codigo=codigo+ControladorDB.obtenerCodigoDeDestinos().size();
        }
        
        while(ControladorDB.obtenerPuntoDeControl(codigo)!=null){
            codigo++;
        }
        return codigo;
    }
}
