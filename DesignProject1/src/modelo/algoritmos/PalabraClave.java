/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.algoritmos;

import java.util.ArrayList;
import modelo.Algoritmo;

/**
 *
 * @author josed
 */
public class PalabraClave extends Algoritmo{
    
    
    public PalabraClave(){
        
    }
    
    
    
    public ArrayList<Integer> obtenerValoresPorCaracter(ArrayList<Character> alfabeto){
        
        ArrayList<Integer> valores = new ArrayList<Integer>();
        
        for(int i = 0; i < alfabeto.size() ; i++){
        
            valores.add(i+1);
        }
        
        return valores;
        
    }
    
    
    
    public String codificarPalabra(String palabraACodificar, String palabraClave, ArrayList<Character> alfabeto){
        
        String palabraCodificada = "";
        
        int valorLetraCodificar;
        int valorLetraClave;
        int valorTotal ;
        int largoAlfabeto = alfabeto.size();
        
        char letraACodificar;
        char letraPalabraClave;
        
        char nuevaLetra;
        int posClave = 0 ;

        
        for(int i = 0; i< palabraACodificar.length();i++){
            
            letraACodificar = palabraACodificar.charAt(i);
            
            if(posClave < palabraClave.length()){
                letraPalabraClave = palabraClave.charAt(posClave);
                
            }
            else{
                posClave = 0;
                letraPalabraClave = palabraClave.charAt(posClave);
                
            }
            
            
            
            valorLetraCodificar = alfabeto.indexOf(letraACodificar) + 1;
            valorLetraClave = alfabeto.indexOf(letraPalabraClave) + 1;
            
            valorTotal = valorLetraCodificar + valorLetraClave;
            
            if(valorTotal > largoAlfabeto){
                valorTotal = valorTotal - largoAlfabeto;
            }
            
            System.out.println("LetraAC: " +letraACodificar + " LetraClave: " + letraPalabraClave + valorLetraCodificar + " " + valorLetraClave + " " + valorTotal  );
            nuevaLetra = alfabeto.get(valorTotal - 1);
            palabraCodificada += nuevaLetra;
            posClave++;
            
            
            
        }
        
        return palabraCodificada;
        
    }
    
    @Override
    public String Codificar(ArrayList<Object> mensaje, ArrayList<Character> alfabeto){
        
        String mensajeACodificar = (String)mensaje.get(0);
        String palabraClave = "tan";    
        String mensajeCodificado = "";
        
        String palabraACodificar = "";
        String palabraCodificada;
        char caracter;
        
        for(int i = 0 ; i < mensajeACodificar.length(); i++){
            
            caracter = mensajeACodificar.charAt(i);
            
            if(caracter != ' '){
                palabraACodificar += caracter;
            }
            
            else{
                
                palabraACodificar = "";
                palabraCodificada = this.codificarPalabra(palabraACodificar, palabraClave, alfabeto);
                mensajeCodificado += palabraCodificada;
                System.out.println("Palabra codificada: " + palabraCodificada);
           
            }
   
        }
        palabraCodificada = this.codificarPalabra(palabraACodificar, palabraClave, alfabeto);
        mensajeCodificado += palabraCodificada;
        
  
        return mensajeCodificado;
    }
    
    @Override
    public String Decodificar(ArrayList<Object> mensaje, ArrayList<Character> alfabeto){
        
        String mensajeADecodificar = (String)mensaje.get(0);
        String palabraClave = "tan"; // (String)mensaje.get(1);   
        String mensajeDecodificado = "";
        
        String palabraADecodificar = "";
        String palabraDecodificada;
        char caracter;
        
        for(int i = 0 ; i < mensajeADecodificar.length(); i++){
            
            caracter = mensajeADecodificar.charAt(i);
            
            if(caracter != ' '){
                palabraADecodificar += caracter;
            }
            
            else{
                
                palabraDecodificada = this.codificarPalabra(palabraACodificar, palabraClave, alfabeto);
                System.out.println("Palabra codificada: " + palabraCodificada);
           
            }
   
        }
        palabraCodificada = this.codificarPalabra(palabraACodificar, palabraClave, alfabeto);
        
        
  
        return palabraCodificada;
        
        
    }
    
}
