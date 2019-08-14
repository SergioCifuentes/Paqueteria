/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

import java.util.ArrayList;
import paqueteria.Usuario.Usuario;

/**
 *
 * @author sergio
 */
public class PuntoDeControl {
    private int codigo;
    private int numero;
    private int codigoRuta;
    private int capacidad;
    private Usuario user;
    private ArrayList<Tarifa> precio;

    public void setCodigoRuta(int codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNumero() {
        return numero;
    }

    public int getCodigoRuta() {
        return codigoRuta;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public Usuario getUser() {
        return user;
    }

    public PuntoDeControl(int codigo, int capacidad, Usuario user,ArrayList<Tarifa> precio) {
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.user = user;
        this.precio = precio;
    }

    public ArrayList<Tarifa> getPrecio() {
        return precio;
    }

    public void setPrecio(ArrayList<Tarifa> precio) {
        this.precio = precio;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
