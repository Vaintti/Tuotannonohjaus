import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Juomamestari extends Remote {
	
	public void täytäSiilot(Ruuvikuljetin r) throws RemoteException;
	
	public void varaaSiilo(Siilo s) throws RemoteException;
	
	public void täytäJuomakeittimet(Ruuvikuljetin r) throws RemoteException;
	
	public void varaaJuomakeitin(Juomakeitin j) throws RemoteException;
	
	public void täytäKypsytyssäiliöt(Pumppu p) throws RemoteException;
	
	public void varaaKypsytyssäiliö(Kypsytyssäiliö s) throws RemoteException;
	
	public void pullota(Pumppu p) throws RemoteException;
	
}
