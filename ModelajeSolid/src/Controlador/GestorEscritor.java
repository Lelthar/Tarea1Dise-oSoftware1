/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorEscritor {
    private ArrayList<String> listaTipos;
    
    public GestorEscritor() {
        listaTipos = new ArrayList<>();
        listaTipos.add("EscritorTXT");
        listaTipos.add("EscritorPDF");
        listaTipos.add("EscritorXML");
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
            paquete = iEscritor.class.getPackage().getName();
            instanciaEscritor = paquete+"."+getListaTipos().get(dtoAlgoritmos.getSalidasSeleccionadas().get(i));
            escritor = (iEscritor) Class.forName(instanciaEscritor).newInstance();
            escritor.Escribir(dtoAlgoritmos);
            
        }
       
    }
    
}
