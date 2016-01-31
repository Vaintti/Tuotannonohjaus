package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void juomakeitinKäynnistys(int i, String[] käytttäjä) throws RemoteException;
	public void startKeittimienTäytin(int kuljetin, int määrä, String[] käyttäjä) throws RemoteException;
	public void startSiilojenTäytin(String[] käyttäjä) throws RemoteException;
	public void varaaSiilo(int siilo, String[] käyttäjä) throws RemoteException;
	public void varaaKeitin(int keitin, String[] käyttäjä) throws RemoteException;
	public void käynnistäKeitin(int keitin, String[] käyttäjä) throws RemoteException;
	public void käynnistäPumppu(int pumppu, String[] käyttäjä) throws RemoteException;
	public void käynnistäPullotusPumppu(int pumppu, String[] käyttäjä) throws RemoteException;
	public void varaaSäiliö(int säiliö, String[] käyttäjä) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
	public Laitos update() throws RemoteException;
	public boolean siiloVarattu(int siilo) throws RemoteException;
	public int siilonTäyttöaste(int siilo) throws RemoteException;
	public boolean keitinVarattu(int keitin) throws RemoteException;
	public boolean keitinProsessoi(int keitin) throws RemoteException;
	public boolean säiliöTavaraSiirtyy(int säiliö) throws RemoteException;
	public boolean säiliöVarattu(int säiliö) throws RemoteException;
	public int säiliönTäyttöaste(int säiliö) throws RemoteException;
	public boolean siilonTäyttäjäKäynnissä() throws RemoteException;
	public boolean keittimenKäyttäjäKäynnissä(int i) throws RemoteException;
	public boolean pumppuKäytössä(int pumppu) throws RemoteException;
	public boolean pullotusPumppuKäytössä(int pumppu) throws RemoteException;
	public int keittimenTäyttöaste(int keitin) throws RemoteException;
	public String[] keittimenKäyttäjä(int keitin) throws RemoteException;
}
