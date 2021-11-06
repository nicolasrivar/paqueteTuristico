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
import paqueteturistico.modelo.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Leonardo
 */
public class ClienteData {
    private Connection con;

    public ClienteData(Conexion conexion) {
  
        try {
            con = conexion.getConexion();
            
        } catch (SQLException ex) {
            System.out.println("Error en la conexion ");
        }
    
    }
    

    public void guardarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (nombreCompleto, email, dni, telefono, activo) VALUES (?,?,?,?,?)";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombreCompleto());
            ps.setString(2, cliente.getEmail());
            ps.setDouble(3, cliente.getDni());
            ps.setLong(4, cliente.getTelefono());
            ps.setBoolean(5, cliente.isActivo());
            
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys(); 
            
            if (rs.next()){
                cliente.setIdCliente(rs.getInt(1));
            
            }
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al insertar cliente"+ex);
        }
        
    
    }
    
    public void actualizarCliente(Cliente cliente){
        String sql = "UPDATE cliente SET nombreCompleto=?, email=?, dni=? ,telefono=?, activo=? WHERE idCliente=?";
        
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombreCompleto());
            ps.setString(2, cliente.getEmail());
            ps.setDouble(3, cliente.getDni());
            ps.setLong(4, cliente.getTelefono());
            ps.setBoolean(5, cliente.isActivo());
            ps.setInt(6,cliente.getIdCliente() );
            
            ps.executeUpdate();
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al modificar Cliente "+ex);
        }
        
    
    }
    
    public List<Cliente> buscarClientes(){
    List<Cliente> clientes= new ArrayList<>();
        
    Cliente cliente=null;
    
    String sql="SELECT * FROM cliente";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                cliente = new Cliente();
               
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDni(rs.getLong("dni"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setActivo(rs.getBoolean("activo"));
                clientes.add(cliente);
                
            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar lista clientes ");
        }    
       return clientes;    
       
    }
    
    public Cliente obtenerCliente(int id){ // se busca a Cliente por id
    Cliente cliente=null;
    
    String sql="SELECT * FROM cliente WHERE idCliente=?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNombreCompleto(rs.getString("nombreCompleto"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDni(rs.getDouble("dni"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setActivo(rs.getBoolean("activo"));
                
            }
            
           
        } catch (SQLException ex) {
            System.out.println("Error al buscar cliente");
        }    
       return cliente;    
       
    }
    
    public void borrarCliente(int id){
        String sql = "UPDATE cliente SET activo = 0 WHERE cliente.idCliente=?";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
       
    
        } catch (SQLException ex) {
            System.out.println("Error al eliminar "+ ex);
        } 
    }
    
    
    
    
   

}
