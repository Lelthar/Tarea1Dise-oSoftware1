 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import comunes.DTOAlgoritmos;
import modelo.Alfabeto;
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
    private GestorEscritor gestorEscritor;
    private GestorFrase gestorFrase;

    public Controlador() {
        gestorAlgoritmos = new GestorAlgoritmos();
        gestorAlfabeto = new GestorAlfabeto();
        gestorEscritor = new GestorEscritor();
        gestorFrase = new GestorFrase();
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
    public DTOAlgoritmos procesarPeticion(DTOAlgoritmos elDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        predefinirAlfabeto(elDTO);
        if ( Validar(elDTO )) {
            this.gestorAlgoritmos.ejecutarAlgoritmo(elDTO, getGestorAlfabeto().getAlfabetos().get(elDTO.getNumeroAlfabeto()).getSimbolos());
            escribir(elDTO);
            elDTO.setRespuesta("OK");
            return elDTO;
        } else {
            elDTO.setRespuesta("Caracteres de la entrada no pertenecen al alfabeto seleccionado.");
            return elDTO;
        }
          
    }
    
    /**
     * Guarda el alfabeto que debe de utilizar
     * @param elDTO 
     */
    public void predefinirAlfabeto(DTOAlgoritmos elDTO){
        alfabetoActual = gestorAlfabeto.getAlfabetos().get(elDTO.getNumeroAlfabeto());
       
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
    public void escribir(DTOAlgoritmos dtoAlgoritmos) throws InstantiationException, ClassNotFoundException, IllegalAccessException{
        this.gestorEscritor.escribirSalida(dtoAlgoritmos);
    }
    
    @Override
    public boolean Validar(DTOAlgoritmos DtoAlgoritmos) {
        
        String frase = (String) DtoAlgoritmos.getDatosEntrada().get(0);
        
        for (int i = 0; i < frase.length(); i++) {
            if ( !this.alfabetoActual.getSimbolos().contains(frase.charAt(i)) && frase.charAt(i) != ' ' )
                return false;
        }
        
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
    
    public ArrayList<String> obtenerAlfabetos(){
        return getGestorAlfabeto().getListaAlfabetos();
    }

    public GestorFrase getGestorFrase() {
        return gestorFrase;
    }

    public void setGestorFrase(GestorFrase gestorFrase) {
        this.gestorFrase = gestorFrase;
    }
    
    
}
