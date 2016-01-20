import java.util.ArrayList;

public class Ruuvisiirto implements Runnable {
	// Attribuutit
	private ArrayList<Siilo> siilot = new ArrayList<Siilo>();
	private ArrayList<Juomakeitin> juomakeittimet = new ArrayList<Juomakeitin>();
	private int siirtom‰‰r‰;
	private final int SIIRTONOPEUS = 200;
	
	// Konstruktori siilot t‰ytt‰v‰lle kuljettimelle
	public Ruuvisiirto(int m, ArrayList<Siilo> s) {
		
	}
	
	// Konstruktori juomakeittimet t‰ytt‰v‰lle kuljettimelle
	public Ruuvisiirto(ArrayList<Siilo> s, int m, ArrayList<Juomakeitin> j) {
		
	}
	
	public void run() {
		int siirtoaika = siirtom‰‰r‰/SIIRTONOPEUS;
		// tietojen p‰ivitys tapahtuu 10 kertaa siirron aikana
	}
}
