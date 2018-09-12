/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Algoritmo;
import Modelo.CodigoTelefonico;
import Modelo.EscritorPDF;
import Modelo.EscritorTXT;
import Modelo.EscritorXML;
import Modelo.Transposicion;
import Modelo.Vigenere;
import Modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class GestorAlgoritmos {
    private ArrayList<Algoritmo> algoritmos;
    private ArrayList<iEscritor> modoEscritura;
    
    public GestorAlgoritmos() {
        algoritmos = new ArrayList<>();
        modoEscritura = new ArrayList<>();
        cargarAlgoritmos();
        cargarModoEscritura();
    }

    public ArrayList<Algoritmo> getAlgoritmos() {
        return algoritmos;
    }

    public void setAlgoritmos(ArrayList<Algoritmo> algoritmos) {
        this.algoritmos = algoritmos;
    }

    public ArrayList<iEscritor> getModoEscritura() {
        return modoEscritura;
    }

    public void setModoEscritura(ArrayList<iEscritor> modoEscritura) {
        this.modoEscritura = modoEscritura;
    }
    
    public void cargarAlgoritmos() {
        Algoritmo vigenere = new Vigenere(0,"Vigenere");
        Algoritmo codigoTelefonico = new CodigoTelefonico(1,"CodigoTelefonico");
        Algoritmo transposicion = new Transposicion(2,"Transposición");
        this.algoritmos.add(vigenere);
        this.algoritmos.add(codigoTelefonico);
        this.algoritmos.add(transposicion);      
    }
    
    public void cargarModoEscritura(){
        iEscritor escrituraPDF = new EscritorPDF();
        iEscritor escrituraTXT = new EscritorTXT();
        iEscritor escrituraXML = new EscritorXML();
        this.modoEscritura.add(escrituraTXT);
        this.modoEscritura.add(escrituraPDF);
        this.modoEscritura.add(escrituraXML);
    }
    
}
