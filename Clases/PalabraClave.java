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
    
    
    
    public String codificarPalabra(String palabraACodificar, String palabraClave, 
            ArrayList<Character> alfabeto){
        
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
            
           
            nuevaLetra = alfabeto.get(valorTotal - 1);
            palabraCodificada += nuevaLetra;
            posClave++;
 
        }
        
        return palabraCodificada;
        
    }
    
    public String decodificarPalabra(String palabraADecodificar, String palabraClave,
            ArrayList<Character> alfabeto){
        
        String palabraDecodificada = "";
        
        int valorLetraDecodificar;
        int valorLetraClave;
        int valorTotal ;
        int largoAlfabeto = alfabeto.size();
        
        char letraADecodificar;
        char letraPalabraClave;
        
        char nuevaLetra;
        int posClave = 0 ;

        
        for(int i = 0; i< palabraADecodificar.length();i++){
            
            letraADecodificar = palabraADecodificar.charAt(i);
            
            if(posClave < palabraClave.length()){
                letraPalabraClave = palabraClave.charAt(posClave);
                
            }
            else{
                posClave = 0;
                letraPalabraClave = palabraClave.charAt(posClave);
                
            }

            valorLetraDecodificar = alfabeto.indexOf(letraADecodificar) + 1;
            valorLetraClave = alfabeto.indexOf(letraPalabraClave) + 1;
            
            valorTotal = valorLetraDecodificar - valorLetraClave;

            if(valorTotal < 0 ){
                valorTotal = valorTotal + largoAlfabeto;
            }

            nuevaLetra = alfabeto.get(valorTotal - 1);
            palabraDecodificada += nuevaLetra;
            posClave++;
 
        }
        
        return palabraDecodificada;

        
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

                palabraCodificada = this.codificarPalabra(palabraACodificar, palabraClave, alfabeto);
                mensajeCodificado += palabraCodificada + " ";
                palabraACodificar = "";
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
        String palabraDecodificada = "";
        char caracter;
        
        System.out.println("Palabra a decodificar: " + mensajeADecodificar);
        
        for(int i = 0 ; i < mensajeADecodificar.length(); i++){
            
            caracter = mensajeADecodificar.charAt(i);
            
            if(caracter != ' '){
                palabraADecodificar += caracter;
            }
            
            else{
                
                palabraDecodificada = decodificarPalabra(palabraADecodificar, palabraClave, alfabeto);
                mensajeDecodificado += palabraDecodificada + " ";
                palabraADecodificar = "";
                System.out.println("Palabra Decodificada: " + palabraDecodificada);

           
            }
   
        }
        
        System.out.println("");
        palabraDecodificada = this.decodificarPalabra(palabraADecodificar, palabraClave, alfabeto); 
        mensajeDecodificado += palabraDecodificada;
        System.out.println("Mensaje decodificado: " + mensajeDecodificado);
        return mensajeDecodificado;
        
        
    }
    
}
