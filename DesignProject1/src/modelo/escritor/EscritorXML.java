/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.escritor;

import comunes.DTOAlgoritmos;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.iEscritor;

/**
 *
 * @author gerald
 */
public class EscritorXML implements iEscritor {

    public EscritorXML() {
    }
    /*
    
    */
    @Override
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos){
        //Obtiene la fecha actual en el sistema
        Writer writer_xml;
        String encabezado = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
        String inicioXML = "<ResultadoTotal>\n";
        String finalXML = "</ResultadoTotal>";
        String fechaYHoraIn = "<FechaYHora>";
        String fechaYHoraFin = "</FechaYHora>";
        String fraseOriginalIn = "<FraseOriginal>";
        String fraseOriginalFin = "</FraseOriginal>";
        String nombreIn = "<NombreAlgoritmo>";
        String nombreFin = "</NombreAlgoritmo>";
        String tipoOperacionIn = "<Operación>";
        String tipoOperacionFin = "</Operación>";
        String resultadoOperacionIn = "<Resultado>";
        String resultadoOperacionFin = "</Resultado>";
        String ubicacion = "resultados/";
        
        try {
            //Inicializa el escritor con el path y nombre del archivo a la variable tipo writer
            writer_xml = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ubicacion+DtoAlgoritmos.getFechaHora().replace(':', '-')+".xml")));
            writer_xml.write(encabezado);
            writer_xml.write(inicioXML);
            
            for (int i = 0; i < DtoAlgoritmos.getResultadoAlgoritmo().size(); i++) {
                writer_xml.write(fechaYHoraIn+DtoAlgoritmos.getFechaHora()+fechaYHoraFin+"\n");
                writer_xml.write(fraseOriginalIn+DtoAlgoritmos.getDatosEntrada().get(0).toString()+fraseOriginalFin+"\n");
                writer_xml.write(nombreIn+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getNombreAlgoritmo()+nombreFin+"\n");
                writer_xml.write(tipoOperacionIn+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getTipoOperacion()+tipoOperacionFin+"\n");
                writer_xml.write(resultadoOperacionIn+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getResultadoAlgoritmo()+resultadoOperacionFin+"\n");
                writer_xml.write("\n");
            }
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
