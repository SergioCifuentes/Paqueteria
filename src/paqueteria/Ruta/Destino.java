/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

/**
 *
 * @author sergio
 */
public class Destino {
    private int codigo;
    private String nombre;
    private int couta;

    public Destino(int codigo, String nombre, int couta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.couta = couta;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCouta() {
        return couta;
    }
    
}
