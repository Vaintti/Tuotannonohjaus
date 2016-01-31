package tuotannonohjaus;

public class Juomakeitin {

	private String[] varaaja;
	private int tilavuusRaakaaine;
	private int valmistuotetta;
	private final int RAAKAMAX;
	private boolean raakak�ytt�;
	private boolean prosessoi;
	private boolean valmis;
	private boolean t�yttyy;
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
	//raakaaineen asetus ja kysely sek� raaka-aineen max tilavuuden kysely 
	public void setRaaka(int r){
		tilavuusRaakaaine = r;
	}
	public int getRaaka(){
		return tilavuusRaakaaine;
	}
	public int getRaakaMax(){
		return RAAKAMAX;
	}
	//raaka-aineen t�ytt�/tyhjennyslipun (k�ytt�) asetus ja kysely
	public void setRaakaK�ytt�(boolean k){
		raakak�ytt� = k;
	}
	public boolean getRaakaK�ytt�(){
		return raakak�ytt�;
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
	
	//k�ynnistet��n uusi s�ie prosessoinnin laskemiseksi (kesto 20 sec)
	public void k�ynnistys(){
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
	public boolean getT�yttyy() {
		return t�yttyy;
	}
	public void setT�yttyy(boolean t�yttyy) {
		this.t�yttyy = t�yttyy;
	}
	public boolean getTyhjenee() {
		return tyhjenee;
	}
	public void setTyhjenee(boolean tyhjenee) {
		this.tyhjenee = tyhjenee;
	}
}
