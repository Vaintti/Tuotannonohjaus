package tuotannonohjaus;

import java.util.ArrayList;

public class Tyhjennys implements Runnable {
	ArrayList<Kypsytyss�ili�> s�ili�t;
	Pumppu pumppu;
	final int SIIRTONOPEUS = 500;
	
	public Tyhjennys (Pumppu p, ArrayList<Kypsytyss�ili�> k) {
		this.s�ili�t = k;
		this.pumppu = p;
	}
	
	public void run() {
		for(Kypsytyss�ili� s : s�ili�t) {
			while(true){
				try{Thread.sleep(100);}catch(Exception e){System.out.println(e);}
				if(s.getT�ytt�aste() >= SIIRTONOPEUS/10) {
					s.setT�ytt�aste(s.getT�ytt�aste()-SIIRTONOPEUS/10);
					s.setK�yt�ss�(true);
				}
				else if(s.getT�ytt�aste() > 0) {
					s.setT�ytt�aste(0);
					s.setK�yt�ss�(false);
					s.setK�ytt�j�(null);
				}
				else{
					s.setK�yt�ss�(false);
					s.setK�ytt�j�(null);
					break;
				}
			}
		}
		pumppu.lopetaPumppaaminen();
	}
}
