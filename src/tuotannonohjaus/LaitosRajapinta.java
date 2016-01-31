package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void juomakeitinK�ynnistys(int i, String[] k�yttt�j�) throws RemoteException;
	public void startKeittimienT�ytin(int kuljetin, int m��r�, String[] k�ytt�j�) throws RemoteException;
	public void startSiilojenT�ytin(String[] k�ytt�j�) throws RemoteException;
	public void varaaSiilo(int siilo, String[] k�ytt�j�) throws RemoteException;
	public void varaaKeitin(int keitin, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�Keitin(int keitin, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�Pumppu(int pumppu, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�PullotusPumppu(int pumppu, String[] k�ytt�j�) throws RemoteException;
	public void varaaS�ili�(int s�ili�, String[] k�ytt�j�) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
	public Laitos update() throws RemoteException;
	public boolean siiloVarattu(int siilo) throws RemoteException;
	public int siilonT�ytt�aste(int siilo) throws RemoteException;
	public boolean keitinVarattu(int keitin) throws RemoteException;
	public boolean keitinProsessoi(int keitin) throws RemoteException;
	public boolean s�ili�TavaraSiirtyy(int s�ili�) throws RemoteException;
	public boolean s�ili�Varattu(int s�ili�) throws RemoteException;
	public int s�ili�nT�ytt�aste(int s�ili�) throws RemoteException;
	public boolean siilonT�ytt�j�K�ynniss�() throws RemoteException;
	public boolean keittimenK�ytt�j�K�ynniss�(int i) throws RemoteException;
	public boolean pumppuK�yt�ss�(int pumppu) throws RemoteException;
	public boolean pullotusPumppuK�yt�ss�(int pumppu) throws RemoteException;
	public int keittimenT�ytt�aste(int keitin) throws RemoteException;
	public String[] keittimenK�ytt�j�(int keitin) throws RemoteException;
}
