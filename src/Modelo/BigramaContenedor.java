/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author david
 */
public class BigramaContenedor {
    private Map<Bigrama, Integer> hashMap;
    private String archivo;

    public BigramaContenedor() {
        hashMap = new LinkedHashMap<>();
        archivo = null;
    }

    public BigramaContenedor(Map<Bigrama, Integer> hashMap) {
        this.hashMap = hashMap;
        this.archivo = null;
    }

    public void setArchivo(String archivo) {
        this.archivo = "@ " + archivo + "$ ";
    }

    public void setHashMap(Map<Bigrama, Integer> hashMap) {
        this.hashMap = hashMap;
    }

    public String getArchivo() {
        return archivo;
    }

    public Map<Bigrama, Integer> getHashMap() {
        return hashMap;
    }
}
