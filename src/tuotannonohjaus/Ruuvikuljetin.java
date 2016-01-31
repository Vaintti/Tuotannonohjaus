package tuotannonohjaus;
import java.util.ArrayList;

public class Ruuvikuljetin {
	// Onko kuljetin siilojen täyttöön
	private boolean siilojenTäyttö = false;
	private String[] käyttäjä;
	private boolean käytössä;
	
	public Ruuvikuljetin(boolean siilojen) {
		this.siilojenTäyttö = siilojen;
		this.käytössä = false;
	}
	
	public void siirrä(ArrayList<Siilo> s, int määrä, ArrayList<Juomakeitin> j) {
		// Siirtoprosessi
		System.out.println("Ruuvisiirron pitäisi alkaa. Siilojen täyttö on ");
		if(siilojenTäyttö) {
			this.käytössä = true;
			(new Thread(new Ruuvisiirto(this, s))).start();
		}
		else {
			(new Thread(new Ruuvisiirto(this, määrä, s, j))).start();
		}
	}
	public void poistaKäytöstä() {
		this.käytössä = false;
	}
	public boolean getKäytössä() {
		return this.käytössä;
	}
}
