import java.rmi.*; // Importar Remote y RemoteException de rmi.

public interface Servidor extends Remote {
   public String getNombre() throws RemoteException;
   public int getCantidadConsultas() throws RemoteException;
}
