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
import paqueteturistico.modelo.Alojamiento;
import paqueteturistico.modelo.Conexion;

/**
 *
 * @author Leonardo
 */
public class AlojamientoData {
   
    private Connection con;

    public AlojamientoData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    }
    
    public List<Alojamiento> buscarAlojamiento(int idAlojamiento){//buscar Alojamientos por Id
        List<Alojamiento> alojamientos=new ArrayList<>();
        
        Alojamiento alojamiento=null;
        
        String sql="SELECT * FROM alojamiento WHERE idAlojamiento=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlojamiento);
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                alojamiento = new Alojamiento();
                
                alojamiento.setIdAlojamiento(rs.getInt("idAlojamiento"));
                alojamiento.setIdDestino(rs.getInt("idDestino"));
                alojamiento.setUbicacion(rs.getString("ubicacion"));
                alojamiento.setNombreAlojamiento(rs.getString("nombreAlojamiento"));
                alojamiento.setTipoAlojamiento(rs.getString("tipoAlojamiento"));
                alojamiento.setPrecioNoche(rs.getFloat("precioNoche"));
                alojamiento.setActivo(rs.getBoolean("activo"));
                
                alojamientos.add(alojamiento);

            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar Alojamientos ");
        }    
       return alojamientos; 
        
    }
    
    public Alojamiento obtenerAlojamiento(int id){
        Alojamiento aloj=null;
    
    String sql="SELECT * FROM alojamiento WHERE idAlojamiento = ?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                aloj = new Alojamiento();
                aloj.setIdAlojamiento(rs.getInt("idAlojamiento"));
                aloj.setIdDestino(rs.getInt(2));
                aloj.setUbicacion(rs.getString(3));
                aloj.setNombreAlojamiento(rs.getString(4));
                aloj.setTipoAlojamiento(rs.getString(5));
                aloj.setPrecioNoche(rs.getFloat(6));
                aloj.setActivo(rs.getBoolean(7));
            }
            
            
            
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar el alojamiento" + ex);
        }    
       return aloj;  
   }
    
}
