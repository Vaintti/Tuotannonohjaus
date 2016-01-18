import java.util.ArrayList;

public class Ruuvikuljetin {
	// Siirtonopeus 200 kiloa sekunnissa
	private final int SIIRTONOPEUS = 200;
	// Onko kuljetin siilojen t�ytt��n
	private boolean siilojenT�ytt� = false;
	
	public Ruuvikuljetin(boolean siilojen) {
		this.siilojenT�ytt� = siilojen;
	}
	
	public void siirr�(ArrayList<Siilo> s, int m��r�, ArrayList<Juomakeitin> j) {
		// Saatavilla oleva raaka-aine
		int saatavilla = 0;
		for(Siilo si : s) {
			saatavilla += si.getT�ytt�();
		}
		int halutaan = 0;
		for(Juomakeitin ju : j) {
			// halutaan += j.getT�ytt�();
		}
		int siirret��n = m��r�;
		if(saatavilla < siirret��n) {
			siirret��n = saatavilla;
		}
		if(halutaan < siirret��n) {
			siirret��n = halutaan;
		}
	}
}
