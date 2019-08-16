/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.paquetes;

/**
 *
 * @author sergio
 */
public class Cliente {
    private int nit;
    private int codigo;
    private String nombre;
    private String direccion;

    public Cliente(int nit, int codigo, String nombre, String direccion) {
        this.nit = nit;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getNit() {
        return nit;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
}
