/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico.modelo;

/**
 *
 * @author Nicolas
 */
public class Alojamiento {
    private int idAlojamiento;
    private int idDestino;
    private String ubicacion;
    private String nombreAlojamiento;
    private String tipoAlojamiento;
    private float precioNoche;
    boolean activo;


    public Alojamiento() {
    }

    public Alojamiento(int idAlojamiento, int idDestino, String ubicacion, String nombreAlojamiento, String tipoAlojamiento, float precioNoche, boolean activo) {
        this.idAlojamiento = idAlojamiento;
        this.idDestino = idDestino;
        this.ubicacion = ubicacion;
        this.nombreAlojamiento = nombreAlojamiento;
        this.tipoAlojamiento = tipoAlojamiento;
        this.precioNoche = precioNoche;
        this.activo = activo;
    }

    public Alojamiento(int idDestino, String ubicacion, String nombreAlojamiento, String tipoAlojamiento, float precioNoche, boolean activo) {
        this.idDestino = idDestino;
        this.ubicacion = ubicacion;
        this.nombreAlojamiento = nombreAlojamiento;
        this.tipoAlojamiento = tipoAlojamiento;
        this.precioNoche = precioNoche;
        this.activo = activo;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getTipoAlojamiento() {
        return tipoAlojamiento;
    }

    public void setTipoAlojamiento(String tipoAlojamiento) {
        this.tipoAlojamiento = tipoAlojamiento;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    

    
    
}
