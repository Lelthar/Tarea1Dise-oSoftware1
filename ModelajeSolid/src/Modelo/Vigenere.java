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
public class Vigenere extends Algoritmo{
    
    private String nombreAlgoritmo;
    
    public Vigenere(int id,String nombreAlgoritmo){
        super(id,nombreAlgoritmo);
    }

    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }
    
    
    @Override
    public String Codificar(String mensaje){
        
        return "Debe ser programado por José Codificar";
    }
    
    
    @Override
    public String Decodificar(String mensaje){
        
        return "Debe ser programado por José Decodificar";
    }
    
}
