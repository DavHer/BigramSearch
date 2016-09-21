import java.rmi.*;  // Importar Remote y RemoteException de rmi.

public class ClienteRMI {
   public static void main(String args[]){
      int i = 0;
      System.err.println("\nInicializando el cliente...\n");
      try{
         Servidor remoto = (Servidor) Naming.lookup("//localhost/Servidor");
         for(i=0;i<5;i++) {
            System.out.println("Palabra remota: " + remoto.getNombre());
            System.out.println("Contador remoto: " + remoto.getCantidadConsultas());
         }
      }
      catch(Exception e){
         e.printStackTrace();
         System.exit(1);
      }
   }
}
