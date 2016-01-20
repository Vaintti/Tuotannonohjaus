
public class Juomakeitin {

	private String varaaja;
	private int tilavuusVesi;
	private final int VESIMAX;
	private int tilavuusRaakaaine;
	private final int RAAKAMAX;
	private int prosessointiaika;
	private boolean vesik�ytt�;
	private boolean raakak�ytt�;
	
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
	//veden asetus ja kysely sek� veden max tilavuuden kysely
	public void setVesi(int v){
		tilavuusVesi = v;
	}
	public int getVesi(){
		return tilavuusVesi;
	}
	public int getVesiMax(){
		return VESIMAX;
	}
	//raakaaineen asetus ja kysely sek� raaka-aineen max tilavuuden kysely 
	public void setRaaka(int r){
		tilavuusRaakaaine = r;
	}
	public int setRaaka(){
		return tilavuusRaakaaine;
	}
	public int getRaakaMax(){
		return RAAKAMAX;
	}
	//veden t�ytt�/tyhjennyslipun (k�ytt�) asetus ja kysely
	public void setVesiK�ytt�(boolean k){
		vesik�ytt� = k;
	}
	public boolean getVesiK�ytt�(){
		return vesik�ytt�;
	}
	//raaka-aineen t�ytt�/tyhjennyslipun (k�ytt�) asetus ja kysely
	public void setRaakaK�ytt�(boolean k){
		raakak�ytt� = k;
	}
	public boolean getRaakaK�ytt�(){
		return raakak�ytt�;
	}
// pit�� k�ynnist�� uusi thread kun alkaa prosessoida (20 000 millisekuntia)




}
