import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JuomamestariImplementaatio extends UnicastRemoteObject implements Juomamestari {
	// Attribuutit
	private String nimi;
	
	// Konstruktori
	public JuomamestariImplementaatio(String n) throws RemoteException {
		nimi = n;
	}
	
	public void t�yt�Siilot(Ruuvikuljetin r) throws RemoteException {
		
	}
	
	public void varaaSiilo(Siilo s) throws RemoteException {
		
	}
	
	public void t�yt�Juomakeittimet(Ruuvikuljetin r) throws RemoteException {
		
	}
	
	public void varaaJuomakeitin(Juomakeitin j) throws RemoteException {
		
	}
	
	public void t�yt�Kypsytyss�ili�t(Pumppu p) throws RemoteException {
		
	}
	
	public void varaaKypsytyss�ili�(Kypsytyss�ili� s) throws RemoteException {
		
	}
	
	public void pullota(Pumppu p) throws RemoteException {
		
	}
	
}
