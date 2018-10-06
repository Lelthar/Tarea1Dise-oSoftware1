/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import comunes.DTOAlgoritmos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import modelo.Alfabeto;
import java.util.ArrayList;
import java.util.stream.Collectors;
import modelo.Algoritmo;

/**
 *
 * @author gerald
 */
public class GestorAlfabeto implements iValidable {
    
    private ArrayList<Alfabeto> alfabetos;
    private ArrayList<String> listaAlfabetos;

    public GestorAlfabeto() {
        
        this.actualizarAlfabetos();
    
    }   
    
    public ArrayList<Alfabeto> getAlfabetos() {
        return alfabetos;
    }
    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void cargarDefault(){
        //ArrayList<Character> simbolos = new ArrayList<>();
        String defaultSimbolos = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<Character> simbolos = new ArrayList<>(
                                            defaultSimbolos.chars()
                                            .mapToObj(e -> (char) e)
                                            .collect(
                                                    Collectors.toList()
                                            )
                                            );
        
        Alfabeto alfabeto = new Alfabeto(0,"Default", simbolos);
        alfabetos.add(alfabeto);
        listaAlfabetos.add("Default");
    }
    
    
    
    public ArrayList<Character> ObtenerAlfabetoDeArchivo(File file) throws FileNotFoundException, IOException{
        
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        
        ArrayList<Character> alfabeto;
        String line =  br.readLine();
        
        if (line != null) {
            alfabeto = new ArrayList<>(
                                       line.chars()
                                       .mapToObj(e -> (char) e)
                                        .collect(
                                            Collectors.toList()
                                        )
                                        );
            
        } else {
            alfabeto = new ArrayList<>();
        }
        
        return alfabeto;

    }
    
    public void actualizarAlfabetos(){
        
        alfabetos = new ArrayList<>();
        listaAlfabetos = new ArrayList<>();
        
        this.cargarDefault();
        this.cargarAlfabetos("Alfabetos");
    }
        
    
    public void cargarAlfabetos(String pckgname){ // Carga todos los alfabetos encontrados en la carpeta Alfabetos
          
        try{
            ArrayList<String> archivosAlfabeto = new ArrayList<>(); 

            File directory=null; 
            try { 
                directory = new File(Thread.currentThread().getContextClassLoader().getResource(pckgname.replace('.', '/')).getFile());
              
            } 
            catch(NullPointerException x) {
                
                System.out.println("Nullpointer");
                throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
            } 
            
            if(directory.exists()) { 

                String[] files = directory.list(); 
                File fileAlfabeto;
                String pathFileAlfabeto ;
                String pathCarpetaAlfabeto = "src/Alfabetos/" ;
                ArrayList<String> listaPathsArchivos = new ArrayList<String>();

                for(int i=0; i<files.length; i++) { 

                    if(files[i].endsWith(".txt")) {
                        pathFileAlfabeto = pathCarpetaAlfabeto + files[i];
                        archivosAlfabeto.add(files[i].substring(0,files[i].indexOf('.')));
                        listaPathsArchivos.add(pathFileAlfabeto);
                    }
                }

                ArrayList<Character> simbolosAlfabeto;
                String nombreAlfabeto;

                for(int i = 0 ; i < listaPathsArchivos.size() ; i++){

                    fileAlfabeto = new File(listaPathsArchivos.get(i));
                    simbolosAlfabeto = this.ObtenerAlfabetoDeArchivo(fileAlfabeto);
                    nombreAlfabeto = archivosAlfabeto.get(i);
                    Alfabeto alfabeto = new Alfabeto(i,nombreAlfabeto, simbolosAlfabeto);
                    alfabetos.add(alfabeto);
                    listaAlfabetos.add(nombreAlfabeto);
                  
              }
              
              
            } else {      
                System.out.println("Directory does not exist");
                throw new ClassNotFoundException(pckgname+" does not appear to be a valid package"); 
            }
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getListaAlfabetos() {
        return listaAlfabetos;
    }

    public void setListaAlfabetos(ArrayList<String> listaAlfabetos) {
        this.listaAlfabetos = listaAlfabetos;
    }
        
        
}

