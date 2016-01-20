
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
	
	public Laitos(Ruuvikuljetin a, Siilo[] siilot, Ruuvikuljetin[] b, Juomakeitin[] j, Pumppu[] p, Kypsytyssäiliö[] ks, Pumppu[] pl) throws RemoteException {
		
	}
	
	public void testi(){
		System.out.println("Onnistunut etäkutsu");
	}
	public void juomakeitinKäynnistys(int i){
		Juomakeitin[i].käynnistys;
	}
}