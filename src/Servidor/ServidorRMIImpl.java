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
        VistaRMI vista = new VistaRMI();
        controlador.setVista(vista);
    }

    @Override
    public Integer requestBigramCount(Bigrama bigrama) throws RemoteException {
        controlador.verRepBigrama(bigrama);
        VistaRMI vista = (VistaRMI)controlador.getVista();
        return vista.getResultado();
    }

}
