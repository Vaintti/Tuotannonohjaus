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
	}
	// Testimetodi
	public void testi(){
		System.out.println("Onnistunut etäkutsu");
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
	// Palauttaa täyttääkö kuljetin siiloa tällä hetkellä
	public boolean siiloTäyttyy(int siilo) {
	}
	// Palauttaa onko siilo varattu
	public boolean siiloVarattu(int siilo) {
		
	}
	// Palauttaa siilon tämänhetkisen täyttöasteen
	public int siilonTäyttöaste(int siilo) {
		
	}
	// Palauttaa täyttääkö kuljetin keitintä
	public boolean keitinTäytyy(int keitin) {
		
	}
	// Palauttaa onko keitin varattu
	public boolean keitinVarattu(int keitin) {
		
	}
	// Palauttaa prosessoiko keitin juomaa tällä hetkellä
	public boolean keitinProsessoi(int keitin) {
		
	}
	// Palauttaa täyttyykö säiliö tällä hetkellä
	public boolean säiliöTäyttyy(int säiliö) {
		
	}
	// Palauttaa onko säiliö varattu
	public boolean säiliöVarattu(int säiliö) {
		
	}
	// Palautaa säiliön tämänhetkisen täyttöasteen
	public int säiliönTäyttöaste(int säiliö) {
		
	}
	// Palauttaa pullotuspumpun käyttöstatuksen
	public boolean pullotusKäynnissä() {
		
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
	// Varaa sillon
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
	public void käynnistäKeitin(int keitin) {
		
	}
	public void käynnistäPumppu(int pumppu) {
		
	}
	public void käynnistäPullotusPumppu(int pumppu) {
		
	}
	public void varaaSäiliö(int säiliö) {
		
	}
}