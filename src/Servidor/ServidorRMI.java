/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Modelo.Bigrama;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author herdoiza
 */
public interface ServidorRMI extends Remote{
    public Integer requestBigramCount(Bigrama bigrama) throws RemoteException;
}
