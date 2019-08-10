/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

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

    public PuntoDeControl(int codigo, int numero, int capacidad, Usuario user) {
        this.codigo = codigo;
        this.numero = numero;
        this.capacidad = capacidad;
        this.user = user;
    }
}
