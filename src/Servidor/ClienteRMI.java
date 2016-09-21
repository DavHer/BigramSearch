/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Modelo.Bigrama;
import java.io.IOException;
import java.rmi.Naming;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herdoiza
 */
public class ClienteRMI {

    public static final int BIGRAMA = 0;

    public static List<String> obtenerParametros(String[] args) {
        List<String> lista = new ArrayList<>();
        if (args.length > 0) {
            lista.add(args[BIGRAMA]);
        } else {
            System.out.println("Uso: javac BigramasCliente \"[bigrama]\"");
        }
        return lista;
    }

    public static void main(String args[]) {
        Bigrama bigrama = null;
        List<String> parametros = obtenerParametros(args);
        if (parametros.isEmpty()) {
            return;
        }

        if (parametros.size() > 0) {
            String bigramSplited[] = parametros.get(BIGRAMA).split(" ");
            if (bigramSplited.length == 1) {
                bigrama = new Bigrama(bigramSplited[0]);
                System.out.println(bigrama);
            }
            if (bigramSplited.length == 2) {
                bigrama = new Bigrama(bigramSplited);
                System.out.println(bigrama);
            }
        }
        System.err.println("\nInicializando el cliente...\n");
        try {
            ServidorRMI remoto = (ServidorRMI) Naming.lookup("//localhost/Servidor");
            Integer resultado = remoto.requestBigramCount(bigrama);
            System.out.println(bigrama.toString() + ": " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
