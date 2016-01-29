package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public boolean juomakeitinKäynnistys(int i) throws RemoteException;
	public boolean startKeittimienTäytin(int kuljetin, int määrä, String[] käyttäjä) throws RemoteException;
	public boolean varaaSiilo(int siilo, String[] käyttäjä) throws RemoteException;
	public boolean varaaKeitin(int keitin, String[] käyttäjä) throws RemoteException;
	public boolean käynnistäKeitin(int keitin, String[] käyttäjä) throws RemoteException;
	public boolean käynnistäPumppu(int pumppu, String[] käyttäjä) throws RemoteException;
	public boolean käynnistäPullotusPumppu(int pumppu, String[] käyttäjä) throws RemoteException;
	public boolean varaaSäiliö(int säiliö, String[] käyttäjä) throws RemoteException;
	public String[] login(String nimi) throws RemoteException;
	public void logout(String[] id) throws RemoteException;
	public Laitos update() throws RemoteException;
	public boolean siiloTäyttyy(int siilo) throws RemoteException;
	public boolean siiloVarattu(int siilo) throws RemoteException;
	public int siilonTäyttöaste(int siilo) throws RemoteException;
	public boolean keitinTäytyy(int keitin) throws RemoteException;
	public boolean keitinVarattu(int keitin) throws RemoteException;
	public boolean keitinProsessoi(int keitin) throws RemoteException;
	public boolean säiliöTäyttyy(int säiliö) throws RemoteException;
	public boolean säiliöVarattu(int säiliö) throws RemoteException;
	public int säiliönTäyttöaste(int säiliö) throws RemoteException;
	public boolean pullotusKäynnissä() throws RemoteException;
}
