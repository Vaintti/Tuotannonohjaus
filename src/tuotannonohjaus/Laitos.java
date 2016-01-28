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
	// Palauttaa asiakkaalle laitoksen statuksen
	public Laitos update() {
		return this;
	}
	// Palauttaa t�ytt��k� kuljetin siiloa t�ll� hetkell�
	public boolean siiloT�yttyy(int siilo) {
	}
	// Palauttaa onko siilo varattu
	public boolean siiloVarattu(int siilo) {
		
	}
	// Palauttaa siilon t�m�nhetkisen t�ytt�asteen
	public int siilonT�ytt�aste(int siilo) {
		
	}
	// Palauttaa t�ytt��k� kuljetin keitint�
	public boolean keitinT�ytyy(int keitin) {
		
	}
	// Palauttaa onko keitin varattu
	public boolean keitinVarattu(int keitin) {
		
	}
	// Palauttaa prosessoiko keitin juomaa t�ll� hetkell�
	public boolean keitinProsessoi(int keitin) {
		
	}
	// Palauttaa t�yttyyk� s�ili� t�ll� hetkell�
	public boolean s�ili�T�yttyy(int s�ili�) {
		
	}
	// Palauttaa onko s�ili� varattu
	public boolean s�ili�Varattu(int s�ili�) {
		
	}
	// Palautaa s�ili�n t�m�nhetkisen t�ytt�asteen
	public int s�ili�nT�ytt�aste(int s�ili�) {
		
	}
	// Palauttaa pullotuspumpun k�ytt�statuksen
	public boolean pullotusK�ynniss�() {
		
	}
	// K�ynnist�� juomakeittimen
	public void juomakeitinK�ynnistys(int i){
		juomakeitinArray[i].k�ynnistys();
	}
	// K�ynnist�� keittimet t�ytt�v�n ruuvikuljettimen
	public void startKeittimienT�ytin(int kuljetin, int m��r�, String[] k�ytt�j�){
		ArrayList<Siilo> siilot = new ArrayList<Siilo>();
		ArrayList<Juomakeitin> juomakeittimet = new ArrayList<Juomakeitin>();
		for(Siilo s : siiloArray){
			if(s.getK�ytt�j�()==k�ytt�j�) {
				siilot.add(s);
			}
		}
		for(Juomakeitin j : juomakeitinArray) {
			if(j.getVaraaja()==k�ytt�j�) {
				juomakeittimet.add(j);
			}
		}
		ruuviArray[kuljetin].siirr�(siilot, m��r�, juomakeittimet);
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
	public void k�ynnist�Pumppu(int pumppu) {
		
	}
	public void k�ynnist�PullotusPumppu(int pumppu) {
		
	}
	public void varaaS�ili�(int s�ili�) {
		
	}
}