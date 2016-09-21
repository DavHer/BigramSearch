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
 * @author herdoiza
 */
public class VistaRMI extends Vista{

    Bigrama bigrama = null;
    Integer resultado = null;

    public void setBigrama(Bigrama bigrama) {
        this.bigrama = bigrama;
    }

    public Integer getResultado() {
        return resultado;
    }

    @Override
    public void verRepListaBigramas(Map<Bigrama, Integer> hashMap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void verRepBigrama(Map<Bigrama, Integer> hashMap, Bigrama bigrama) {
        Integer valor = hashMap.get(bigrama);
        System.out.println(bigrama + ": " + valor);
        this.resultado = valor;
    }

    @Override
    public Bigrama leerBigramaBlocking() {
        System.out.println("leyendo datos...");
        while(true){
            if(bigrama != null)
                break;
        }
        System.out.println("Datos leidos");
        Bigrama big = new Bigrama(this.bigrama.getWord1(),this.bigrama.getWord2());
        bigrama = null;
        return big;
    }

}
