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
<<<<<<< Updated upstream
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
		
=======
	// K�ynnist�� juomakeittimen
	public void juomakeitinK�ynnistys(int i){
		juomakeitinArray[i].k�ynnistys();
>>>>>>> Stashed changes
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
	//Keitin k�ynnistys
	public void k�ynnist�Keitin(int keitin, String[] v) {
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
	}
	public void k�ynnist�Pumppu(int pumppu,String[] v) {
		
	}
	public void k�ynnist�PullotusPumppu(int pumppu) {
		
	}
	public void varaaS�ili�(int s�ili�) {
		
	}
	@Override
	public void k�ynnist�Keitin(int keitin, String[] k�ytt�j�) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void k�ynnist�Pumppu(int pumppu, String[] k�ytt�j�) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void k�ynnist�PullotusPumppu(int pumppu, String[] k�ytt�j�) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void varaaS�ili�(int s�ili�, String[] k�ytt�j�) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean siiloT�yttyy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean siiloVarattu() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int siilonT�ytt�aste() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean keitinT�ytyy() throws RemoteException {
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
	public boolean s�ili�T�yttyy() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean s�ili�Varattu() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int s�ili�nT�ytt�aste() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean pullotusK�ynniss�() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Laitos update() throws RemoteException {
		// TODO Auto-generated method stub
		return this;
	}
}