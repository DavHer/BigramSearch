/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Controlador.BigramaControlador;
import Modelo.Bigrama;
import Vista.VistaServidor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author david
 */
public class Servidor {
    public ServerSocket serverSocket;
    BigramaControlador controlador;

    public Servidor(int puerto, BigramaControlador bc) throws IOException {
        serverSocket = new ServerSocket(puerto, 5);
        controlador = bc;
    }

    public void correr() throws IOException, ClassNotFoundException {
        Socket s;
        Bigrama dato = null;
        while (true) {
            s = serverSocket.accept();
            VistaServidor vista = new VistaServidor(s);
            controlador.setVista(vista);
            
            System.out.println("Sirviendo a: " + s.getInetAddress().getHostName());
            System.out.println("Esperando bigrama...");
            dato = controlador.leerBrigramaBlocking();
            System.out.println("Bigrama: "+dato.toString());
            controlador.verRepBigrama(dato);
        }
    }

}
