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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import paqueteturistico.modelo.Alojamiento;
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
   
   public List<Menu> buscarMenus(){
        List<Menu> menus=new ArrayList<>();
        
         Menu menu=null;
        
        String sql="SELECT * FROM menu ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                menu = new Menu();
                
                menu.setIdMenu(rs.getInt("idMenu"));
                menu.setIdAlojamiento(rs.getInt("idAlojamiento"));
                menu.setTipoMenu(rs.getString("tipoMenu"));
                menu.setPrecioMenu(rs.getFloat("precioMenu"));
                menu.setActivo(rs.getBoolean("activo"));
                
                menus.add(menu);

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar menus"+ex);
        }    
       return menus; 
        
    }
   
   public void agregarMenu(Menu menu){
       String sql = "INSERT INTO menu ( idAlojamiento, tipoMenu, precioMenu, activo) VALUES (?,?,?,?)";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, menu.getIdAlojamiento());
            ps.setString(2, menu.getTipoMenu());
            ps.setFloat(3, menu.getPrecioMenu());
            ps.setBoolean(4, menu.isActivo());
                     
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys(); 
            if (rs.next()){
             menu.setIdMenu(rs.getInt(1));
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar "+ex);
        }
   }
   
   public void actualizarMenu(Menu menu){
       String sql = "UPDATE menu SET idAlojamiento=?, tipoMenu=?, precioMenu=? ,activo=? WHERE idMenu=?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, menu.getIdAlojamiento());
            ps.setString(2, menu.getTipoMenu());
            ps.setFloat(3, menu.getPrecioMenu());
            ps.setBoolean(4, menu.isActivo());
            ps.setInt(5, menu.getIdMenu());
            ps.executeUpdate();           
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar "+ex);
        }
   }


}