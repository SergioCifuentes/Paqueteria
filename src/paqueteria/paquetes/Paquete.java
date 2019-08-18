/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.paquetes;

import java.time.LocalDateTime;
import paqueteria.Ruta.PuntoDeControl;
import paqueteria.Ruta.Ruta;

/**
 *
 * @author sergio
 */
public class Paquete {
    private int codigo;
    private int peso;
    private Ruta ruta;
    private Cliente cliente;
    private boolean priorizado;
    private LocalDateTime fechaIngresado;
    private LocalDateTime fechaRecibido;
    private int numeroEnCola;
    private PuntoDeControl punto;
    private int estado;
    private float precioPerdido;
    private float precioPagado;

    public Paquete(int codigo, int peso, Ruta ruta, boolean priorizado, LocalDateTime fechaIngresado,
            int numeroEnCola, int estado, float precioPerdido, float precioPagado) {
        this.codigo = codigo;
        this.peso = peso;
        this.ruta = ruta;
        this.priorizado = priorizado;
        this.fechaIngresado = fechaIngresado;
        this.numeroEnCola = numeroEnCola;
        this.estado = estado;
        this.precioPerdido = precioPerdido;
        this.precioPagado = precioPagado;
    }

    public void setNumeroEnCola(int numeroEnCola) {
        this.numeroEnCola = numeroEnCola;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getPeso() {
        return peso;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isPriorizado() {
        return priorizado;
    }

    public LocalDateTime getFechaIngresado() {
        return fechaIngresado;
    }

    public LocalDateTime getFechaRecibido() {
        return fechaRecibido;
    }

    public int getNumeroEnCola() {
        return numeroEnCola;
    }

    public PuntoDeControl getPunto() {
        return punto;
    }

    public int getEstado() {
        return estado;
    }

    public float getPrecioPerdido() {
        return precioPerdido;
    }

    public float getPrecioPagado() {
        return precioPagado;
    }
    
    
}
