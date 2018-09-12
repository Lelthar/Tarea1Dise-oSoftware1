/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Algoritmo;
import Modelo.CodigoTelefonico;
import Modelo.Transposicion;
import Modelo.Vigenere;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorAlgoritmos {
    private ArrayList<Algoritmo> algoritmos;

    public GestorAlgoritmos() {
        algoritmos = new ArrayList<>();
        cargarAlgoritmos();
    }

    public ArrayList<Algoritmo> getAlgoritmos() {
        return algoritmos;
    }

    public void setAlgoritmos(ArrayList<Algoritmo> algoritmos) {
        this.algoritmos = algoritmos;
    }
    
    public void cargarAlgoritmos() {
        Algoritmo vigenere = new Vigenere(0,"Vigenere");
        Algoritmo codigoTelefonico = new CodigoTelefonico(1,"CodigoTelefonico");
        Algoritmo transposicion = new Transposicion(2,"Transposición");
        this.algoritmos.add(vigenere);
        this.algoritmos.add(codigoTelefonico);
        this.algoritmos.add(transposicion);
        
    }
    
}
