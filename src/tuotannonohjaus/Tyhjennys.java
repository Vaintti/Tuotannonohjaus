package tuotannonohjaus;

import java.util.ArrayList;

public class Tyhjennys implements Runnable {
	ArrayList<Kypsytyss�ili�> s�ili�t;
	
	public Tyhjennys (ArrayList<Kypsytyss�ili�> k) {
		this.s�ili�t = k;
	}
	
	public void run() {
		for(Kypsytyss�ili� s : s�ili�t) {
			while(true) {
				
			}
		}
	}
}
