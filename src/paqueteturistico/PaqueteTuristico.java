/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico;

import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteturistico.control.ClienteData;
import paqueteturistico.modelo.Cliente;
import paqueteturistico.modelo.Conexion;
import paqueteturistico.modelo.Destino;


/**
 *
 * @author Nicolas
 */
public class PaqueteTuristico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conexion ;
        
          try {
            conexion = new Conexion();
            ClienteData cd=new ClienteData(conexion);
        
            Cliente c1=new Cliente("Castro Jorge", "castroJ@gmail.com",25032406,265723143,true);
            Cliente c2=new Cliente("Prueba Aldo", "aldop@gmail.com",30254141,014467741,true);
            Cliente c3=new Cliente("Petra Carla", "pcarla@gmail.com",164254126,265741312,true);
            Cliente c4=new Cliente("Zenco Roberto", "zerobert@gmail.com",18365449,266235499,true);
       
            Destino d1=new Destino("Argentina","Rio Gallegos");
            Destino d2=new Destino("Chile","Santiago");
            Destino d3=new Destino("Argentina","Formosa");
            Destino d4=new Destino("Mexico","Tulum");
        
 System.out.println(cd.buscarDestino(1));
//              System.out.println(cd.buscarAlojamiento(3));
//              System.out.println(cd.buscarPaquete());
//              cd.guardarCliente(c2);
//              cd.guardarCliente(c1);
//              cd.guardarCliente(c3);
//              cd.guardarCliente(c4);
              
               
             // c1.setDni(25032404);
//              c1.setNombreCompleto("Castro Jorge Luis");
                c1.setTelefono(265722111);
                cd.actualizarCliente(c1);
//              cd.actualizarCliente(c1);
//              System.out.println(c1);
                cd.borrarCliente(2);
               //System.out.println(cd.obtenerClientes());
              //System.out.println(cd.buscarCliente(2));
              
             
        
    } catch (ClassNotFoundException ex) {
            Logger.getLogger(PaqueteTuristico.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}
