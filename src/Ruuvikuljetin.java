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
		int halutaan = 0;
		for(Juomakeitin ju : j) {
			// halutaan += j.getTäyttökatto()-j.getTäyttö();
		}
		int siirretään = määrä;
		if(saatavilla < siirretään) {
			siirretään = saatavilla;
		}
		if(halutaan < siirretään) {
			siirretään = halutaan;
		}
		
	}
}
