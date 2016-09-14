/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigramascliente;

import Modelo.Bigrama;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class Main {
    
    public static final int DIGRAMA = 0;
    
    public static List<String> obtenerParametros(String []args){
        List<String> lista = new ArrayList<>();
        if(args.length > 0) {
            lista.add(args[DIGRAMA]);
        } 
        else {
            System.out.println("Uso: javac BigramasCliente \"[bigrama]\"");
        }
        return lista;
    }

    public static void main(String[] args) {
        Bigrama bigrama = null;
        List<String> parametros = obtenerParametros(args);
        if(parametros.isEmpty()){
            return;
        }
        
        if(parametros.size() > 0){
            String bigramSplited[] = parametros.get(DIGRAMA).split(" ");
            if(bigramSplited.length == 1){
                bigrama = new Bigrama(bigramSplited[0]);
                System.out.println(bigrama);
            }
            if(bigramSplited.length == 2){
                bigrama = new Bigrama(bigramSplited);
                System.out.println(bigrama);
            }
        }
        
        try {
            Cliente cliente = new Cliente("localhost", 8888);
            Integer frecuencia = cliente.pedirFrecuencia(bigrama);
            if(frecuencia == null)
                System.out.println("Fallo al obtener datos");
            else
                System.out.println(bigrama.toString() + ": " + frecuencia);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
