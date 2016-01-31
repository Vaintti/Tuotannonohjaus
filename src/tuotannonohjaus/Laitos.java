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
		identifiers = new ArrayList<String[]>();
	}
	// Testimetodi
	public void testi(){
		System.out.println("Onnistunut et�kutsu");
	}
	public String[] login(String nimi) {
		System.out.println(this);
		String[] identifier = new String[2];
		System.out.println(identifier[0]+identifier[1]);
		identifier[0] = nimi;
		System.out.println(identifier[0]+identifier[1]);
		identifier[1] = UUID.randomUUID().toString();
		System.out.println(identifier[0]+identifier[1]);
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
	public void juomakeitinK�ynnistys(int i, String[] ktj){
		if(ktj == juomakeitinArray[i].getVaraaja()){
			juomakeitinArray[i].k�ynnistys();
		}
	}
	// Palauttaa asiakkaalle laitoksen statuksen
	public Laitos update() {
		return this;
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
	// Varaa siilo
	public void varaaSiilo(int siilo, String[] v){
		System.out.println("Siilo "+siilo+" varattu");
		if(siiloArray[siilo].getK�yt�ss�()){
			return;
		}else{
			if(siiloArray[siilo].getK�ytt�j�() == null){
				siiloArray[siilo].setK�ytt�j�(v);
			}else{
				if(siiloArray[siilo].getK�ytt�j�() == v){
					siiloArray[siilo].poistaK�ytt�j�();
				}else{
					return;
				}
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
	//Keitin k�ynnistys
	public void k�ynnist�Keitin(int keitin, String[] v) throws RemoteException {
		try{
			if(juomakeitinArray[keitin].getVaraaja() == v){
				if(juomakeitinArray[keitin].getProsessoi() == false ){
					if(juomakeitinArray[keitin].getRaaka() == juomakeitinArray[keitin].getRaakaMax()){
						juomakeitinArray[keitin].k�ynnistys();
					}else{
						System.out.println("Keittin "+keitin+ " ei ole t�ysi, ei voi k�ynnist��!");
						return;
					}	
				}else{
					System.out.println("Keittin "+keitin+" prosessoi jo, ei voi k�ynnist��!");
					return;
				}
			}else{
				System.out.println("Keittimen "+keitin+" varaaja ei ole "+v+", ei voi k�ynnist��!");
				return;
			}
		}catch(Exception e){
			System.out.println(e);
			return;
		}
	}
	@Override
	public void k�ynnist�Pumppu(int pumppu, String[] k�ytt�j�) throws RemoteException {


	}
	@Override
	public void k�ynnist�PullotusPumppu(int pumppu, String[] k�ytt�j�) throws RemoteException {
		if(k�ytt�j� == pumppuArray2[pumppu].getK�ytt�j�()) {
			pumppuArray2[pumppu].start();
		}
	}
	@Override
	public void varaaS�ili�(int s�ili�, String[] k�ytt�j�) throws RemoteException {
		// TODO Auto-generated method stub

	}
	@Override
	public boolean siiloVarattu(int siilo) throws RemoteException {
		if(siiloArray[siilo].getK�yt�ss�()){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public int siilonT�ytt�aste(int siilo) throws RemoteException {
		return siiloArray[siilo].getT�ytt�();
	}
	@Override
	public boolean keitinVarattu(int keitin) throws RemoteException {
		if(juomakeitinArray[keitin].getVaraaja() == null){
			return false;
		}
		else{
			return true;
		}
	}
	@Override
	public boolean keitinProsessoi(int keitin) throws RemoteException {
		if(juomakeitinArray[keitin].getProsessoi()){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public boolean s�ili�TavaraSiirtyy(int s�ili�) throws RemoteException {
		if(kypsytyss�ili�A[s�ili�].isK�yt�ss�()){
			return true;
		}
		else{
			return false;
		}
	}	
	@Override
	public boolean s�ili�Varattu(int s�ili�) throws RemoteException {
		if(kypsytyss�ili�A[s�ili�].getK�ytt�j�() == null){
			return false;
		}
		else{
			return true;
		}
	}
	@Override
	public int s�ili�nT�ytt�aste(int s�ili�) throws RemoteException {
		return kypsytyss�ili�A[s�ili�].getT�ytt�aste();
	}
	@Override
	public boolean pullotusK�ynniss�() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean siiloTavaraSiirtyy(int siilo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keitinTavaraSiirtyy(int keitin) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean siilonT�ytt�j�K�ynniss�() throws RemoteException {
		return ruuvi.getK�yt�ss�();
	}
	@Override
	public void startSiilojenT�ytin(String[] k�ytt�j�) throws RemoteException {
		System.out.println("Siilojent�ytin start");
		ArrayList<Siilo> ks = new ArrayList<Siilo>();
		int max = 0;
		for(Siilo s : siiloArray){
			if(s.getK�ytt�j�() != null) {
				ks.add(s);
				max += s.getT�ytt�katto()-s.getT�ytt�();
			}
		}
		ruuvi.siirr�(ks, max, null);
	}
	@Override
	public boolean keittimenK�ytt�j�K�ynniss�(int i) throws RemoteException {
		return ruuviArray[i].getK�yt�ss�();
	}

}