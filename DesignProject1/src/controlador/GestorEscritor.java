/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import comunes.DTOAlgoritmos;
import java.io.File;
import modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorEscritor {
    private ArrayList<String> listaTipos;
    
    public GestorEscritor() {
        listaTipos = getClassesPackage("modelo.escritor");
    }

    public ArrayList<String> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(ArrayList<String> listaTipos) {
        this.listaTipos = listaTipos;
    }
    
    public void escribirSalida(DTOAlgoritmos dtoAlgoritmos) throws InstantiationException, ClassNotFoundException, IllegalAccessException{
        String paquete;
        String instanciaEscritor;
        iEscritor escritor;
        
        for(int i=0; i < dtoAlgoritmos.getSalidasSeleccionadas().size(); i++){
            paquete = iEscritor.class.getPackage().getName()+".escritor";
            instanciaEscritor = paquete+"."+getListaTipos().get(dtoAlgoritmos.getSalidasSeleccionadas().get(i));
            escritor = (iEscritor) Class.forName(instanciaEscritor).newInstance();
            escritor.Escribir(dtoAlgoritmos);
            
        }
       
    }
    
    public ArrayList<String> getClassesPackage(String pckgname) {
        try{
            ArrayList<String> classes = new ArrayList<>(); 

            File directory=null; 
            try { 
              directory=new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile()); 
            } catch(NullPointerException x) { 
              System.out.println("Nullpointer");
              throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
            } 
            if(directory.exists()) { 

              String[] files=directory.list(); 

              for(int i=0; i<files.length; i++) { 

                if(files[i].endsWith(".class")) { 
                    
                    classes.add(files[i].substring(0,files[i].indexOf('.')));
                } 
              } 
            } else { 
                System.out.println("Directory does not exist");
                throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
            } 
            return classes;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
