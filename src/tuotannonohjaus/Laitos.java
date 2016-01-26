package tuotannonohjaus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
	private Ruuvikuljetin ruuvi;
	private Siilo[] siiloArray;
	private Ruuvikuljetin[] ruuviArray;
	private Juomakeitin[] juomakeitinArray;
	private Pumppu [] pumppuArray1;
	private Kypsytyss�ili�[] kypsytyss�ili�A;
	private Pumppu [] pumppuArray2;
	
	
	
	public Laitos(Ruuvikuljetin a, Siilo[] siilot, Ruuvikuljetin[] b, Juomakeitin[] j, Pumppu[] p, Kypsytyss�ili�[] ks, Pumppu[] pl) throws RemoteException {
		ruuvi=a ;
		siiloArray=siilot;
		ruuviArray=b;
		juomakeitinArray = j;
		pumppuArray1=p;
		kypsytyss�ili�A =ks;
		pumppuArray2=pl;
	}
	// Testimetodi
	public void testi(){
		System.out.println("Onnistunut et�kutsu");
	}
	// K�ynnist�� juomakeittimen
	public void juomakeitinK�ynnistys(int i){
		juomakeitinArray[i].k�ynnistys();
	}
	// K�ynnist�� keittimet t�ytt�v�n ruuvikuljettimen
	public void startKeittimienT�ytin(int kuljetin){
		
	}
	// Varaa sillon
	public void varaaSiilo(int siilo){
		
	}
}