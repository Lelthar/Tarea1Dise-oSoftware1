/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Conexion.Conexion;
import comunes.OBJComunicacion;
import comunes.TipoAccion;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rigo-PC
 */
public class UIgui {
    
    public ArrayList<String> obtenerAlgoritmos() {
        try {
            OBJComunicacion Objeto=new OBJComunicacion(null, TipoAccion.OBTENER_ALGORITMOS);
            Conexion c=new Conexion();
            
            Objeto=c.conecteServidor(Objeto);
            return (ArrayList<String>)Objeto.getDatoSalida();
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(UIgui.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
