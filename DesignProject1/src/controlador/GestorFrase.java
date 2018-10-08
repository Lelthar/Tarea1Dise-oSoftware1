/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.frases.GeneradorFrase;
import controlador.frases.FraseBuilder;
import java.io.File;
import java.util.ArrayList;
import modelo.Frase;

/**
 *
 * @author gerald
 */
public class GestorFrase {
    private ArrayList<String> listaTipos;
    private GeneradorFrase generadorFrase;

    public GestorFrase() {
        listaTipos = getClassesPackage("controlador.frases.frases_builder");
        generadorFrase = new GeneradorFrase();
    }
    
    public String generarFrase(int largo, int tipoNumero,ArrayList<Character> alfabeto) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       
        String tipoFrase = this.listaTipos.get(tipoNumero);
        String paquete = FraseBuilder.class.getPackage().getName()+".frases_builder";
        String instanciaFraseBuilder = paquete+"."+tipoFrase;
        FraseBuilder fraseBuilder = (FraseBuilder) Class.forName(instanciaFraseBuilder).newInstance();
        
        generadorFrase.setFraseBuilder(fraseBuilder);
        generadorFrase.construirFrase(largo,alfabeto);
        
        Frase frase = generadorFrase.getFrase();
        
        return frase.getTexto();
        
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
