/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_sd;

/**
 *
 * @author david
 */
public class Tarea1_SD {

    public static void bigramSearch(int a, int b, String str){
        String w1 = "";
        int n_w = 0;
        for(int i=a; i<str.length(); i++){
            if(str.charAt(i) == ' '){
                n_w++;
                if(n_w == 1){
                    w1 = str.substring(b, i);
                    System.out.println(w1);
                    n_w = 0;
                    b = a;
                    a = i+1;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String text = "@ Estas son muchas palabras en un mismo texto palabras en un mismo $ ";
        bigramSearch(0, text.length(), text);
    }
    
}
