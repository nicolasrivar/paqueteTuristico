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

    
    public List<Destino> buscarDestino(int idDestino){ //buscar Pais destino por Id
        List<Destino> destinos=new ArrayList<>();
        
        Destino destino=null;
        
        String sql="SELECT * FROM `destino` WHERE  idDestino=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idDestino);        
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                destino = new Destino();
                
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
    
    
}
