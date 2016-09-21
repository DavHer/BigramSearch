/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Bigrama;
import Modelo.BigramaContenedor;
import Vista.Vista;
import Vista.VistaConsola;
import java.util.Map;

/**
 *
 * @author david
 */
public class BigramaControlador {
    private BigramaContenedor modelo;
    private Vista vista;

    public BigramaControlador(BigramaContenedor modelo, VistaConsola vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void setModelo(BigramaContenedor modelo) {
        this.modelo = modelo;
    }

    public void setVista(Vista vista) {
        this.vista = vista;
    }

    public void setBigramaArchivo(String archivo) {
        this.modelo.setArchivo(archivo);
    }

    public void setBigramaHashMap(Map<Bigrama, Integer> hashMap) {
        this.modelo.setHashMap(hashMap);
    }

    public String getBigramaArchivo() {
        return modelo.getArchivo();
    }

    public Vista getVista() {
        return vista;
    }

    public Map<Bigrama, Integer> getBigramaHashMap() {
        return modelo.getHashMap();
    }

    public void cargarBigramas() {
        String bigramaString;
        Bigrama bigrama;
        int cantEspacios = 0;
        int posPrimerBigrama = 0;
        int posSegundoBigrama = 0;
        Integer valor;

        // Encuentra el primer bigrama y guarda la posicion
        for (int i = 0; i < modelo.getArchivo().length(); i++) {
            if (modelo.getArchivo().charAt(i) == ' ') {
                cantEspacios++;
                if (cantEspacios == 1) {
                    posPrimerBigrama = i < (modelo.getArchivo().length() - 1) ? i + 1 : i;
                }
                if (cantEspacios == 2) {
                    bigramaString = modelo.getArchivo().substring(0, i);
                    bigrama = new Bigrama(bigramaString.split(" "));
                    posSegundoBigrama = i < (modelo.getArchivo().length() - 1) ? i + 1 : i;
                    valor = modelo.getHashMap().get(bigrama);
                    modelo.getHashMap().put(bigrama, (valor == null ? 0 : valor) + 1);
                    break;
                }
            }
        }

        // Carga el resto de bigramas usando la posicion del primer bigrama
        for (int i = posSegundoBigrama; i < modelo.getArchivo().length(); i++) {
            if (modelo.getArchivo().charAt(i) == ' ') {
                bigramaString = modelo.getArchivo().substring(posPrimerBigrama, i);
                bigrama = new Bigrama(bigramaString.split(" "));
                Integer val = modelo.getHashMap().get(bigrama);
                modelo.getHashMap().put(bigrama, (val == null ? 0 : val) + 1);
                posPrimerBigrama = posSegundoBigrama;
                posSegundoBigrama = i < (modelo.getArchivo().length() - 1) ? i + 1 : i;
            }
        }
    }

    public void verRepListaBigramas(){
        vista.verRepListaBigramas(modelo.getHashMap());
    }

    public void verRepBigrama(Bigrama bigrama){
        vista.verRepBigrama(modelo.getHashMap(), bigrama);
    }

    public Bigrama leerBrigramaBlocking(){
        return vista.leerBigramaBlocking();
    }
}
