package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinK�ynnistys(int i) throws RemoteException;
	public void startKeittimienT�ytin(int kuljetin, int m��r�, String[] k�ytt�j�) throws RemoteException;
	public void varaaSiilo(int siilo, String[] k�ytt�j�) throws RemoteException;
	public void varaaKeitin(int keitin, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�Keitin(int keitin, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�Pumppu(int pumppu, String[] k�ytt�j�) throws RemoteException;
	public void k�ynnist�PullotusPumppu(int pumppu, String[] k�ytt�j�) throws RemoteException;
	public void varaaS�ili�(int s�ili�, String[] k�ytt�j�) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
	public Laitos update() throws RemoteException;
	public boolean siiloT�yttyy() throws RemoteException;
	public boolean siiloVarattu() throws RemoteException;
	public int siilonT�ytt�aste() throws RemoteException;
	public boolean keitinT�ytyy() throws RemoteException;
	public boolean keitinVarattu() throws RemoteException;
	public boolean keitinProsessoi() throws RemoteException;
	public boolean s�ili�T�yttyy() throws RemoteException;
	public boolean s�ili�Varattu() throws RemoteException;
	public int s�ili�nT�ytt�aste() throws RemoteException;
	public boolean pullotusK�ynniss�() throws RemoteException;
}
