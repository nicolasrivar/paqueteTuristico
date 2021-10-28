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
public class Menu {
    private int idMenu;
    private int idAlojamiento;
    private String tipoMenu;
    private int precioMenu;
    private boolean activo;

    

    public Menu() {
    }

    public Menu(int idAlojamiento, String tipoMenu, int precioMenu, boolean activo) {
        this.idAlojamiento = idAlojamiento;
        this.tipoMenu = tipoMenu;
        this.precioMenu = precioMenu;
        this.activo = activo;
    }

    public Menu(int idMenu, int idAlojamiento, String tipoMenu, int precioMenu, boolean activo) {
        this.idMenu = idMenu;
        this.idAlojamiento = idAlojamiento;
        this.tipoMenu = tipoMenu;
        this.precioMenu = precioMenu;
        this.activo = activo;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public int getPrecioMenu() {
        return precioMenu;
    }

    public void setPrecioMenu(int precioMenu) {
        this.precioMenu = precioMenu;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
}
