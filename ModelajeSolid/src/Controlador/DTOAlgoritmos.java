/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Resultado;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class DTOAlgoritmos {
    private int numeroAlfabeto;
    private String fraseOrigen;
    private ArrayList<Integer> algoritmosSeleccionados;
    private ArrayList<Integer> salidasSeleccionadas;
    private ArrayList<Resultado> resultadoAlgoritmos;
    private boolean modoAlgoritmo;
    private String fechaHora;

    public DTOAlgoritmos() {
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNumeroAlfabeto() {
        return numeroAlfabeto;
    }

    public void setNumeroAlfabeto(int numeroAlfabeto) {
        this.numeroAlfabeto = numeroAlfabeto;
    }

    public String getFraseOrigen() {
        return fraseOrigen;
    }

    public void setFraseOrigen(String fraseOrigen) {
        this.fraseOrigen = fraseOrigen;
    }

    public ArrayList<Integer> getAlgoritmosSeleccionados() {
        return algoritmosSeleccionados;
    }

    public void setAlgoritmosSeleccionados(ArrayList<Integer> algoritmosSeleccionados) {
        this.algoritmosSeleccionados = algoritmosSeleccionados;
    }

    public ArrayList<Integer> getSalidasSeleccionadas() {
        return salidasSeleccionadas;
    }

    public void setSalidasSeleccionadas(ArrayList<Integer> salidasSeleccionadas) {
        this.salidasSeleccionadas = salidasSeleccionadas;
    }

    public ArrayList<Resultado> getResultadoAlgoritmo() {
        return resultadoAlgoritmos;
    }

    public void setResultadoAlgoritmo(ArrayList<Resultado> resultadoAlgoritmo) {
        this.resultadoAlgoritmos = resultadoAlgoritmo;
    }

    public boolean isModoAlgoritmo() {
        return modoAlgoritmo;
    }

    public void setModoAlgoritmo(boolean modoAlgoritmo) {
        this.modoAlgoritmo = modoAlgoritmo;
    }
    
}
