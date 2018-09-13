/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author gerald
 */
public class GestorAlfabeto implements iValidable {
    
    private ArrayList<Alfabeto> alfabetos; 

    public GestorAlfabeto(ArrayList<Alfabeto> alfabetos) {
        this.alfabetos = alfabetos;
        cargarDefault();
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
        ArrayList<Character> simbolos
        = new ArrayList<>(
                 defaultSimbolos.chars()
                .mapToObj(e -> (char) e)
                .collect(
                        Collectors.toList()
                )
        );
        
        Alfabeto alfabeto = new Alfabeto(0,"Default", simbolos);
        alfabetos.add(alfabeto);
    }
}
