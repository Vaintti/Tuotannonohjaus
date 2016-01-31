package tuotannonohjaus;

public class Kypsytyssäiliö {
	
	private String juoma;
	private final int tilavuus = 10000;
	private boolean käytössä;
	private String[] käyttäjä;
	private int täyttöaste;
	
public String getJuoma() {
		return juoma;
	}
	public Kypsytyssäiliö() {
		juoma = "olut";
		käytössä = false;
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
		return käytössä;
	}
	public void setKäytössä(boolean käytössä) {
		this.käytössä = käytössä;
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
	
}
