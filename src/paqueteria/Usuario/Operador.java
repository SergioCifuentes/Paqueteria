/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Usuario;

import paqueteria.DB.TransferenciasDB;
import paqueteria.paquetes.Paquete;

/**
 *
 * @author sergio
 */
public class Operador extends Usuario{
    public Operador(String userName, String password, int jerarquia) {
        super(userName, password, jerarquia);
    }
    public void preocesarPaquete(Paquete paquete,float tarifa){
        TransferenciasDB.procesarPaquete(paquete, tarifa);
    }
}
