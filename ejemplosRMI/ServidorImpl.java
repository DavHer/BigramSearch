import java.rmi.*;  // Importar Remote y RemoteException de rmi.
import java.rmi.server.*;
import java.util.*; 
import java.io.*;
import java.net.*;

public class ServidorImpl extends UnicastRemoteObject implements Servidor {
   private int contador;
   private String nombre;

   public ServidorImpl () throws RemoteException{
      super();
      contador = 0;
      nombre = new String("Secreto");
   }
   // Se implementan los métodos remotos
   public String getNombre() throws RemoteException{
      contador++;
      return nombre;
   }
   public int getCantidadConsultas() throws RemoteException{
      return contador;
   }
   public static void main(String args[]){
      System.err.println("\nInicializando el servidor...");
      //Se crea el objeto servidor
      try{
         ServidorImpl s = new ServidorImpl();
         //Registrar el objeto 
         String nombreObjetoServidor = "//localhost/Servidor";
         Naming.rebind(nombreObjetoServidor, s);
      }
      catch(Exception e){
         System.err.println("ERROR AL REGISTRAR SERVIDOR");
      }
      System.err.println("\nEl servidor esta corriendo");
   }
}
