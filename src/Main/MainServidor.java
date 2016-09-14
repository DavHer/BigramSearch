/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.BigramaControlador;
import static Main.Main.obtenerParametros;
import Modelo.Bigrama;
import Modelo.BigramaContenedor;
import Servidor.Servidor;
import Utils.Archivo;
import Vista.VistaConsola;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author david
 */
public class MainServidor {
    
    public static final int PUERTO = 8888;
    public static final int ARCHIVO = 0;
    
    public static List<String> obtenerParametros(String []args){
        List<String> lista = new ArrayList<>();
        if(args.length > 0) {
            lista.add(args[ARCHIVO]);
        } 
        else {
            System.out.println("Uso: javac Bigramas archivo");
        }
        return lista;
    }
    static public void main(String []args){
        List<String> parametros = obtenerParametros(args);
        if(parametros.isEmpty()){
            return;
        }
        
        Map<Bigrama, Integer> mapa = new LinkedHashMap<>();        
        BigramaContenedor bigramaModelo = new BigramaContenedor(mapa);        
        BigramaControlador controlador = new BigramaControlador(bigramaModelo,
                                                                null);
        
        String archivo = Archivo.leerArchivoPorLinea(parametros.get(ARCHIVO));
        
        controlador.setBigramaArchivo(archivo);
        controlador.cargarBigramas();
        
        try {
            Servidor servidor = new Servidor(PUERTO, controlador);
            servidor.correr();
        } catch (IOException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
