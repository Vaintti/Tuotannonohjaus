package tuotannonohjaus;
import java.util.ArrayList;

public class Ruuvikuljetin {
	// Onko kuljetin siilojen t�ytt��n
	private boolean siilojenT�ytt� = false;
	private boolean k�yt�ss�;
	
	public Ruuvikuljetin(boolean siilojen) {
		this.siilojenT�ytt� = siilojen;
		this.k�yt�ss� = false;
	}
	
	public void siirr�(ArrayList<Siilo> s, int m��r�, ArrayList<Juomakeitin> j) {
		// Siirtoprosessi
		System.out.println("Ruuvisiirron pit�isi alkaa.");
		this.k�yt�ss� = true;
		if(siilojenT�ytt�) {
			System.out.println("Siilon t�ytt� valittu");
			(new Thread(new Ruuvisiirto(this, s))).start();
		}
		else {
			System.out.println("Keittimen t�ytt� valittu");
			(new Thread(new Ruuvisiirto(this, m��r�, s, j))).start();
		}
	}
	public void poistaK�yt�st�() {
		this.k�yt�ss� = false;
	}
	public boolean getK�yt�ss�() {
		return this.k�yt�ss�;
	}
}
