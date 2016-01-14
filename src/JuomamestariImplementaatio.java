import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class JuomamestariImplementaatio extends UnicastRemoteObject implements Juomamestari {
	// Attribuutit
	private String nimi;
	
	// Konstruktori
	public JuomamestariImplementaatio(String n) throws RemoteException {
		nimi = n;
	}
	
	public void täytäSiilot(Ruuvikuljetin r) throws RemoteException {
		
	}
	
	public void varaaSiilo(Siilo s) throws RemoteException {
		
	}
	
	public void täytäJuomakeittimet(Ruuvikuljetin r) throws RemoteException {
		
	}
	
	public void varaaJuomakeitin(Juomakeitin j) throws RemoteException {
		
	}
	
	public void täytäKypsytyssäiliöt(Pumppu p) throws RemoteException {
		
	}
	
	public void varaaKypsytyssäiliö(Kypsytyssäiliö s) throws RemoteException {
		
	}
	
	public void pullota(Pumppu p) throws RemoteException {
		
	}
	
}
