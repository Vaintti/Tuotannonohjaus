import java.util.ArrayList;

public class Ruuvikuljetin {
	// Siirtonopeus 200 kiloa sekunnissa
	private final int SIIRTONOPEUS = 200;
	// Onko kuljetin siilojen täyttöön
	private boolean siilojenTäyttö = false;
	
	public Ruuvikuljetin(boolean siilojen) {
		this.siilojenTäyttö = siilojen;
	}
	
	public void siirrä(ArrayList<Siilo> s, int määrä, ArrayList<Juomakeitin> j) {
		// Saatavilla oleva raaka-aine
		int saatavilla = 0;
		for(Siilo si : s) {
			saatavilla += si.getTäyttö();
		}
		// Haluttu raaka-ainemäärä
		int halutaan = 0;
		for(Juomakeitin ju : j) {
			// halutaan += j.getTäyttökatto()-j.getTäyttö();
		}
		// Lopulta siirrettävä raaka-ainemäärä
		int siirretään = määrä;
		if(saatavilla < siirretään) {
			siirretään = saatavilla;
		}
		if(halutaan < siirretään) {
			siirretään = halutaan;
		}
		// Siirtoprosessi
		if(siilojenTäyttö) {
			new Thread(new Ruuvisiirto(siirretään, s));
		}
		else {
			new Thread(new Ruuvisiirto(s, siirretään, j));
		}
	}
}
