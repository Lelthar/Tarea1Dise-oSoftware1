 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

    public Controlador() {
        gestorAlgoritmos = new GestorAlgoritmos();
        gestorAlfabeto = new GestorAlfabeto(new ArrayList<>());
        gestorEscritor = new GestorEscritor();
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
    public void procesarPeticion(DTOAlgoritmos elDTO) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        this.gestorAlgoritmos.ejecutarAlgoritmo(elDTO, getGestorAlfabeto().getAlfabetos().get(elDTO.getNumeroAlfabeto()).getSimbolos());
          
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
