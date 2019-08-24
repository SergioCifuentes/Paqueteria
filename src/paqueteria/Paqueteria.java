/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria;

import paqueteria.DB.ControladorDB;
import paqueteria.DB.ControladorDeBodega;
import paqueteria.DB.TransferenciasDB;
import paqueteria.ui.IngresoDeUsuario;

/**
 *
 * @author sergio
 */
public class Paqueteria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControladorDB controladorDB = new ControladorDB();
        TransferenciasDB transferenciasDB= new TransferenciasDB();
                ControladorDeBodega nuevo = new ControladorDeBodega();
        new Thread(nuevo).start();
        IngresoDeUsuario nuevoUsuario = new IngresoDeUsuario();
        nuevoUsuario.setVisible(true);
    }
    
}
