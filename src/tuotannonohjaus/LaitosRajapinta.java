package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinKäynnistys(int i) throws RemoteException;
	public void startKeittimienTäytin(int kuljetin) throws RemoteException;
	public void varaaSiilo(int siilo) throws RemoteException;
}
