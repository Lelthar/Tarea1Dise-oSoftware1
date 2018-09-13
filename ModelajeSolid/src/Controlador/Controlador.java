/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Alfabeto;
import Modelo.Algoritmo;
import Modelo.Resultado;
import Modelo.iEscritor;
import java.util.ArrayList;

/**
 *
 * @author gerald
 */
public class Controlador implements iValidable  {

    private Alfabeto alfabetoActual;
    
    //Por asociaciones
    private GestorAlfabeto gestorAlfabeto;
    private GestorAlgoritmos gestorAlgoritmos;
    private iEscritor elEscritor;

    public Controlador() {
        gestorAlgoritmos = new GestorAlgoritmos();
        gestorAlfabeto = new GestorAlfabeto(new ArrayList<>());
    }
    
    /**
     * Metodo que debe cargar los alfabetos de un archivo
     * @param alfabeto
     * @return 
     */
    public boolean cargarAlfabetos(String alfabeto){
        
        return false;
    }
    
    /**
     * Encargado de realizar una petición de codificación/decodificación
     * @param elDTO 
     */
    public void procesarPeticion(DTOAlgoritmos elDTO){
        ArrayList<Resultado> resultados = new ArrayList<>();
        for(int i=0;i<elDTO.getAlgoritmosSeleccionados().size();i++){
            Resultado resultado = new Resultado();
             Algoritmo algoritmo;
            switch(i){
                case 0:
                    algoritmo = gestorAlgoritmos.getAlgoritmos().get(0);
                    resultado.setNombreAlgoritmo("Vigenere");
                    if(elDTO.isModoAlgoritmo()){
                        resultado.setTipoOperacion("Codificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Codificar(elDTO.getFraseOrigen()));
                    }else{
                        resultado.setTipoOperacion("Decodificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Decodificar(elDTO.getFraseOrigen()));
                    }
                    resultados.add(resultado);
                    break;
                case 1:
                    algoritmo= gestorAlgoritmos.getAlgoritmos().get(1);
                    resultado.setNombreAlgoritmo("CodigoTelefonico");
                    if(elDTO.isModoAlgoritmo()){
                        resultado.setTipoOperacion("Codificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Codificar(elDTO.getFraseOrigen()));
                    }else{
                        resultado.setTipoOperacion("Decodificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Decodificar(elDTO.getFraseOrigen()));
                    }
                    resultados.add(resultado);
                    break;
                case 2:
                    algoritmo = gestorAlgoritmos.getAlgoritmos().get(2);
                    resultado.setNombreAlgoritmo("Transposicion");
                    if(elDTO.isModoAlgoritmo()){
                        resultado.setTipoOperacion("Codificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Codificar(elDTO.getFraseOrigen()));
                    }else{
                        resultado.setTipoOperacion("Decodificación");
                        resultado.setResultadoAlgoritmo(algoritmo.Decodificar(elDTO.getFraseOrigen()));
                    }
                    resultados.add(resultado);
                    break;
                default:
                    break;
            }
        }
        elDTO.setResultadoAlgoritmo(resultados);
    }
    
    /**
     * Guarda el alfabeto que debe de utilizar
     * @param elDTO 
     */
    public void predefinirAlfabeto(DTOAlgoritmos elDTO){
        alfabetoActual = gestorAlfabeto.getAlfabetos().get(elDTO.getNumeroAlfabeto());
        //System.out.println("Alfabeto Controlador: "+alfabetoActual.getNombre());
    }
    
    /**
     * No tengo claro la función a realizar
     * @param elDTO 
     */
    public void activarAlgoritmos(DTOAlgoritmos elDTO){
        
    }
    
    /**
     * metodo encargado de imprimir en el formato seleccionado.
     * @param elDTO 
     */
    public void escribir(DTOAlgoritmos elDTO){
        for(int i=0;i<elDTO.getSalidasSeleccionadas().size();i++){
            iEscritor escritor;
            switch(elDTO.getSalidasSeleccionadas().get(i)){
                case 0:
                    escritor = gestorAlgoritmos.getModoEscritura().get(0);
                    escritor.Escribir(elDTO);
                    break;
                case 1:
                    escritor = gestorAlgoritmos.getModoEscritura().get(1);
                    escritor.Escribir(elDTO);
                    break;
                case 2:
                    escritor = gestorAlgoritmos.getModoEscritura().get(2);
                    escritor.Escribir(elDTO);
                    break;
                default:
                    break;
            }
            
        }
    }
    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        return true;
    }

    public Alfabeto getAlfabetoActual() {
        return alfabetoActual;
    }

    public void setAlfabetoActual(Alfabeto alfabetoActual) {
        this.alfabetoActual = alfabetoActual;
    }
    
    public GestorAlfabeto getGestorAlfabeto() {
        return gestorAlfabeto;
    }

    public void setGestorAlfabeto(GestorAlfabeto gestorAlfabeto) {
        this.gestorAlfabeto = gestorAlfabeto;
    }

    public GestorAlgoritmos getAlgoritmos() {
        return gestorAlgoritmos;
    }

    public void setAlgoritmos(GestorAlgoritmos elAlgoritmo) {
        this.gestorAlgoritmos = elAlgoritmo;
    }
        
}
