/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_sd;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author david
 */
public class Tarea1_SD {

    static Map<String, Integer> hashMap = new LinkedHashMap<>();

    public static void bigramSearch(int a, int b, String str) {
        String w1 = "";
        int n_w = 0;
        // Get first bigram
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                n_w++;
                if (n_w == 1) {
                    b = i < (str.length() - 1) ? i + 1 : i;
                }
                if (n_w == 2) {
                    w1 = str.substring(0, i);
                    a = i < (str.length() - 1) ? i + 1 : i;
                    Integer val = hashMap.get(w1);
                    hashMap.put(w1, (val == null ? 0 : val) + 1);
                    //System.out.println(w1);
                    break;
                }
            }
        }

        for (int i = a; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                w1 = str.substring(b, i);
                //System.out.println(w1);
                Integer val = hashMap.get(w1);
                hashMap.put(w1, (val == null ? 0 : val) + 1);
                b = a;
                a = i < (str.length() - 1) ? i + 1 : i;
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String text = "@ Estas son muchas palabras en un mismo texto palabras en un mismo $ ";
        bigramSearch(0, text.length(), text);
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}
