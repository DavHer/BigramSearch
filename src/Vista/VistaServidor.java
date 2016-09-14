/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Bigrama;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class VistaServidor extends Vista {

    Socket socket;
    ObjectOutputStream output;
    ObjectInputStream input;

    public VistaServidor(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void verRepListaBigramas(Map<Bigrama, Integer> hashMap) {
        for (Map.Entry<Bigrama, Integer> entry : hashMap.entrySet()) {
            Bigrama llave = entry.getKey();
            String llaveString = llave.toString().replace("@ ", "").replace(" $", "");
            System.out.println(llaveString + ": " + entry.getValue());
        }
    }

    @Override
    public void verRepBigrama(Map<Bigrama, Integer> hashMap, Bigrama bigrama) {
        Integer valor = hashMap.get(bigrama);
        System.out.println(bigrama + ": " + valor);   
        try {
            output.flush();
            if(valor == null)
                valor = -1;
            output.writeObject(valor);
        } catch (IOException ex) {
            Logger.getLogger(VistaServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Bigrama leerBigramaBlocking(){
        Bigrama bigrama = null;
        do {
            try {
                bigrama = (Bigrama) input.readObject();
            } catch (IOException ex) {
                Logger.getLogger(VistaServidor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(VistaServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (bigrama == null && socket.isConnected());
        return bigrama;
    }

}
