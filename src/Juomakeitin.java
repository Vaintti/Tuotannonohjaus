
public class Juomakeitin {

	private String varaaja;
	private int tilavuusVesi;
	private final int VESIMAX;
	private int tilavuusRaakaaine;
	private final int RAAKAMAX;
	private int prosessointiaika;
	private boolean vesikäyttö;
	private boolean raakakäyttö;
	
	public Juomakeitin(){
		tilavuusVesi = 0;
		tilavuusRaakaaine = 0;
		VESIMAX = 2000;
		RAAKAMAX = 10000;
		prosessointiaika = 0;
		varaaja = null;
	}
	//varaajan asetus, kysely ja reset
	public void setVaraaja(String v){
		if(varaaja == null){
			varaaja = v;
		}
	}
	public String getVaraaja(){
		return varaaja;
	}
	public void resetVaraaja(){
		varaaja = null;
	}
	//veden asetus ja kysely sekä veden max tilavuuden kysely
	public void setVesi(int v){
		tilavuusVesi = v;
	}
	public int getVesi(){
		return tilavuusVesi;
	}
	public int getVesiMax(){
		return VESIMAX;
	}
	//raakaaineen asetus ja kysely sekä raaka-aineen max tilavuuden kysely 
	public void setRaaka(int r){
		tilavuusRaakaaine = r;
	}
	public int setRaaka(){
		return tilavuusRaakaaine;
	}
	public int getRaakaMax(){
		return RAAKAMAX;
	}
	//veden täyttö/tyhjennyslipun (käyttö) asetus ja kysely
	public void setVesiKäyttö(boolean k){
		vesikäyttö = k;
	}
	public boolean getVesiKäyttö(){
		return vesikäyttö;
	}
	//raaka-aineen täyttö/tyhjennyslipun (käyttö) asetus ja kysely
	public void setRaakaKäyttö(boolean k){
		raakakäyttö = k;
	}
	public boolean getRaakaKäyttö(){
		return raakakäyttö;
	}
// pitää käynnistää uusi thread kun alkaa prosessoida (20 000 millisekuntia)




}
