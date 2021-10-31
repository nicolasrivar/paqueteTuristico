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
import paqueteturistico.modelo.Paquete;

/**
 *
 * @author Leonardo
 */
public class PaqueteData {
    private Connection con;

    public PaqueteData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    
}

 public List<Paquete> buscarPaquete(){
        List<Paquete> paquetes=new ArrayList<>();
        
        Paquete paquete=null;
        
        String sql="SELECT * FROM paquete";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
               paquete = new Paquete();
                
                paquete.setIdPaquete(rs.getInt("idPaquete"));
                paquete.setIdAlojamiento(rs.getInt("idAlojamiento"));
                paquete.setIdMenu(rs.getInt("idMenu"));
                paquete.setIdTransporte(rs.getInt("idTransporte"));
                paquete.setIdCliente(rs.getInt("idCliente"));
                paquete.setFechaInicial(rs.getDate("fechaInicial").toLocalDate());
                paquete.setFechaFinal(rs.getDate("fechaFinal").toLocalDate());
                paquete.setCantPersonas(rs.getInt("cantidadPersonas"));
                paquete.setMontoFinal(rs.getFloat("montoFinal"));
                paquete.setActivo(rs.getBoolean("activo"));
                
                paquetes.add(paquete);
                

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar Paquetes ");
        }    
       return paquetes; 
        
    }

}