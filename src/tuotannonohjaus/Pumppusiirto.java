package tuotannonohjaus;

import java.util.ArrayList;

public class Pumppusiirto implements Runnable {
	ArrayList<Kypsytyss�ili�> k;
	ArrayList<Juomakeitin> j;
	Pumppu pumppu;
	final int SIIRTONOPEUS = 500;
	
	public Pumppusiirto(Pumppu p, ArrayList<Kypsytyss�ili�> a, ArrayList<Juomakeitin> b) {
		this.k = a;
		this.j = b;
		this.pumppu = p;
	}
	
	public void run() {
		for(Juomakeitin ke : j) {
			for(Kypsytyss�ili� s: k) {
				while(true) {
					if(ke.getValmistuotetta() >= SIIRTONOPEUS/10){
						if(s.getT�ytt�aste() <= s.getTilavuus()-SIIRTONOPEUS/10) {
							ke.setValmistuotette(ke.getValmistuotetta()-SIIRTONOPEUS/10);
							s.setT�ytt�aste(s.getT�ytt�aste()+SIIRTONOPEUS/10);
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getT�ytt�aste()));
							s.setT�ytt�aste(s.getTilavuus());
						}
					}
					else if(ke.getValmistuotetta() > 0) {
						if(s.getTilavuus()-s.getT�ytt�aste() >= ke.getValmistuotetta()) {
							s.setT�ytt�aste(s.getT�ytt�aste()+ke.getValmistuotetta());
							ke.setValmistuotette(0);
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getT�ytt�aste()));
							s.setT�ytt�aste(s.getTilavuus());
						}
					}
					break;
				}
			}
		}
		pumppu.lopetaPumppaaminen();
	}
}
