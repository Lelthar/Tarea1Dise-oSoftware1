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
public class Binario extends Algoritmo{
    
    
    
    
    
    public Binario(){
 
    }
    
    
    
    public double logaritmo(int base, int valor){
        
        double logaritmo = ( Math.log(valor) ) / (Math.log(base));
        return logaritmo;
    }
    
    
    public String ConvertirBinario(int valor){
        
        String valorBinario  = Integer.toBinaryString(valor);
        return valorBinario;
        
    }
    
    public String RellenarCeros(String codigoBinario, int cantidadDigitos){

        while(codigoBinario.length() < cantidadDigitos){
            codigoBinario = "0" + codigoBinario;
        }
        return codigoBinario;
    }
    
    public ArrayList<String> codigosBinarios(ArrayList<Character> alfabeto){
        
        
        ArrayList<String> listaCodigosBinarios = new ArrayList<String>();
        String codigoBinario = "";
        int cantidadCaracteres = alfabeto.size();
        Double cantidadDigitos = logaritmo(2, cantidadCaracteres); 
        int cantidadDigitosRedondeado = (int) Math.round(cantidadDigitos);

        int largoCodigoBinario;
        
        for(int i = 0 ; i < alfabeto.size() ; i++){
            
            codigoBinario = this.ConvertirBinario(i);
            largoCodigoBinario = codigoBinario.length();
            if (largoCodigoBinario < cantidadDigitosRedondeado){
                
                codigoBinario = RellenarCeros(codigoBinario,cantidadDigitosRedondeado);
                
            }
            listaCodigosBinarios.add(codigoBinario); 
            
        }
        
        
        System.out.println(listaCodigosBinarios);
        return listaCodigosBinarios;
          
    }
    
    public int posicionLetraEnAlfabeto(ArrayList<Character> alfabeto, char caracter){
        
        
        char caracterActual;
        
        for(int i = 0; i < alfabeto.size() ; i++){
            
            caracterActual = alfabeto.get(i);
           // System.out.println("Caracter Actual: " + caracterActual + " Caracter buscado: " + caracter);
            if(caracterActual == caracter){
                return i;
            } 
        }
        return -1;
    }
    @Override
    public String Codificar(String mensajeParam, ArrayList<Character> alfabeto){
        
        
        ArrayList<String> codigosBinarios = this.codigosBinarios(alfabeto);
        String mensajeCodificado = "";
        String letraCodificada;
        int posicionLetraACodificar;
        char letraACodificar;
        
        String mensaje = mensajeParam.toLowerCase();
        
        
        for(int i = 0; i < mensaje.length();i++){
            
            letraACodificar = mensaje.charAt(i);
            
            if(letraACodificar == ' '){
                
                mensajeCodificado = mensajeCodificado + "*";
            }
            
            else{
                
                posicionLetraACodificar = this.posicionLetraEnAlfabeto(alfabeto, letraACodificar);
                letraCodificada = codigosBinarios.get(posicionLetraACodificar);
                mensajeCodificado = mensajeCodificado + " " + letraCodificada ;
                
            }
     
        }
    
      
        System.out.println("Mensaje Codificado: " + mensajeCodificado);
        return mensajeCodificado;
    }
    
    @Override
    public String Decodificar(String mensaje, ArrayList<Character> alfabeto){
        
        
        
        String mensajeDecodificado = "";
        char caracterActual;
        char letraDecodificada;
        String palabraDecodificada = "";
        String codigoBinario = "";
        String numeroConvertidoString;
        int numeroConvertido;
        
        int cantidadCaracteres = alfabeto.size();
        Double cantidadDigitos = logaritmo(2, cantidadCaracteres); 
        int cantidadDigitosRedondeado = (int) Math.round(cantidadDigitos);
        
        
        for(int i = 0; i < mensaje.length(); i++){
            
            
            caracterActual = mensaje.charAt(i);
            if(caracterActual != ' ' && caracterActual != '*'){
                
                
                codigoBinario += caracterActual;
                if(codigoBinario.length() == cantidadDigitosRedondeado){
                    
                    numeroConvertido = Integer.parseInt(codigoBinario, 2);
                    System.out.println("Numero Convertido: " + numeroConvertido);
                    letraDecodificada = alfabeto.get(numeroConvertido);
                    palabraDecodificada += letraDecodificada;
                    codigoBinario = "";
                }
                    
            }
             
            else{
                
                if(caracterActual == '*'){
                    
                    mensajeDecodificado += palabraDecodificada + " ";
                    palabraDecodificada = "";
                }
                
            }
            
            
            
            
        }
        
        mensajeDecodificado += palabraDecodificada;
        
        System.out.println("mensaje:" + mensajeDecodificado);
        return mensajeDecodificado;
    }
    
}
