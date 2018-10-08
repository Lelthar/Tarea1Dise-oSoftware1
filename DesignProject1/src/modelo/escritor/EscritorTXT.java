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
public class EscritorTXT  implements iEscritor {

    public EscritorTXT() {
    }
    
    @Override
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos){
        //Obtiene la fecha actual en el sistema
        Writer writer_txt;
        String fechaYHora = "Fecha y Hora: ";
        String fraseOriginal = "Frase original: ";
        String nombre = "Nombre algoritmo: ";
        String tipoOperacion = "Operación: ";
        String resultadoOperacion = "Resultado: ";
        String ubicacion = "resultados/";
        
        try {
            //Inicializa el escritor con el path y nombre del archivo a la variable tipo writer
            writer_txt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ubicacion+DtoAlgoritmos.getFechaHora().replace(':', '-')+".txt")));
        
            for (int i = 0; i < DtoAlgoritmos.getResultadoAlgoritmo().size(); i++) {
                writer_txt.write(fechaYHora+DtoAlgoritmos.getFechaHora()+"\n");
                writer_txt.write(fraseOriginal+DtoAlgoritmos.getDatosEntrada().get(0).toString()+"\n");
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
