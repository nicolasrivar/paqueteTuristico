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
import paqueteturistico.control.TransporteData;
import paqueteturistico.modelo.Cliente;
import paqueteturistico.modelo.Conexion;
import paqueteturistico.modelo.Destino;
import paqueteturistico.modelo.Transporte;


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
      Transporte t1=new Transporte(1,50000," tren ",true);
     DestinoData dd;
     TransporteData td; 
        try {
           conexion = new Conexion();
           dd= new DestinoData(conexion) ;
           td = new TransporteData(conexion); 
            System.out.println(dd.buscarDestino(1).getCiudedDestino());  
            System.out.println(dd.obtenerDestinos());
            System.out.println(td.obtenerTransporte(1).getTipoTransporte());
            System.out.println(td.obtenerTransportes());
            System.out.println(td.obtenerTransportesDestino(1));
            td.guardarTransporte(t1);
            System.out.println(td.obtenerTransportesDestino(1));
        } catch (ClassNotFoundException ex) {
            System.out.println("error en el tri"+ex );
        }
        
    }}
