/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import Controlador.iValidable;

/**
 *
 * @author josed
 */
public class Alfabeto implements iValidable {
    
    private int id ; 
    private String nombre;
    private String simbolos;
    
    public Alfabeto(int id, String nombre, String simbolos){
        
        this.id = id;
        this.nombre = nombre; 
        this.simbolos = simbolos;
    }

    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
