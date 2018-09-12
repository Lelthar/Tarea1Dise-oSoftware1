/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author josed
 */
public class EscritorPDF implements iEscritor {
    
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos){
        //Obtiene la fecha actual en el sistema
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");  
        Date date = new Date();
        String nombre = "Nombre algoritmo: ";
        String tipoOperacion = "Operación: ";
        String resultadoOperacion = "Resultado: ";
        
        Document document = new Document();
        try
        {
           //Crea la variable del tipo pdf y le pasa el nombre que tendrá el pdf, el cual será la hora y fecha del sistema.
           PdfWriter writer_pdf = PdfWriter.getInstance(document, new FileOutputStream(formatter.format(date)+".pdf"));
           document.open();
           for (int i = 0; i < DtoAlgoritmos.getResultadoAlgoritmo().size(); i++) {
               document.add(new Paragraph(nombre+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getNombreAlgoritmo()+"\n"));
               document.add(new Paragraph(tipoOperacion+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getTipoOperacion()+"\n"));
               document.add(new Paragraph(resultadoOperacion+DtoAlgoritmos.getResultadoAlgoritmo().get(i).getResultadoAlgoritmo()+"\n"));
               document.add(new Paragraph("\n"));
           }
            //Agrega el texto al parrafo del documento pdf
           document.close();
           writer_pdf.close();
           return true;
        } catch (DocumentException e)
        {
           return false;
        } catch (FileNotFoundException e)
        {
           return false;
        }
    }

    
}
