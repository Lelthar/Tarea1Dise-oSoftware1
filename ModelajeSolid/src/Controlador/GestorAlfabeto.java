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
public class GestorAlfabeto implements iValidable {
    
    private ArrayList<Alfabeto> alfabetos; 

    public ArrayList<Alfabeto> getAlfabetos() {
        return alfabetos;
    }
    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
