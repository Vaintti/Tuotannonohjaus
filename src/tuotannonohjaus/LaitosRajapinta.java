package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinKäynnistys(int i) throws RemoteException;
	public void startKeittimienTäytin(int kuljetin) throws RemoteException;
	public void varaaSiilo(int siilo) throws RemoteException;
	public void varaaKeitin(int keitin) throws RemoteException;
	public void käynnistäKeitin(int keitin) throws RemoteException;
	public void käynnistäPumppu(int keitin) throws RemoteException;
	public void käynnistäPullotusPumppu(int keitin) throws RemoteException;
	public void varaaSäiliö(int keitin) throws RemoteException;
}
