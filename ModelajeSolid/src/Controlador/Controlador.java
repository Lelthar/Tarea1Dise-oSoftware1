/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class Controlador implements iValidable  {

    private Alfabeto alfabetoActual;
    
    public ArrayList<Alfabeto> cargarAlfabetos(){
        
        return null;
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
    
    
}
