/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import comunes.DTOAlgoritmos;

/**
 *
 * @author josed
 */
public interface iEscritor {    
    
    // Recibe como parametro DTO, por ahora es un string
    public boolean Escribir(DTOAlgoritmos DtoAlgoritmos);


    
    
}
