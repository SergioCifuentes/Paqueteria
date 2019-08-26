/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.DB;

import java.util.ArrayList;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class ControladorDeBodega implements Runnable {

    private ArrayList<Paquete> paquetes;

    @Override
    public void run() {
        paquetes = obtenerPaquetesSegunPriorizacion();
        buscarTransferencias();
        
    }
// se organizen todos los paquetes que esten en bodega para que los que estan priorizados esten de primero en la lista
    private ArrayList<Paquete> obtenerPaquetesSegunPriorizacion() {
        ArrayList<Paquete> paquetesOrdenados = new ArrayList<>();
        ArrayList<Paquete> paquetesEnBodega = ControladorDB.obtenerPaquetesPorEstado(1);
        for (int i = 0; i < paquetesEnBodega.size(); i++) {
            if (paquetesEnBodega.get(i).isPriorizado()) {
                paquetesOrdenados.add(paquetesEnBodega.get(i));
            }
        }
        for (int i = 0; i < paquetesEnBodega.size(); i++) {
            boolean aux = true;
            for (int j = 0; j < paquetesOrdenados.size(); j++) {
                if (paquetesEnBodega.get(i).getCodigo() == paquetesOrdenados.get(j).getCodigo()) {
                    aux = false;
                }

            }
            if (aux) {
                paquetesOrdenados.add(paquetesEnBodega.get(i));
            }
        }
        return paquetesOrdenados;
    }
    //Luego de ordenar los paquetes de la forma posterior se verifica si se pueden processar los paquetes
    private void buscarTransferencias(){
        for (int i = 0; i < paquetes.size(); i++) {
            //Se obtiene el punto siguietne de cada paquete
            PuntoDeControl puntoSiguiente = ControladorDB.obtenerPuntosPorRuta(paquetes.get(i).getRuta().getCodigo()).get(0);
            if (TransferenciasDB.obtenerPaquetesPorPunto(puntoSiguiente.getCodigo()
            ).size()<puntoSiguiente.getCapacidad()) {
                TransferenciasDB.ingresarPaqueteDesdeBodega(paquetes.get(i), puntoSiguiente);
            }
        }
    }
}
