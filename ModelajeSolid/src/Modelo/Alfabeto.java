/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DTOAlgoritmos;
import Controlador.iValidable;
import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class Alfabeto implements iValidable {
    
    private int id ; 
    private String nombre;
    private ArrayList<Character> simbolos;
    
    public Alfabeto(int id, String nombre, ArrayList<Character> simbolos){
        
        this.id = id;
        this.nombre = nombre; 
        this.simbolos = simbolos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Character> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(ArrayList<Character> simbolos) {
        this.simbolos = simbolos;
    }
    
    
    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
