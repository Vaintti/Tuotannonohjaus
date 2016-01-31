package tuotannonohjaus;

public class Juomakeitin {

	private String[] varaaja;
	private int tilavuusRaakaaine;
	private int valmistuotetta;
	private final int RAAKAMAX;
	private boolean raakakäyttö;
	private boolean prosessoi;
	private boolean valmis;
	private boolean täyttyy;
	private boolean tyhjenee;
	
	public Juomakeitin(){
		tilavuusRaakaaine = 0;
		RAAKAMAX = 2000;
		varaaja = null;
		prosessoi = false;
		valmis = false;
		valmistuotetta = 0;
	}
	//varaajan asetus, kysely ja reset
	public void setVaraaja(String[] v){
		if(varaaja == null){
			varaaja = v;
		}
	}
	public String[] getVaraaja(){
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
	public boolean getProsessoi(){
		return prosessoi;
	}
	
	//käynnistetään uusi säie prosessoinnin laskemiseksi (kesto 20 sec)
	public void käynnistys(){
		prosessoi = true;
		(new Thread(new Prosessointiaika(this))).start();;
	}
	public void lopetus(){
		this.prosessoi = false;
		this.valmis = true;
		this.valmistuotetta = 10000;
		this.tilavuusRaakaaine = 0;
	}
	public int getValmistuotetta() {
		return this.valmistuotetta;
	}
	public void setValmistuotette(int i) {
		this.valmistuotetta = i;
	}
	public boolean getTäyttyy() {
		return täyttyy;
	}
	public void setTäyttyy(boolean täyttyy) {
		this.täyttyy = täyttyy;
	}
	public boolean getTyhjenee() {
		return tyhjenee;
	}
	public void setTyhjenee(boolean tyhjenee) {
		this.tyhjenee = tyhjenee;
	}
}
