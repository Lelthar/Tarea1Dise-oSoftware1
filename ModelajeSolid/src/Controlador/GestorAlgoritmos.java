/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Algoritmo;
import Modelo.CodigoTelefonico;
import Modelo.EscritorPDF;
import Modelo.EscritorTXT;
import Modelo.EscritorXML;
import Modelo.Resultado;
import Modelo.Transposicion;
import Modelo.Vigenere;
import Modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorAlgoritmos {
    private ArrayList<String> listaTipos;
    
    public GestorAlgoritmos() {
        listaTipos = new ArrayList<>();
        listaTipos.add("Vigenere");
        listaTipos.add("CodigoTelefonico");
        listaTipos.add("Transposicion");
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
            
            paquete = Algoritmo.class.getPackage().getName();
            instanciaAlgoritmo = paquete+"."+listaTipos.get(elDTO.getAlgoritmosSeleccionados().get(i));
            algoritmo = (Algoritmo) Class.forName(instanciaAlgoritmo).newInstance();
           
            resultado.setNombreAlgoritmo(listaTipos.get(elDTO.getAlgoritmosSeleccionados().get(i)));
            
            if(elDTO.isModoAlgoritmo()){
                resultado.setTipoOperacion("Codificación");
                resultado.setResultadoAlgoritmo(algoritmo.Codificar(elDTO.getFraseOrigen(),alfabeto));
            }else{
                resultado.setTipoOperacion("Decodificación");
                resultado.setResultadoAlgoritmo(algoritmo.Decodificar(elDTO.getFraseOrigen(),alfabeto));
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
    
}
