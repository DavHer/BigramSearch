/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Controlador.BigramaControlador;
import Modelo.Bigrama;
import Vista.VistaRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author herdoiza
 */
public class ServidorRMIImpl extends UnicastRemoteObject implements ServidorRMI {

    BigramaControlador controlador;

    public ServidorRMIImpl (BigramaControlador c) throws RemoteException{
        super();
        controlador = c;
    }

    @Override
    public void setBigram(Bigrama bigrama) throws RemoteException{
        //VistaRMI vista = (VistaRMI)controlador.getVista();
        //vista.setBigrama(bigrama);
        System.out.println(bigrama.toString());
    }

    @Override
    public String getResultado() throws RemoteException{
        //VistaRMI vista = (VistaRMI)controlador.getVista();
        //return vista.getResultado();
        return "nada";
    }

    public void correr() {
        VistaRMI vista = new VistaRMI();
        controlador.setVista(vista);
        while(true) {
            // Esperar a que haya un bigrama
            Bigrama bigrama = controlador.leerBrigramaBlocking();
            // Responder
            controlador.verRepBigrama(bigrama);
        }
    }

    @Override
    public void setResultado(String resultado)throws RemoteException{
        VistaRMI vista = (VistaRMI)controlador.getVista();
        vista.setResultado(resultado);
    }

}
