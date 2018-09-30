
package comunes;

import java.io.Serializable;


/**
 *
 * @author gerald
 */
public class OBJComunicacion implements Serializable{

    Object datoEntrada;
    TipoAccion accion;
    Object datoSalida;

    public OBJComunicacion(Object datoEntrada, TipoAccion accion) {
        this.datoEntrada = datoEntrada;
        this.accion = accion;
    }

    public TipoAccion getAccion() {
        return accion;
    }

    public void setAccion(TipoAccion accion) {
        this.accion = accion;
    }

    public Object getDatoEntrada() {
        return datoEntrada;
    }

    public void setDatoEntrada(Object datoEntrada) {
        this.datoEntrada = datoEntrada;
    }

    public Object getDatoSalida() {
        return datoSalida;
    }

    public void setDatoSalida(Object datoSalida) {
        this.datoSalida = datoSalida;
    }

}
