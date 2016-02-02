package tuotannonohjaus;

public class Kypsytyssäiliö {
	
	private String juoma;
	private final int tilavuus = 10000;
	private String[] käyttäjä;
	private int täyttöaste;
	private boolean käytössä;
	
public String getJuoma() {
		return juoma;
	}
	public Kypsytyssäiliö() {
		juoma = "olut";
		käyttäjä = null;
		täyttöaste = 0;
	}
	public void setJuoma(String juoma) {
		this.juoma = juoma;
	}
	public int getTilavuus() {
		return tilavuus;
	}
	
	public boolean isKäytössä() {
		if(käyttäjä == null){
			return false;
		}
		else{
			return true;
		}
	}
	public String[] getKäyttäjä() {
		return käyttäjä;
	}
	public void setKäyttäjä(String[] käyttäjä) {
		this.käyttäjä = käyttäjä;
	}
	public int getTäyttöaste() {
		return täyttöaste;
	}
	public void setTäyttöaste(int täyttöaste) {
		this.täyttöaste = täyttöaste;
	}
	public void setKäytössä(boolean k){
		käytössä = k;
	}
	public boolean getKäytössä(){
		return käytössä;
	}
	
}
