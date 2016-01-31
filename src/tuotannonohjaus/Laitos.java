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
	private Kypsytyssäiliö[] kypsytyssäiliöA;
	private Pumppu [] pumppuArray2;
	private ArrayList<String[]> identifiers;


	public Laitos(Ruuvikuljetin a, Siilo[] siilot, Ruuvikuljetin[] b, Juomakeitin[] j, Pumppu[] p, Kypsytyssäiliö[] ks, Pumppu[] pl) throws RemoteException {
		ruuvi=a ;
		siiloArray=siilot;
		ruuviArray=b;
		juomakeitinArray = j;
		pumppuArray1=p;
		kypsytyssäiliöA =ks;
		pumppuArray2=pl;
		identifiers = new ArrayList<String[]>();
	}
	// Kirjaa käyttäjän sisään
	public String[] login(String nimi) {
		String[] identifier = new String[2];
		identifier[0] = nimi;
		identifier[1] = UUID.randomUUID().toString();
		System.out.println("Nimi: "+identifier[0]+" ID:"+identifier[1]);
		this.identifiers.add(identifier);
		return identifier;
	}
	// Kirjaa käyttäjän ulos
	public void logout(String[] identifier){
		for(String[] id : identifiers) {
			if(id[0].equals(identifier[0]) && id[1].equals(identifier[1])) {
				identifiers.remove(id);
				break;
			}
		}
	}	
	// Käynnistää juomakeittimen
	public void juomakeitinKäynnistys(int i, String[] ktj){
		if(ktj[0].equals(juomakeitinArray[i].getVaraaja()[0]) && ktj[1].equals(juomakeitinArray[i].getVaraaja()[1]) && !juomakeitinArray[i].getTäyttyy() && !juomakeitinArray[i].getTyhjenee()){
			juomakeitinArray[i].käynnistys();
		}
	}
	// Palauttaa asiakkaalle laitoksen statuksen
	public Laitos update() {
		return this;
	}

	// Käynnistää keittimet täyttävän ruuvikuljettimen
	public void startKeittimienTäytin(int kuljetin, int määrä, String[] käyttäjä){
		if(!ruuviArray[kuljetin].getKäytössä()){
			ArrayList<Siilo> siilot = new ArrayList<Siilo>();
			ArrayList<Juomakeitin> juomakeittimet = new ArrayList<Juomakeitin>();
			for(Siilo s : siiloArray){
				System.out.println("Siilon käyttäjä on "+s.getKäyttäjä());
				if(s.getKäyttäjä() != null && s.getKäyttäjä()[0].equals(käyttäjä[0]) && s.getKäyttäjä()[1].equals(käyttäjä[1])) {
					siilot.add(s);
				}
			}
			for(Juomakeitin j : juomakeitinArray) {
				if(j.getVaraaja() != null && j.getVaraaja()[0].equals(käyttäjä[0]) && j.getVaraaja()[1].equals(käyttäjä[1])) {
					juomakeittimet.add(j);
				}
			}
			ruuviArray[kuljetin].siirrä(siilot, määrä, juomakeittimet);
		}
	}
	// Varaa siilo
	public void varaaSiilo(int siilo, String[] v){
		System.out.println("Siilo "+siilo+" varattu");

		if(siiloArray[siilo].getKäyttäjä() == null){
			System.out.println("Varataan siilo henkilölle "+v);
			siiloArray[siilo].setKäyttäjä(v);
		}else{
			if(siiloArray[siilo].getKäyttäjä()[0].equals(v[0]) && siiloArray[siilo].getKäyttäjä()[1].equals(v[1])){
				siiloArray[siilo].poistaKäyttäjä();
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
	//Keitin käynnistys
	public void käynnistäKeitin(int keitin, String[] v) throws RemoteException {
		try{
			if(juomakeitinArray[keitin].getVaraaja() != null){
				if(juomakeitinArray[keitin].getProsessoi() == false ){
					if(juomakeitinArray[keitin].getRaaka() == juomakeitinArray[keitin].getRaakaMax()){
						juomakeitinArray[keitin].käynnistys();
					}else{
						System.out.println("Keittin "+keitin+ " ei ole täysi, ei voi käynnistää!");
						return;
					}	
				}else{
					System.out.println("Keittin "+keitin+" prosessoi jo, ei voi käynnistää!");
					return;
				}
			}else{
				System.out.println("Keittimen "+keitin+" varaaja ei ole "+v+", ei voi käynnistää!");
				return;
			}
		}catch(Exception e){
			System.out.println(e);
			return;
		}
	}
	@Override
	public void käynnistäPumppu(int pumppu, String[] käyttäjä) throws RemoteException {
		if(!pumppuArray1[pumppu].pumppaako()){
			ArrayList<Kypsytyssäiliö> säiliöt = new ArrayList<Kypsytyssäiliö>();
			for(Kypsytyssäiliö k : kypsytyssäiliöA){
				if(k.getKäyttäjä() != null && k.getKäyttäjä()[0].equals(käyttäjä[0]) && k.getKäyttäjä()[1].equals(käyttäjä[1])) {
					säiliöt.add(k);
				}
			}
			ArrayList<Juomakeitin> keittimet = new ArrayList<Juomakeitin>();
			for(Juomakeitin k : juomakeitinArray){
				if(k.getVaraaja() != null && k.getVaraaja()[0].equals(käyttäjä[0]) && k.getVaraaja()[1].equals(käyttäjä[1])) {
					keittimet.add(k);
				}
			}
			pumppuArray1[pumppu].start(keittimet, säiliöt);
		}
	}
	@Override
	public void käynnistäPullotusPumppu(int pumppu, String[] käyttäjä) throws RemoteException {
		if(!pumppuArray2[pumppu].pumppaako()){
			ArrayList<Kypsytyssäiliö> säiliöt = new ArrayList<Kypsytyssäiliö>();
			for(Kypsytyssäiliö k : kypsytyssäiliöA){
				if(k.getKäyttäjä() != null && k.getKäyttäjä()[0].equals(käyttäjä[0]) && k.getKäyttäjä()[1].equals(käyttäjä[1])) {
					säiliöt.add(k);
				}
			}
			pumppuArray2[pumppu].start(säiliöt);
		}
	}
	@Override
	public void varaaSäiliö(int säiliö, String[] käyttäjä) throws RemoteException {
		kypsytyssäiliöA[säiliö].setKäyttäjä(käyttäjä);
	}
	@Override
	public boolean siiloVarattu(int siilo) throws RemoteException {
		if(siiloArray[siilo].getKäyttäjä() != null){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public int siilonTäyttöaste(int siilo) throws RemoteException {
		return siiloArray[siilo].getTäyttö();
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
	public boolean säiliöTavaraSiirtyy(int säiliö) throws RemoteException {
		if(kypsytyssäiliöA[säiliö].isKäytössä()){
			return true;
		}
		else{
			return false;
		}
	}	
	@Override
	public boolean säiliöVarattu(int säiliö) throws RemoteException {
		if(kypsytyssäiliöA[säiliö].getKäyttäjä() == null){
			return false;
		}
		else{
			return true;
		}
	}
	@Override
	public int säiliönTäyttöaste(int säiliö) throws RemoteException {
		return kypsytyssäiliöA[säiliö].getTäyttöaste();
	}
	@Override
	public boolean siilonTäyttäjäKäynnissä() throws RemoteException {
		return ruuvi.getKäytössä();
	}
	@Override
	public void startSiilojenTäytin(String[] käyttäjä) throws RemoteException {
		if(!ruuvi.getKäytössä()){
			System.out.println("Siilojentäytin start");
			ArrayList<Siilo> ks = new ArrayList<Siilo>();
			int max = 0;
			for(Siilo s : siiloArray){
				if(s.getKäyttäjä() != null) {
					ks.add(s);
					max += s.getTäyttökatto()-s.getTäyttö();
				}
			}
			ruuvi.siirrä(ks, max, null);
		}
	}
	@Override
	public boolean keittimenKäyttäjäKäynnissä(int i) throws RemoteException {
		return ruuviArray[i].getKäytössä();
	}
	@Override
	public boolean pumppuKäytössä(int pumppu) throws RemoteException {
		return pumppuArray1[pumppu].pumppaako();
	}
	@Override
	public boolean pullotusPumppuKäytössä(int pumppu) throws RemoteException {
		return pumppuArray2[pumppu].pumppaako();
	}
	@Override
	public int keittimenTäyttöaste(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getRaaka();
	}
	@Override
	public String[] keittimenKäyttäjä(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getVaraaja();
	}
	@Override
	public boolean keitinTäytyy(int keitin) throws RemoteException {
		return juomakeitinArray[keitin].getTäyttyy();
	}
	@Override
	public boolean keitinValmis(int keitin) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
}