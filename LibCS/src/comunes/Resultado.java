/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunes;

/**
 *
 * @author gerald
 */
public class Resultado {
    private String nombreAlgoritmo;
    private String resultadoAlgoritmo;
    private String tipoOperacion;

    public Resultado() {
    }

    public String getNombreAlgoritmo() {
        return nombreAlgoritmo;
    }

    public void setNombreAlgoritmo(String nombreAlgoritmo) {
        this.nombreAlgoritmo = nombreAlgoritmo;
    }

    public String getResultadoAlgoritmo() {
        return resultadoAlgoritmo;
    }

    public void setResultadoAlgoritmo(String resultadoAlgoritmo) {
        this.resultadoAlgoritmo = resultadoAlgoritmo;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    @Override
    public String toString() {
        return "Resultado{" + "nombreAlgoritmo=" + nombreAlgoritmo + ", resultadoAlgoritmo=" + resultadoAlgoritmo + ", tipoOperacion=" + tipoOperacion + '}';
    }
    
    
}
