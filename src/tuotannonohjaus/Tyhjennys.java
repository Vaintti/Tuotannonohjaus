package tuotannonohjaus;

import java.util.ArrayList;

public class Tyhjennys implements Runnable {
	ArrayList<Kypsytyssäiliö> säiliöt;
	Pumppu pumppu;
	final int SIIRTONOPEUS = 500;
	
	public Tyhjennys (Pumppu p, ArrayList<Kypsytyssäiliö> k) {
		this.säiliöt = k;
		this.pumppu = p;
	}
	
	public void run() {
		for(Kypsytyssäiliö s : säiliöt) {
			while(true){
				try{Thread.sleep(100);}catch(Exception e){System.out.println(e);}
				if(s.getTäyttöaste() >= SIIRTONOPEUS/10) {
					s.setTäyttöaste(s.getTäyttöaste()-SIIRTONOPEUS/10);
					s.setKäytössä(true);
				}
				else if(s.getTäyttöaste() > 0) {
					s.setTäyttöaste(0);
					s.setKäytössä(false);
					s.setKäyttäjä(null);
				}
				else{
					s.setKäytössä(false);
					s.setKäyttäjä(null);
					break;
				}
			}
		}
		pumppu.lopetaPumppaaminen();
	}
}
