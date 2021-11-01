/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico.modelo;

import java.time.LocalDate;

/**
 *
 * @author Leonardo
 */
public class Paquete {
    private int idPaquete;
    private int idAlojamiento;
    private int idMenu;
    private int idTransporte;
    private int idCliente;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private int cantPersonas;
    private float montoFinal;
    private boolean activo;

    public Paquete(int idPaquete, int idAlojamiento, int idMenu, int idTransporte, int idCliente, LocalDate fechaInicial, LocalDate fechaFinal, int cantPersonas, float montoFinal, boolean activo) {
        this.idPaquete = idPaquete;
        this.idAlojamiento = idAlojamiento;
        this.idMenu = idMenu;
        this.idTransporte = idTransporte;
        this.idCliente = idCliente;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cantPersonas = cantPersonas;
        this.montoFinal = montoFinal;
        this.activo = activo;
    }

    public Paquete(LocalDate fechaInicial, LocalDate fechaFinal, int cantPersonas, float montoFinal, boolean activo) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.cantPersonas = cantPersonas;
        this.montoFinal = montoFinal;
        this.activo = activo;
    }

    public Paquete() {
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public float getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(float montoFinal) {
        this.montoFinal = montoFinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return  "idCliente=" + idCliente + ", cantPersonas=" + cantPersonas + ", montoFinal=" + montoFinal + "\n";
    }
    
    
    
    
}
