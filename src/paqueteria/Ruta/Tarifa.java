/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.Ruta;

import java.time.LocalDateTime;

/**
 *
 * @author sergio
 */
public class Tarifa {

    private float precio;
    private LocalDateTime fecha;

    public Tarifa(float precio, LocalDateTime fecha) {
        this.precio = precio;
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
    
}
