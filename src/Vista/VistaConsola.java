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
public class VistaConsola extends Vista{

    public VistaConsola() {
    }
    
    @Override
    public void verRepListaBigramas(Map<Bigrama, Integer> hashMap){
        for (Map.Entry<Bigrama, Integer> entry : hashMap.entrySet()) {
            Bigrama llave = entry.getKey();
            String llaveString = llave.toString().replace("@ ", "").replace(" $", "");
            System.out.println(llaveString + ": " + entry.getValue());
        }
    }
    
    @Override
    public void verRepBigrama(Map<Bigrama, Integer> hashMap, Bigrama bigrama){
        Integer valor = hashMap.get(bigrama);
        System.out.println(bigrama + ": " + valor);
    }
    
    @Override
    public Bigrama leerBigramaBlocking(){
        return new Bigrama("", "");
    }
}
