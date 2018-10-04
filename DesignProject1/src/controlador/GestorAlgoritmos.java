/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import comunes.DTOAlgoritmos;
import java.io.File;
import modelo.Algoritmo;
import comunes.Resultado;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorAlgoritmos {
    private ArrayList<String> listaTipos;
    
    public GestorAlgoritmos() {
        listaTipos = getClassesPackage("modelo.algoritmos");
    }
    
    /**
     * Encargado de realizar una petición de codificación/decodificación
     * @param elDTO 
     * @param alfabeto 
     * @throws java.lang.ClassNotFoundException 
     * @throws java.lang.InstantiationException 
     * @throws java.lang.IllegalAccessException 
     */
    public void ejecutarAlgoritmo(DTOAlgoritmos elDTO,ArrayList<Character> alfabeto) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        ArrayList<Resultado> resultados = new ArrayList<>();
        
        Resultado resultado;
        Algoritmo algoritmo;
        String paquete;
        String instanciaAlgoritmo;
        
        for(int i=0;i<elDTO.getAlgoritmosSeleccionados().size();i++){
            
            resultado  = new Resultado();
            
            paquete = Algoritmo.class.getPackage().getName() + ".algoritmos";
            instanciaAlgoritmo = paquete+"."+getListaTipos().get(elDTO.getAlgoritmosSeleccionados().get(i));
            algoritmo = (Algoritmo) Class.forName(instanciaAlgoritmo).newInstance();
            resultado.setNombreAlgoritmo(getListaTipos().get(elDTO.getAlgoritmosSeleccionados().get(i)));
            
            if(elDTO.isModoAlgoritmo()){
                resultado.setTipoOperacion("Codificación");
                resultado.setResultadoAlgoritmo(algoritmo.Codificar(elDTO.getDatosEntrada(),alfabeto));
            }else{
                resultado.setTipoOperacion("Decodificación");
                resultado.setResultadoAlgoritmo(algoritmo.Decodificar(elDTO.getDatosEntrada(),alfabeto));
            }
            resultados.add(resultado);
            
        }
        elDTO.setResultadoAlgoritmo(resultados);
    }

    public ArrayList<String> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(ArrayList<String> listaTipos) {
        this.listaTipos = listaTipos;
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
