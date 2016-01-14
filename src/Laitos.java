
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
	
	private ArrayList<Thread> juomamestarit = new ArrayList<Thread>();
	
	public Laitos(Ruuvikuljetin a, Siilo[] siilot, Ruuvikuljetin[] b, Juomakeitin[] j, Pumppu[] p, Kypsytyssäiliö[] ks, Pumppu[] pl) throws RemoteException {
		
	}
}