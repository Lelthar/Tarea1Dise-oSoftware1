/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import comunes.DTOAlgoritmos;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;
import comunes.OBJComunicacion;
import comunes.TipoAccion;
import controlador.Controlador;

/**
 *
 * @author gerald
 */
public class Servidor {
    private ServerSocket servidor;   // objeto que se encarga de atender peticiones externas
    private  int PUERTO = 5000; // numero de puerto por donde va a atender peticiones

   // la conexion de escritura del servidor
    private OutputStream conexionSalida;
    private ObjectOutputStream flujoSalida;

    // la conexion de lectura del servidor
    private InputStream conexionEntrada;
    private ObjectInputStream flujoEntrada;

    private Controlador controlador;
    // socket que contiene la conexion con el cliente
    private Socket cliente;         // el proceso cliente que esta atendiendo...

    public Servidor() {
        controlador = new Controlador();
    }
    
    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }
   

    public void inicialiceServidor(JTextArea log) throws InstantiationException, IllegalAccessException{
        try {
            servidor = new ServerSocket(PUERTO);
            while (true){
                
                log.setText(log.getText()+ "\nEsperando una solicitud de un cliente...");
                cliente = servidor.accept();  // acepta la solicitud de un cliente

                log.setText(log.getText()+ "\nEstableciendo canal de escritura...");
                
                // se establece DE PRIMERO  el canal de comunicacion-Escritura
                conexionSalida =  cliente.getOutputStream();
                flujoSalida = new ObjectOutputStream(conexionSalida);

                log.setText(log.getText()+ "\nEstableciendo canal de lectura...");
                // se establece DE SEGUNDO el canal de comunicacion-Lectura
                conexionEntrada = cliente.getInputStream();
                flujoEntrada = new ObjectInputStream(conexionEntrada);

                // atender la peticion...
                log.setText(log.getText()+ "\nAtendiendo peticion...");
                procesePeticion(log);

                log.setText(log.getText()+ "\nDesconectando...");
                log.setCaretPosition(log.getText().length());  // manda el log al final
                flujoEntrada.close();
                log.setText(log.getText()+ "\nError 2");
                flujoSalida.close();
                log.setText(log.getText()+ "\nError 3");
                cliente.close();
                log.setText(log.getText()+ "\nError 4");
            }
        } catch (IOException ex) {
            System.out.println("Problemas creando el servidor en el puerto "+ PUERTO);
        }
    }

    private void procesePeticion(JTextArea log) throws InstantiationException, IllegalAccessException {
        try {
            OBJComunicacion objeto = (OBJComunicacion) flujoEntrada.readObject();
            if (null != objeto.getAccion()) // detectar lo que le enviaron...
            switch (objeto.getAccion()) {
                case PETICION:{
                    //String elLogin=(String) objeto.getDatoEntrada();
                    //log.setText(log.getText()+ "\nAtendiendo peticion REGISTRAR USUARIO.."+ elLogin);
                    //objeto.setDatoSalida(adm.registrar(elLogin)); aqui va el dto
                    DTOAlgoritmos consulta = (DTOAlgoritmos) objeto.getDatoEntrada();
                    log.setText("Entró a la petición");
                    consulta = controlador.procesarPeticion(consulta);
                    log.setText("");
                    System.out.println("Error1");
                    if ( consulta.getRespuesta() != null) {
                        log.setText(log.getText()+ "\nSe realizó la peticion "+consulta.getResultadoAlgoritmos().get(0));
                    } else {
                        log.setText(log.getText()+ "\nOcurrió un error realizando la peticion");
                    }  
                    objeto.setDatoSalida(consulta);
                    log.setText(log.getText()+ "\nError 1");
                        break;
                    }
             
                case OBTENER_ALGORITMOS:{
                    //String elLogin=(String) objeto.getDatoEntrada();
                    log.setText("Se obtuvieron los algoritmos");
                    objeto.setDatoSalida(controlador.getAlgoritmos().getListaTipos());
                        break;
                    }
                case OBTENER_ESCRITURAS:{
                    //String elLogin=(String) objeto.getDatoEntrada();
                    //log.setText(log.getText()+ "\nAtendiendo peticion DESACTIVAR USUARIO.."+ elLogin);
                    //objeto.setDatoSalida(adm.desactivar(elLogin)); aqui va el dto
                        break;
                    }
                case GENERAR_FRASE:{
                    //String elLogin=(String) objeto.getDatoEntrada();
                    //log.setText(log.getText()+ "\nAtendiendo peticion DESACTIVAR USUARIO.."+ elLogin);
                    //objeto.setDatoSalida(adm.desactivar(elLogin)); aqui va el dto
                        break;
                    }
                default:
                    log.setText("No existe esa petición en el servidor");
                    break;
            }

            flujoSalida.writeObject(objeto);
        } catch (IOException ex) {
            log.setText(log.getText()+ "\n"+ex.toString());
            System.out.println("Problemas leyendo o escribiendo en el flujo entrada/salida");
        } catch (ClassNotFoundException ex) {
            System.out.println("Problemas en la conversion del objeto recibido...");
        }
    }
}
