package tuotannonohjaus;

public class Juomakeitin {

	private String varaaja;
	private int tilavuusRaakaaine;
	private final int RAAKAMAX;
	private boolean raakakäyttö;
	private boolean prosessoi;
	private boolean valmis;
	
	public Juomakeitin(){
		tilavuusRaakaaine = 0;
		RAAKAMAX = 10000;
		varaaja = null;
		prosessoi = false;
		valmis = false;
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
	//raakaaineen asetus ja kysely sekä raaka-aineen max tilavuuden kysely 
	public void setRaaka(int r){
		tilavuusRaakaaine = r;
	}
	public int getRaaka(){
		return tilavuusRaakaaine;
	}
	public int getRaakaMax(){
		return RAAKAMAX;
	}
	//raaka-aineen täyttö/tyhjennyslipun (käyttö) asetus ja kysely
	public void setRaakaKäyttö(boolean k){
		raakakäyttö = k;
	}
	public boolean getRaakaKäyttö(){
		return raakakäyttö;
	}
	// kypsyys lippu get ja set
	public boolean getValmis(){
		return valmis;
	}
	public void setValmis(boolean v){
		valmis = v;
	}
	
	//käynnistetään uusi säije prosessoinnin laskemiseksi (kesto 20 sec)
	public void käynnistys(){
		prosessoi = true;
		new Thread(new Prosessointiaika(this));
	}
	public void lopetus(){
		prosessoi = false;
		valmis = true;
	}



}
