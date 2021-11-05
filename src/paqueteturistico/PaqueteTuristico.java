/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteturistico;

import java.util.logging.Level;
import java.util.logging.Logger;
import paqueteturistico.control.ClienteData;
import paqueteturistico.control.DestinoData;
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
      Conexion conexion=null;
     DestinoData dd;
        try {
           conexion = new Conexion();
           dd= new DestinoData(conexion) ;
            System.out.println(dd.buscarDestino(1).getCiudedDestino());  
        } catch (ClassNotFoundException ex) {
            System.out.println("error en el tri"+ex );
        }
        
    }}
