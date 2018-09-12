/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelajesolid;

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
public class ModelajeSolid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH:mm:ss");  
        Date date = new Date();  
        System.out.println(formatter.format(date));
        
        Document document = new Document();
        try
        {
           PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(formatter.format(date)+".pdf"));
           document.open();
           document.add(new Paragraph("Hello word"));
           document.close();
           writer.close();
        } catch (DocumentException e)
        {
           e.printStackTrace();
        } catch (FileNotFoundException e)
        {
           e.printStackTrace();
        }
    }
    
}
