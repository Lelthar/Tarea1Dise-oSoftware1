/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author josed
 */
public class Alfabeto {
    
    private int id ; 
    private String nombre;
    private String simbolos;
    
    public Alfabeto(int id, String nombre, String simbolos){
        
        this.id = id;
        this.nombre = nombre; 
        this.simbolos = simbolos;
    }
    
    public boolean Validar(String s){
        return true;
    }
    
}
