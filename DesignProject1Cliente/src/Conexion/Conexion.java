/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import comunes.OBJComunicacion;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rigo-PC
 */
public class Conexion {
    private   String HOST =  "localhost";
    private    int PUERTO= 5000;

    private InputStream conexionEntrada;
    private ObjectInputStream flujoLectura;

    private OutputStream conexionSalida;
    private ObjectOutputStream flujoEscritura;

    public Conexion() {
    }
     public String getHOST() {
        return HOST;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }


   

    public OBJComunicacion conecteServidor(OBJComunicacion objeto) throws UnknownHostException{
        try {
            
            Socket conexion = new Socket(HOST, PUERTO);
            //Establece mecanismo de comunicacion con el servidor - Lectura..
            System.out.println("Estableciendo comunicacion de lectura con el server...");
            conexionEntrada = conexion.getInputStream();
            flujoLectura = new ObjectInputStream(conexionEntrada);
            System.out.println("Estableciendo comunicacion de escritura con el server...");
            conexionSalida = conexion.getOutputStream();
            flujoEscritura = new ObjectOutputStream(conexionSalida);

            // procesar la gestion a solicitar
            flujoEscritura.writeObject(objeto);
            flujoEscritura.flush();
            
            // recupera la respuesta del servidor...
            objeto = (OBJComunicacion) flujoLectura.readObject();

            flujoEscritura.close();
            flujoLectura.close();
            conexion.close();
            
        } catch (ClassNotFoundException  ex) {
            System.out.println("Conectandose a un servidor desconocido");
        }
        catch (UnknownHostException ex) {
            System.out.println("Conectandose a un servidor desconocido");
        } catch (IOException ex) {
            System.out.println("Problemas con los flujos de entrada / salida");
        }



        return objeto;
    }

}
