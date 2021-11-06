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
import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteturistico.modelo.Conexion;
import paqueteturistico.modelo.Destino;
import paqueteturistico.modelo.Transporte;

/**
 *
 * @author Leonardo
 */
public class TransporteData {
    
     private Connection con;

    public TransporteData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    
}
    
    public List<Transporte> obtenerTransporte(){ 
        List<Transporte> transportes=new ArrayList<>();
        
        Transporte transporte=null;
        
        String sql="SELECT * FROM transporte ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                   
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                transporte = new Transporte();
                transporte.setIdTransporte(rs.getInt("idTransporte"));
                transporte.setPrecioViaje(rs.getFloat("precioViaje"));
                transporte.setTipoTransporte(rs.getString("tipoTransporte"));
                transporte.setActivo(rs.getBoolean("activo"));
                
                transportes.add(transporte);

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar transporte ");
        }    
       return transportes; 
        
    }
    
    public Transporte obtenerTransporte(int idTransporte ){
        Transporte t1 = new Transporte();
        String sql="SELECT idDestino, tipoTransporte, precioViaje, activo FROM transporte WHERE idTransporte=?";
         try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setInt(1, idTransporte);
              ResultSet rs =ps.executeQuery();
              if (rs.next()){
                  
                  t1.setIdTransporte(idTransporte);
                  t1.setIdDestino(rs.getInt("idDestino"));
                  t1.setTipoTransporte(rs.getString("tipoTransporte"));
                  t1.setPrecioViaje(rs.getFloat("precioViaje"));
                  t1.setActivo(rs.getBoolean("activo"));
              }
         } catch (SQLException ex) {
             System.out.println("error al oberner "+ex);
         }
         return t1;
    }

    public List<Transporte> obtenerTransportesDestino(int idDestino){
        List<Transporte> transportes=new ArrayList<>();
        
        Transporte transporte=null;
        
        String sql="SELECT transporte.idTransporte, transporte.tipoTransporte, transporte.precioViaje, transporte.activo FROM transporte, destino WHERE transporte.idDestino=destino.idDestino and destino.idDestino=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idDestino);
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                transporte = new Transporte();
                transporte.setIdTransporte(rs.getInt("transporte.idTransporte"));
                transporte.setIdDestino(idDestino);
                transporte.setTipoTransporte(rs.getString("transporte.tipoTransporte"));
                transporte.setPrecioViaje(rs.getFloat("transporte.precioViaje"));
                transporte.setActivo(rs.getBoolean("transporte.activo"));
                transportes.add(transporte);

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar transporte por destino "+ex);
        }    
       return transportes; 
        
    }
    
    public void guardarTransporte(Transporte transporte){
        String sql="INSERT INTO transporte (idDestino, tipoTransporte, precioViaje , activo) VALUES (?,?,?,?)";
         try {
             PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1,transporte.getIdDestino());
             ps.setString(2, transporte.getTipoTransporte());
             ps.setFloat(3, transporte.getPrecioViaje());
             ps.setBoolean(4,transporte.isActivo());
             ps.executeUpdate();
             ResultSet rs= ps.getGeneratedKeys();
             if (rs.next()){
             transporte.setIdTransporte(rs.getInt(1));
            }
             ps.close();
         } catch (SQLException ex) {
             System.out.println("error al guardar Transporte :"+ex);
             
         }
    }
    
    public void borrarTranspote(int idTransporte){
        String sql = "UPDATE transporte SET activo = 0 WHERE transporte.idTransporte=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idTransporte);
            
            ResultSet rs =ps.executeQuery();
            
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar transporte . "+ex);
        } 
    }
    
    public void activarTransporte(int idTransporte){
       String sql = "UPDATE transporte SET activo=? WHERE idTransporte=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1,true);
            ps.setInt(2, idTransporte);
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al desactivar "+ex);
        } 
    }
    
    public void ModificarTransporte(Transporte t1){
        String sql = "UPDATE transporte SET idDestino=?, tipoTransporte=?, precioViaje=?, activo=? WHERE idTransporte=?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t1.getIdDestino());
            ps.setString(2, t1.getTipoTransporte());
            ps.setFloat(3, t1.getPrecioViaje());
            ps.setBoolean(4, t1.isActivo());
            ps.setInt(5, t1.getIdTransporte());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar "+ex);
        }
         
    }
    
    public void borrarDefinitivo(int idTransporte){
       String sql="DELETE FROM transporte WHERE idTransporte = ?";

      PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTransporte);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
             System.out.println("Error al borrar  transporte .  "+ex);
        }
    }
}
