package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinK‰ynnistys(int i) throws RemoteException;
	public void startKeittimienT‰ytin(int kuljetin) throws RemoteException;
	public void varaaSiilo(int siilo) throws RemoteException;
	public void varaaKeitin(int keitin) throws RemoteException;
	public void k‰ynnist‰Keitin(int keitin) throws RemoteException;
	public void k‰ynnist‰Pumppu(int keitin) throws RemoteException;
	public void k‰ynnist‰PullotusPumppu(int keitin) throws RemoteException;
	public void varaaS‰iliˆ(int keitin) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
}
