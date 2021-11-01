/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico.modelo;

/**
 *
 * @author Leonardo
 */
public class Cliente {
    private int idCliente;
    private String NombreCompleto;
    private String email;
    private double dni;
    private long telefono;
    private boolean activo;

    public Cliente() {
    }

    public Cliente(String NombreCompleto, String email, double dni, long telefono, boolean activo) {
        this.NombreCompleto = NombreCompleto;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Cliente(int idCliente, String NombreCompleto, String email, double dni, long telefono, boolean activo) {
        this.idCliente = idCliente;
        this.NombreCompleto = NombreCompleto;
        this.email = email;
        this.dni = dni;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    @Override
    public String toString() {
        return "Nombre Completo= " + nombreCompleto + ", email= " + email + ", dni= " + dni + ", telefono= " + telefono + "\n";
    }
    
    
}
