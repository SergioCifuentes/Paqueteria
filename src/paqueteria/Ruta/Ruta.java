/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

import java.util.ArrayList;

/**
 *
 * @author sergio
 */
public class Ruta {
    private int codigo;
    private boolean estado;
    private Destino destino;
    private ArrayList<PuntoDeControl> puntos;

    public Ruta(int codigo, boolean estado, Destino destino, ArrayList<PuntoDeControl> puntos) {
        this.codigo = codigo;
        this.estado = estado;
        this.destino = destino;
        this.puntos = puntos;
    }

    public int getCodigo() {
        return codigo;
    }

    public boolean isEstado() {
        return estado;
    }

    public Destino getDestino() {
        return destino;
    }

    public ArrayList<PuntoDeControl> getPuntos() {
        return puntos;
    }
    
}
