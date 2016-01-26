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
	
	public void testi(){
		System.out.println("Onnistunut et�kutsu");
	}
	public void juomakeitinK�ynnistys(int i){
		juomakeitinArray[i].k�ynnistys();
	}
	public void siilo(int i){
		
	}
}