/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import Modelo.Algoritmo;
import Modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class Controlador implements iValidable  {

    private Alfabeto alfabetoActual;
    
    //Por asociaciones
    private GestorAlfabeto gestorAlfabeto;
    private iEscritor elEscritor;
    private  GestorAlgoritmos gestorAlgoritmos;

    public Controlador() {
        gestorAlgoritmos = new GestorAlgoritmos();
    }
    
    public boolean cargarAlfabetos(String alfabeto){

        return false;
    }
    
    public void procesarPeticion(DTOAlgoritmos leDTO){
        
    }
    
    public void predefinirAlfabeto(DTOAlgoritmos elDTO){
        
    }
    
    public void activarAlgoritmos(DTOAlgoritmos elDTO){
        
    }
    
    public void escribir(DTOAlgoritmos elDTO){
        
    }    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Alfabeto getAlfabetoActual() {
        return alfabetoActual;
    }

    public void setAlfabetoActual(Alfabeto alfabetoActual) {
        this.alfabetoActual = alfabetoActual;
    }
    
    public GestorAlfabeto getGestorAlfabeto() {
        return gestorAlfabeto;
    }

    public void setGestorAlfabeto(GestorAlfabeto gestorAlfabeto) {
        this.gestorAlfabeto = gestorAlfabeto;
    }

    public GestorAlgoritmos getAlgoritmos() {
        return gestorAlgoritmos;
    }

    public void setAlgoritmos(GestorAlgoritmos elAlgoritmo) {
        this.gestorAlgoritmos = elAlgoritmo;
    }
    
    
    
}
