package tuotannonohjaus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Laitos extends UnicastRemoteObject implements LaitosRajapinta{
	private Ruuvikuljetin ruuvi;
	private Siilo[] siiloArray;
	private Ruuvikuljetin[] ruuviArray;
	private Juomakeitin[] juomakeitinArray;
	private Pumppu [] pumppuArray1;
	private Kypsytyss�ili�[] kypsytyss�ili�A;
	private Pumppu [] pumppuArray2;
	private ArrayList<String[]> identifiers;
	
	
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
	public String[] login(String nimi) {
		String[] identifier = new String[2];
		identifier[0] = nimi;
		identifier[1] = UUID.randomUUID().toString(); 
		this.identifiers.add(identifier);
		return identifier;
	}
	public void logout(String[] identifier){
		for(String[] id : identifiers) {
			if(id[0] == identifier[0] && id[1] == identifier[1]) {
				identifiers.remove(id);
				break;
			}
		}
	}
	// K�ynnist�� juomakeittimen
	public void juomakeitinK�ynnistys(int i){
		juomakeitinArray[i].k�ynnistys();
	}
	// K�ynnist�� keittimet t�ytt�v�n ruuvikuljettimen
	public void startKeittimienT�ytin(int kuljetin){
		System.out.println("Juomakeittimet t�ytt�v� kuljetin "+kuljetin+" k�ynnistetty.");
	}
	// Varaa sillon
	public void varaaSiilo(int siilo, String[] v){
		System.out.println("Siilo "+siilo+" varattu");
		if(siiloArray[siilo].getK�yt�ss�() == true){
			return;
		}else{
			if(siiloArray[siilo].getK�ytt�j�() == null){
				if(siiloArray[siilo].getK�ytt�j�() == v){
					siiloArray[siilo].poistaK�ytt�j�();
				}else{
					return;
				}
			}else{
				siiloArray[siilo].setK�ytt�j�(v);
			}
		}
	}
	// Varaa keitin
	public void varaaKeitin(int keitin, String[] v) {
		System.out.println("Keitin "+keitin+" varattu");
		if(juomakeitinArray[keitin].getProsessoi() == true){
			return;
		}else{
			if(juomakeitinArray[keitin].getVaraaja() == null){
				if(juomakeitinArray[keitin].getVaraaja() == v){
					juomakeitinArray[keitin].resetVaraaja();
				}else{
					return;
				}
			}else{
				juomakeitinArray[keitin].setVaraaja(v);
			}
		}
	}
	public void k�ynnist�Keitin(int keitin) {
		
	}
	public void k�ynnist�Pumppu(int keitin) {
		
	}
	public void k�ynnist�PullotusPumppu(int keitin) {
		
	}
	public void varaaS�ili�(int keitin) {
		
	}
}