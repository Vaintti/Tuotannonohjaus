package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinKäynnistys(int i) throws RemoteException;
	public void startKeittimienTäytin(int kuljetin, int määrä, String[] käyttäjä) throws RemoteException;
	public void varaaSiilo(int siilo) throws RemoteException;
	public void varaaKeitin(int keitin) throws RemoteException;
	public void käynnistäKeitin(int keitin) throws RemoteException;
	public void käynnistäPumppu(int keitin) throws RemoteException;
	public void käynnistäPullotusPumppu(int keitin) throws RemoteException;
	public void varaaSäiliö(int keitin) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
	public Laitos update() throws RemoteException;
	public boolean siiloTäyttyy() throws RemoteException;
	public boolean siiloVarattu() throws RemoteException;
	public int siilonTäyttöaste() throws RemoteException;
	public boolean keitinTäytyy() throws RemoteException;
	public boolean keitinVarattu() throws RemoteException;
	public boolean keitinProsessoi() throws RemoteException;
	public boolean säiliöTäyttyy() throws RemoteException;
	public boolean säiliöVarattu() throws RemoteException;
	public int säiliönTäyttöaste() throws RemoteException;
	public boolean pullotusKäynnissä() throws RemoteException;
}
