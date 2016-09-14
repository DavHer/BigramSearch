/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigramascliente;

import Modelo.Bigrama;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author david
 */
public class Cliente {

    Socket socket;
    ObjectOutputStream output;
    ObjectInputStream input;

    public Cliente(String address, int puerto) throws IOException {
        socket = new Socket(address, puerto);
    }

    public Integer pedirFrecuencia(Bigrama bigrama) throws IOException, ClassNotFoundException {
        Integer frecuencias = null;
        System.out.println("Conectado a: "
                + socket.getInetAddress().getHostName());
        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush();
        input = new ObjectInputStream(socket.getInputStream());
        output.writeObject(bigrama);
        do {
                frecuencias = (Integer) input.readObject();
        } while (frecuencias == null && socket.isConnected());
        
        return frecuencias;
    }
}
