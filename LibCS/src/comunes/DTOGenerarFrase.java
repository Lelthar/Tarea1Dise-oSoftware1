/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunes;

import java.io.Serializable;

/**
 *
 * @author gerald
 */
public class DTOGenerarFrase implements Serializable {
    private int largo;
    private int tipo;
    private String resultado;
    private int numeroAlfabeto;

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getNumeroAlfabeto() {
        return numeroAlfabeto;
    }

    public void setNumeroAlfabeto(int numeroAlfabeto) {
        this.numeroAlfabeto = numeroAlfabeto;
    }
    
    
}
