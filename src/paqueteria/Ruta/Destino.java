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
public class Destino {
    private int codigo;
    private String nombre;
    private ArrayList<Tarifa> precio;

    public Destino(int codigo, String nombre,ArrayList<Tarifa> precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio=precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Tarifa> getPrecio() {
        return precio;
    }

    
}
