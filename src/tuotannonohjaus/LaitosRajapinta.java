package tuotannonohjaus;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaitosRajapinta extends Remote {
	public void testi() throws RemoteException;
	public void juomakeitinK�ynnistys(int i) throws RemoteException;
	public void siilo(int x) throws RemoteException;
}
