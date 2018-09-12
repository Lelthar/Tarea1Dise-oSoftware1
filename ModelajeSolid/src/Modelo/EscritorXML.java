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
public class EscritorXML implements iEscritor {
    
    @Override
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos){
        //Obtiene la fecha actual en el sistema
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");  
        Date date = new Date();  
        Writer writer_xml;
        String encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        String inicioXML = "<Resultado>\n";
        String finalXML = "</Resultado>";
        try {
            //Inicializa el escritor con el path y nombre del archivo a la variable tipo writer
            writer_xml = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(formatter.format(date)+".xml")));
            writer_xml.write(encabezado);
            writer_xml.write(inicioXML);
            writer_xml.write(".getResultadoAlgoritmo()\n");
            writer_xml.write(finalXML);
            writer_xml.close();
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
