/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josed
 */
public class EscritorTXT  implements iEscritor {
    
    @Override
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos){
        //Obtiene la fecha actual en el sistema
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");  
        Date date = new Date();  
        Writer writer_txt;
        String nombre = "Nombre algoritmo: ";
        String tipoOperacion = "Operación: ";
        String resultadoOperacion = "Resultado: ";
        
        try {
            //Inicializa el escritor con el path y nombre del archivo a la variable tipo writer
            writer_txt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(formatter.format(date)+".txt")));
        
            for (int i = 0; i < DtoAlgoritmos.getResultadoAlgoritmo().size(); i++) {
               writer_txt.write(nombre+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getNombreAlgoritmo()+"\n");
               writer_txt.write(tipoOperacion+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getTipoOperacion()+"\n");
               writer_txt.write(resultadoOperacion+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getResultadoAlgoritmo()+"\n");
               writer_txt.write("\n");
            }
            writer_txt.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EscritorTXT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(EscritorTXT.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
}
