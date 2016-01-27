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
	// Käynnistää juomakeittimen
	public void juomakeitinKäynnistys(int i){
		juomakeitinArray[i].käynnistys();
	}
	// Käynnistää keittimet täyttävän ruuvikuljettimen
	public void startKeittimienTäytin(int kuljetin){
		System.out.println("Juomakeittimet täyttävä kuljetin "+kuljetin+" käynnistetty.");
	}
	// Varaa sillon
	public void varaaSiilo(int siilo){
		System.out.println("Siilo "+siilo+" varattu");
	}
	public void varaaKeitin(int keitin) {
		
	}
	public void käynnistäKeitin(int keitin) {
		
	}
	public void käynnistäPumppu(int keitin) {
		
	}
	public void käynnistäPullotusPumppu(int keitin) {
		
	}
	public void varaaSäiliö(int keitin) {
		
	}
}