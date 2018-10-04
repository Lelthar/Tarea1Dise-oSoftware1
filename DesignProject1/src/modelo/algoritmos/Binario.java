/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.algoritmos;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Algoritmo;

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
    
    @Override
    public String Codificar(ArrayList<Object> mensajeParam, ArrayList<Character> alfabeto){
        
        
        ArrayList<String> codigosBinarios = this.codigosBinarios(alfabeto);
        String mensajeCodificado = "";
        String letraCodificada;
        int posicionLetraACodificar;
        char letraACodificar;
        
        String mensaje = (String) mensajeParam.get(0);
        
        
        for(int i = 0; i < mensaje.length();i++){
            
            letraACodificar = mensaje.charAt(i);
            
            if(letraACodificar == ' '){
                
                mensajeCodificado = mensajeCodificado + "*";
            }
            
            else{
                
                posicionLetraACodificar = alfabeto.indexOf(letraACodificar);
                letraCodificada = codigosBinarios.get(posicionLetraACodificar);
                mensajeCodificado = mensajeCodificado + " " + letraCodificada ;
                
            }
     
        }
    
      
        System.out.println("Mensaje Codificado: " + mensajeCodificado);
        return mensajeCodificado;
    }
    
    @Override
    public String Decodificar(ArrayList<Object> mensaje, ArrayList<Character> alfabeto){
        
        
        
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
        
        String mensajeBinario = (String) mensaje.get(0);
        
        for(int i = 0; i < mensajeBinario.length(); i++){
            
            
            caracterActual = mensajeBinario.charAt(i);
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
