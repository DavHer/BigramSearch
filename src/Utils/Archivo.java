/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Main.Main;

/**
 *
 * @author david
 */
public class Archivo {
    public static String leerArchivoPorLinea(String archivo) {
        String ret = "";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line = br.readLine();

            while (line != null) {
                ret += line;
                ret += " ";
                line = br.readLine();
            }
        } catch (FileNotFoundException  ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
