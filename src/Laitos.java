
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
	
	public Laitos(Ruuvikuljetin a, Siilo[] siilot, Ruuvikuljetin[] b, Juomakeitin[] j, Pumppu[] p, Kypsytyss�ili�[] ks, Pumppu[] pl) throws RemoteException {
		
	}
	
	public void testi(){
		System.out.println("Onnistunut et�kutsu");
	}
	public void juomakeitinK�ynnistys(int i){
		Juomakeitin[i].k�ynnistys;
	}
}