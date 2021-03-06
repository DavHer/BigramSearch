/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.BigramaControlador;
import Modelo.Bigrama;
import Modelo.BigramaContenedor;
import Utils.Archivo;
import Vista.VistaConsola;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author david
 */
public class Main {
    
    public static final int ARCHIVO = 0;
    public static final int DIGRAMA = 1;
    
    public static List<String> obtenerParametros(String []args){
        List<String> lista = new ArrayList<>();
        if(args.length > 0) {
            if(args.length == 1){
                lista.add(args[ARCHIVO]);
            }
            else {
                lista.add(args[ARCHIVO]);
                lista.add(args[DIGRAMA]);
            }
        } 
        else {
            System.out.println("Uso: javac Bigramas archivo \"[bigrama]\"");
        }
        return lista;
    }

    public static void main(String[] args) {
        
        List<String> parametros = obtenerParametros(args);
        if(parametros.isEmpty()){
            return;
        }
        
        Map<Bigrama, Integer> mapa = new LinkedHashMap<>();
        
        BigramaContenedor bigramaModelo = new BigramaContenedor(mapa);
        VistaConsola bigramaVista = new VistaConsola();
        
        BigramaControlador controlador = new BigramaControlador(bigramaModelo,
                                                                bigramaVista);
        
        String archivo = Archivo.leerArchivoPorLinea(parametros.get(ARCHIVO));
        
        controlador.setBigramaArchivo(archivo);
        controlador.cargarBigramas();
        
        if(parametros.size() > 1){
            String bigramSplited[] = parametros.get(DIGRAMA).split(" ");
            if(bigramSplited.length == 2){
                Bigrama bigrama = new Bigrama(bigramSplited);
                controlador.verRepBigrama(bigrama);
            }
        }
        else
            controlador.verRepListaBigramas();
    }

}
