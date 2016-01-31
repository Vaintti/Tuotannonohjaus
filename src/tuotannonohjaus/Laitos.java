package tuotannonohjaus;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
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
	// Kirjaa k�ytt�j�n sis��n
	public String[] login(String nimi) {
		String[] identifier = new String[2];
		identifier[0] = nimi;
		identifier[1] = UUID.randomUUID().toString();
		System.out.println("Nimi: "+identifier[0]+" ID:"+identifier[1]);
		this.identifiers.add(identifier);
		return identifier;
	}
	// Kirjaa k�ytt�j�n ulos
	public void logout(String[] identifier){
		for(String[] id : identifiers) {
			if(id[0].equals(identifier[0]) && id[1].equals(identifier[1])) {
				identifiers.remove(id);
				break;
			}
		}
	}	
	// K�ynnist�� juomakeittimen
	public void juomakeitinK�ynnistys(int i, String[] ktj){
		if(ktj[0].equals(juomakeitinArray[i].getVaraaja()[0]) && ktj[1].equals(juomakeitinArray[i].getVaraaja()[1]) && !juomakeitinArray[i].getT�yttyy() && !juomakeitinArray[i].getTyhjenee()){
			juomakeitinArray[i].k�ynnistys();
		}
	}
	// Palauttaa asiakkaalle laitoksen statuksen
	public Laitos update() {
		return this;
	}

	// K�ynnist�� keittimet t�ytt�v�n ruuvikuljettimen
	public void startKeittimienT�ytin(int kuljetin, int m��r�, String[] k�ytt�j�){
		if(!ruuviArray[kuljetin].getK�yt�ss�()){
			ArrayList<Siilo> siilot = new ArrayList<Siilo>();
			ArrayList<Juomakeitin> juomakeittimet = new ArrayList<Juomakeitin>();
			for(Siilo s : siiloArray){
				System.out.println("Siilon k�ytt�j� on "+s.getK�ytt�j�());
				if(s.getK�ytt�j�() != null && s.getK�ytt�j�()[0].equals(k�ytt�j�[0]) && s.getK�ytt�j�()[1].equals(k�ytt�j�[1])) {
					siilot.add(s);
				}
			}
			for(Juomakeitin j : juomakeitinArray) {
				if(j.getVaraaja() != null && j.getVaraaja()[0].equals(k�ytt�j�[0]) && j.getVaraaja()[1].equals(k�ytt�j�[1])) {
					juomakeittimet.add(j);
				}
			}
			ruuviArray[kuljetin].siirr�(siilot, m��r�, juomakeittimet);
		}
	}
	// Varaa siilo
	public void varaaSiilo(int siilo, String[] v){
		System.out.println("Siilo "+siilo+" varattu");

		if(siiloArray[siilo].getK�ytt�j�() == null){
			System.out.println("Varataan siilo henkil�lle "+v);
			siiloArray[siilo].setK�ytt�j�(v);
		}else{
			if(siiloArray[siilo].getK�ytt�j�()[0].equals(v[0]) && siiloArray[siilo].getK�ytt�j�()[1].equals(v[1])){
				siiloArray[siilo].poistaK�ytt�j�();
				System.out.println("Poistetaan siilon varaus ");
			}else{
				return;
			}
		}

	}
	// Varaa keitin
	public void varaaKeitin(int keitin, String[] v) {
		if(juomakeitinArray[keitin].getProsessoi() == true){
			System.out.println("Keitin "+keitin+" prosessoi. Ei voida varata.");
			return;
		}else{
			if(juomakeitinArray[keitin].getVaraaja() == null){
				juomakeitinArray[keitin].setVaraaja(v);
				System.out.println("Keitin "+keitin+" varattu. Varaaja on nyt "+v[0]);
			}else{
				if(juomakeitinArray[keitin].getVaraaja()[0].equals(v[0]) && juomakeitinArray[keitin].getVaraaja()[1].equals(v[1])){
					System.out.println("Keitin "+keitin+" poistettu varauksesta.");
					juomakeitinArray[keitin].resetVaraaja();
				}else{
					return;
				}
			}
		}
	}
	//Keitin k�ynnistys
	public void k�ynnist�Keitin(int keitin, String[] v) throws RemoteException {
		try{
			if(juomakeitinArray[keitin].getVaraaja() != null){
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
		if(!pumppuArray1[pumppu].pumppaako()){
			ArrayList<Kypsytyss�ili�> s�ili�t = new ArrayList<Kypsytyss�ili�>();
			for(Kypsytyss�ili� k : kypsytyss�ili�A){
				if(k.getK�ytt�j�() != null && k.getK�ytt�j�()[0].equals(k�ytt�j�[0]) && k.getK�ytt�j�()[1].equals(k�ytt�j�[1])) {
					s�ili�t.add(k);
				}
			}
			ArrayList<Juomakeitin> keittimet = new ArrayList<Juomakeitin>();
			for(Juomakeitin k : juomakeitinArray){
				if(k.getVaraaja() != null && k.getVaraaja()[0].equals(k�ytt�j�[0]) && k.getVaraaja()[1].equals(k�ytt�j�[1])) {
					keittimet.add(k);
				}
			}
			pumppuArray1[pumppu].start(keittimet, s�ili�t);
		}
	}
	@Override
	public void k�ynnist�PullotusPumppu(int pumppu, String[] k�ytt�j�) throws RemoteException {
		if(!pumppuArray2[pumppu].pumppaako()){
			ArrayList<Kypsytyss�ili�> s�ili�t = new ArrayList<Kypsytyss�ili�>();
			for(Kypsytyss�ili� k : kypsytyss�ili�A){
				if(k.getK�ytt�j�() != null && k.getK�ytt�j�()[0].equals(k�ytt�j�[0]) && k.getK�ytt�j�()[1].equals(k�ytt�j�[1])) {
					s�ili�t.add(k);
				}
			}
			pumppuArray2[pumppu].start(s�ili�t);
		}
	}
	@Override
	public void varaaS�ili�(int s�ili�, String[] k�ytt�j�) throws RemoteException {
		kypsytyss�ili�A[s�ili�].setK�ytt�j�(k�ytt�j�);
	}
	@Override
	public boolean siiloVarattu(int siilo) throws RemoteException {
		if(siiloArray[siilo].getK�ytt�j�() != null){
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
	public boolean siilonT�ytt�j�K�ynniss�() throws RemoteException {
		return ruuvi.getK�yt�ss�();
	}
	@Override
	public void startSiilojenT�ytin(String[] k�ytt�j�) throws RemoteException {
		if(!ruuvi.getK�yt�ss�()){
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
	}
	@Override
	public boolean keittimenK�ytt�j�K�ynniss�(int i) throws RemoteException {
		return ruuviArray[i].getK�yt�ss�();
	}
	@Override
	public boolean pumppuK�yt�ss�(int pumppu) throws RemoteException {
		return pumppuArray1[pumppu].pumppaako();
	}
	@Override
	public boolean pullotusPumppuK�yt�ss�(int pumppu) throws RemoteException {
		return pumppuArray2[pumppu].pumppaako();
	}
	@Override
	public int keittimenT�ytt�aste(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getRaaka();
	}
	@Override
	public String[] keittimenK�ytt�j�(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getVaraaja();
	}
	@Override
	public boolean keitinT�ytyy(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getT�yttyy();
	}
	@Override
	public boolean keitinValmis(int keitin) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}