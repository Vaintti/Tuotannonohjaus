package tuotannonohjaus;

import java.util.*;

public class Pumppu {
	// Siirtonopeus litraa sekunnissa
	private final int SIIRTONOPEUS = 500;
	private boolean pullotukseen;
	private String[] k�ytt�j�;
	
	public Pumppu(boolean p) {
		pullotukseen = p;
	}
	public void pullotaKaikki(ArrayList<Kypsytyss�ili�> k) {
		for(Kypsytyss�ili� s : k) {
			while(s.getT�ytt�aste() >= SIIRTONOPEUS/10) {
				s.setT�ytt�aste(s.getT�ytt�aste()-SIIRTONOPEUS/10);
			}
			
		}
	}
	public String[] getK�ytt�j�() {
		return this.k�ytt�j�;
	}
	public void start() {
		
	}
}
