/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Bigrama;
import java.util.Map;

/**
 *
 * @author david
 */
public interface VistaInterface {
    public void verRepListaBigramas(Map<Bigrama, Integer> hashMap);
    public void verRepBigrama(Map<Bigrama, Integer> hashMap, Bigrama bigrama);
    public Bigrama leerBigramaBlocking();
}
