package tuotannonohjaus;

import java.util.ArrayList;

public class Pumppusiirto implements Runnable {
	ArrayList<Kypsytyssäiliö> k;
	ArrayList<Juomakeitin> j;
	Pumppu pumppu;
	final int SIIRTONOPEUS = 500;

	public Pumppusiirto(Pumppu p, ArrayList<Kypsytyssäiliö> a, ArrayList<Juomakeitin> b) {
		this.k = a;
		this.j = b;
		this.pumppu = p;
	}

	public void run() {
		System.out.println("Keittimet: "+j+" Säiliöt: "+k);
		for(Kypsytyssäiliö s: k) {
			for(Juomakeitin ke : j) {

				while(true) {
					try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
					if(ke.getValmistuotetta() >= SIIRTONOPEUS/10){
						if(s.getTäyttöaste() <= s.getTilavuus()-SIIRTONOPEUS/10) {
							ke.setValmistuotette(ke.getValmistuotetta()-SIIRTONOPEUS/10);
							s.setTäyttöaste(s.getTäyttöaste()+SIIRTONOPEUS/10);
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getTäyttöaste()));
							s.setTäyttöaste(s.getTilavuus());
						}
					}
					else if(ke.getValmistuotetta() > 0) {
						if(s.getTilavuus()-s.getTäyttöaste() >= ke.getValmistuotetta()) {
							s.setTäyttöaste(s.getTäyttöaste()+ke.getValmistuotetta());
							ke.setValmistuotette(0);
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getTäyttöaste()));
							s.setTäyttöaste(s.getTilavuus());
						}
					}
					else{
						break;
					}
				}
			}
		}
		pumppu.lopetaPumppaaminen();
	}
}
