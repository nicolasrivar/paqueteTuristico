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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Transporte> obtenerTransportes(){ 
        List<Transporte> transportes=new ArrayList<>();
        
        Transporte transporte=null;
        
        String sql="SELECT * FROM `transporte` ";
        
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

}