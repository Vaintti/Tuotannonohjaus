import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Juomamestari extends Remote {
	
	public void t�yt�Siilot(Ruuvikuljetin r) throws RemoteException;
	
	public void varaaSiilo(Siilo s) throws RemoteException;
	
	public void t�yt�Juomakeittimet(Ruuvikuljetin r) throws RemoteException;
	
	public void varaaJuomakeitin(Juomakeitin j) throws RemoteException;
	
	public void t�yt�Kypsytyss�ili�t(Pumppu p) throws RemoteException;
	
	public void varaaKypsytyss�ili�(Kypsytyss�ili� s) throws RemoteException;
	
	public void pullota(Pumppu p) throws RemoteException;
	
}
