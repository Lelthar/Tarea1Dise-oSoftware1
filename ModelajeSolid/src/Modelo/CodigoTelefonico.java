/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author josed
 */
public class CodigoTelefonico extends Algoritmo {
    
    private ArrayList distSimbolos ;

    public CodigoTelefonico(int id,String nombreAlgoritmo){
        super(id,nombreAlgoritmo);
    }

    public CodigoTelefonico() {
    }
    
    
    public ArrayList<String> Distribucion (ArrayList<Character> alfabeto){
        
        
        int cantidadDigitos = 10 ;
        
        
        int sobrante = alfabeto.size() % cantidadDigitos;
        int caracteresPorNumero ; 
        if(sobrante !=0 ){
            caracteresPorNumero = (alfabeto.size() / cantidadDigitos ) + 1;
        }
        else{
            caracteresPorNumero = alfabeto.size() / cantidadDigitos ;
        }
        
        
        ArrayList<String> distribucion = new ArrayList<String>();
        String caracteresAsignados = "";

        for(int i = 0; i < alfabeto.size() ; i++){
            
            if (caracteresAsignados.length() != caracteresPorNumero){
                caracteresAsignados += alfabeto.get(i);
            }
            else{
                
                distribucion.add(caracteresAsignados);
                caracteresAsignados = "";
                caracteresAsignados += alfabeto.get(i);
                
            }
            
        }
        
        if(!distribucion.contains(caracteresAsignados))
            distribucion.add(caracteresAsignados);
        return distribucion;
           
    }
    
    
    @Override
    public String Codificar(String mensaje, ArrayList<Character> alfabeto){
        
        mensaje = mensaje.toLowerCase();
        
        ArrayList<String> distribucion = this.Distribucion(alfabeto);
        System.out.println(distribucion);
        String mensajeCodificado = "";
        String codigoPorLetra = "";
        String caracteresPorNumero = "";
        String letra ;
        char letraChar ;
        int numeroDistribucion;
        int posicionEnDistribucion;
        
        for(int i = 0; i < mensaje.length() ; i++){
                  
            letraChar = mensaje.charAt(i);
            letra = String.valueOf(letraChar);
            
            
            if(!letra.equals(" ")){
                
                for(int j = 0; j < distribucion.size() ; j++) {
                
                caracteresPorNumero = distribucion.get(j);
                if(caracteresPorNumero.contains(letra)){
                    
                    numeroDistribucion = j ; 
                    codigoPorLetra += String.valueOf(numeroDistribucion);
                    posicionEnDistribucion = caracteresPorNumero.indexOf(letra) + 1;
                    codigoPorLetra += String.valueOf(posicionEnDistribucion);
                    mensajeCodificado += codigoPorLetra;
                    
                    
                    mensajeCodificado += " ";
                    codigoPorLetra = "";
                    caracteresPorNumero = "";
                    break;     
                }
                
            }
                   
        }
        else{
                mensajeCodificado += "*";
                
            }
            
        }
          
        return mensajeCodificado;
    }
    @Override
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
        
        mensaje = mensaje.toLowerCase();
        String mensajeDecodificado = ""; 
        ArrayList<String> distribucion = this.Distribucion(alfabeto);
        String letra ; 
        char letraChar;
        String palabra = "";
        String caracteresPorNumero;
        String letraDecodificada;
        char letraDecodificadaChar;
        int numeroDistribucion; 
        int posicionDistribucion;
        
        for (int i = 0 ; i < mensaje.length() ; i++){
            
            letraChar = mensaje.charAt(i);
            letra = String.valueOf(letraChar);
            System.out.println("Letra:");
            System.out.println(letra);
            
            if(!letra.equals(" ") && !letra.equals("*")){
                
                numeroDistribucion = Integer.valueOf(letra);
                i++;
                letraChar = mensaje.charAt(i);
                letra = String.valueOf(letraChar);
                posicionDistribucion = Integer.valueOf(letra);
                caracteresPorNumero = distribucion.get(numeroDistribucion);
                letraDecodificadaChar = caracteresPorNumero.charAt(posicionDistribucion - 1);
                letraDecodificada = String.valueOf(letraDecodificadaChar);
                palabra += letraDecodificada;
                
              
            }
            else if (letra.equals("*")){
                
                mensajeDecodificado += palabra;
                mensajeDecodificado += " ";
                palabra = "";
                
            }
            
            else{
                
            }
            
        }
        
        mensajeDecodificado += palabra; 
        System.out.println("Mensaje DECODIFICADO:");
        System.out.println(mensajeDecodificado);
        return mensajeDecodificado;
    }
    
   
    
    
    
    
    
}
