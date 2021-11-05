/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paqueteturistico.modelo;

/**
 *
 * @author user
 */
public class Transporte {
    private int idTransporte;
    private int idDestino;
    private float precioViaje;
    private String tipoTransporte; 
    private boolean activo;

    public Transporte() {
    }

    public Transporte(int idDestino, float precioViaje, String tipoTransporte, boolean activo) {
        this.idDestino = idDestino;
        this.precioViaje = precioViaje;
        this.tipoTransporte = tipoTransporte;
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Transporte{" + "idTransporte=" + idTransporte + ", tipoTransporte=" + tipoTransporte + '}';
    }


    public Transporte(int idTransporte, int idDestino, float precioViaje, String tipoTransporte, boolean activo) {
        this.idTransporte = idTransporte;
        this.idDestino = idDestino;
        this.precioViaje = precioViaje;
        this.tipoTransporte = tipoTransporte;
        this.activo = activo;
    }

    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public float getPrecioViaje() {
        return precioViaje;
    }

    public void setPrecioViaje(float precioViaje) {
        this.precioViaje = precioViaje;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
