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
import paqueteturistico.modelo.Conexion;
import paqueteturistico.modelo.Destino;

/**
 *
 * @author Leonardo
 */

public class DestinoData {
    private Connection con;

    public DestinoData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    }
    
    public List<Destino> obtenerDestinos(){ //buscar destinos
        List<Destino> destinos=new ArrayList<>();
        
        Destino destino=null;
        
        String sql="SELECT * FROM `destino` ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                   
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                destino = new Destino();
                destino.setIdDestino(rs.getInt("idDestino"));
                destino.setPaisDestino(rs.getString("paisDestino"));
                destino.setCiudadDestino(rs.getString("ciudadDestino"));
                destino.setActivo(rs.getBoolean("activo"));
                destinos.add(destino);

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar Destino ");
        }    
       return destinos; 
        
    }
 
    public Destino buscarDestino(int idDestino){ //buscar Pais destino por Id
        
        
        Destino destino=null;
        
        String sql="SELECT paisDestino, ciudadDestino, activo FROM destino WHERE destino.idDestino=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idDestino);        
            ResultSet rs =ps.executeQuery();
            
            if (rs.next()){
                destino = new Destino();
                
                destino.setPaisDestino(rs.getString("paisDestino"));
                destino.setCiudadDestino(rs.getString("ciudadDestino"));
                destino.setActivo(rs.getBoolean("activo"));
            }         
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar Destino ");
        }    
       return destino; 
        
    }
    
    public void guardarDestino(Destino d1){
        String sql="INSERT INTO destino (paisDestino, ciudadDestino, activo) VALUES (?,?,?)";
         try {
             PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setString(1,d1.getPaisDestino());
             ps.setString(2,d1.getCiudedDestino());
             ps.setBoolean(3,d1.isActivo());
             ps.executeUpdate();
             ResultSet rs= ps.getGeneratedKeys();
             if (rs.next()){
             d1.setIdDestino(rs.getInt(1));
            }
             ps.close();
         } catch (SQLException ex) {
             System.out.println("error al guardar Destino :"+ex);
             
         } 
    } 
    
    public void borrarDestino(int idDestino){
        String sql = "UPDATE destino SET activo = 0 WHERE destino.idDestino=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idDestino);
            
            ResultSet rs =ps.executeQuery();
            
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar logico destino . "+ex);
        } 
    }
    
    public void borrarDefinitivo(int idDestino){
      String sql="DELETE FROM destino WHERE idDestino = ?";

      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idDestino);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al borrar  destino .  "+ex);
        }
    }  
    
    public void activarDestino(int idDestino){
        String sql = "UPDATE destino SET activo=? WHERE idDestino=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1,true);
            ps.setInt(2, idDestino);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar destino . "+ex);
        } 
    }
    
    public void modificarDestino(Destino d1){
       String sql = "UPDATE destino SET paisDestino = ?, ciudadDestino = ?, activo = ? WHERE destino.idDestino =?"; 
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, d1.getPaisDestino());
            ps.setString(2, d1.getCiudedDestino());
            ps.setBoolean(3, d1.isActivo());
            ps.setInt(4, d1.getIdDestino());
            ps.executeUpdate();
            ps.close();
           
        } catch (SQLException ex) {
            System.out.println("Error al modificar destino "+ex);
        } 
    } 
}
