package tuotannonohjaus;

import java.util.*;

public class Pumppu {
	// Siirtonopeus litraa sekunnissa
	private final int SIIRTONOPEUS = 500;
	private boolean pullotukseen;
	private String[] käyttäjä;
	
	public Pumppu(boolean p) {
		pullotukseen = p;
	}
	public void pullotaKaikki(ArrayList<Kypsytyssäiliö> k) {
		for(Kypsytyssäiliö s : k) {
			while(s.getTäyttöaste() >= SIIRTONOPEUS/10) {
				s.setTäyttöaste(s.getTäyttöaste()-SIIRTONOPEUS/10);
			}
			
		}
	}
	public String[] getKäyttäjä() {
		return this.käyttäjä;
	}
	public void start() {
		
	}
}
