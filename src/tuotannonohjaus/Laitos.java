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
	// Testimetodi
	public void testi(){
		System.out.println("Onnistunut etäkutsu");
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
	// Käynnistää juomakeittimen
	public void juomakeitinKäynnistys(int i){
		juomakeitinArray[i].käynnistys();
	}
	// Käynnistää keittimet täyttävän ruuvikuljettimen
	public void startKeittimienTäytin(int kuljetin, int määrä, String[] käyttäjä){
		ArrayList<Siilo> siilot = new ArrayList<Siilo>();
		ArrayList<Juomakeitin> juomakeittimet = new ArrayList<Juomakeitin>();
		for(Siilo s : siiloArray){
			if(s.getKäyttäjä()==käyttäjä) {
				siilot.add(s);
			}
		}
		for(Juomakeitin j : juomakeitinArray) {
			if(j.getVaraaja()==käyttäjä) {
				juomakeittimet.add(j);
			}
		}
		ruuviArray[kuljetin].siirrä(siilot, määrä, juomakeittimet);
	}
	// Varaa siilo
	public void varaaSiilo(int siilo, String[] v){
		System.out.println("Siilo "+siilo+" varattu");
		if(siiloArray[siilo].getKäytössä() == true){
			return;
		}else{
			if(siiloArray[siilo].getKäyttäjä() == null){
				if(siiloArray[siilo].getKäyttäjä() == v){
					siiloArray[siilo].poistaKäyttäjä();
				}else{
					return;
				}
			}else{
				siiloArray[siilo].setKäyttäjä(v);
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
	//Keitin käynnistys
	public void käynnistäKeitin(int keitin, String[] v) {
		if(juomakeitinArray[keitin].getVaraaja() == v){
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
	}
	@Override
	public void käynnistäPullotusPumppu(int pumppu, String[] käyttäjä) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void varaaSäiliö(int säiliö, String[] käyttäjä) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean siiloTäyttyy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean siiloVarattu() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int siilonTäyttöaste() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean keitinTäytyy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keitinVarattu() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keitinProsessoi() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean säiliöTäyttyy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean säiliöVarattu() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int säiliönTäyttöaste() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean pullotusKäynnissä() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Laitos update() throws RemoteException {
		// TODO Auto-generated method stub
		return this;
	}
	@Override
	public void käynnistäPumppu(int pumppu, String[] käyttäjä) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
}