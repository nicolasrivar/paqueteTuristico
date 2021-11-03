/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import paqueteturistico.modelo.Conexion;
import paqueteturistico.modelo.Menu;

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
    
   public Menu obtenerMenu(int idMenu){
       Menu menu=null;
    
    String sql="SELECT * FROM menu WHERE idMenu = ?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idMenu);
            
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                menu = new Menu();
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setIdAlojamiento(rs.getInt(2));
                menu.setTipoMenu(rs.getString(3));
                menu.setPrecioMenu(rs.getFloat(4));
                menu.setActivo(rs.getBoolean(5));
            }
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar el menu" + ex);
        }    
       return menu;  
   }

}