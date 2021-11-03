/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico.control;

import java.sql.Connection;
import java.sql.SQLException;
import paqueteturistico.modelo.Conexion;

/**
 *
 * @author Leonardo
 */
public class MenuData {
    private Connection con;

    public MenuData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
}

}