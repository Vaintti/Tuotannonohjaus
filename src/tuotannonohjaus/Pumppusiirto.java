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
		System.out.println("Keittimet: "+j+" S�ili�t: "+k);
		for(Kypsytyss�ili� s: k) {
			for(Juomakeitin ke : j) {

				while(true) {
					try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
					if(ke.getValmistuotetta() >= SIIRTONOPEUS/10){
						if(s.getT�ytt�aste() <= s.getTilavuus()-SIIRTONOPEUS/10) {
							ke.setValmistuotette(ke.getValmistuotetta()-SIIRTONOPEUS/10);
							s.setT�ytt�aste(s.getT�ytt�aste()+SIIRTONOPEUS/10);
							ke.setTyhjenee(true);
							ke.setValmis(false);
							s.setK�yt�ss�(true);
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getT�ytt�aste()));
							s.setT�ytt�aste(s.getTilavuus());
							ke.setTyhjenee(false);
							s.setK�yt�ss�(false);
							s.setK�yt�ss�(false);
							s.setK�ytt�j�(null);
							System.out.println("tankki t�ysi");
							break;
						}
					}
					else if(ke.getValmistuotetta() > 0) {
						if(s.getTilavuus()-s.getT�ytt�aste() >= ke.getValmistuotetta()) {
							s.setT�ytt�aste(s.getT�ytt�aste()+ke.getValmistuotetta());
							ke.setValmistuotette(0);
							ke.setTyhjenee(false);
							s.setK�yt�ss�(false);
							s.setK�ytt�j�(null);
							ke.resetVaraaja();
							System.out.println("tankki 3");
						}
						else{
							ke.setValmistuotette(ke.getValmistuotetta()-(s.getTilavuus()-s.getT�ytt�aste()));
							s.setT�ytt�aste(s.getTilavuus());
							s.setK�yt�ss�(false);
							s.setK�ytt�j�(null);
							ke.resetVaraaja();
							System.out.println("tankki 4");
							break;
						}
					}
					else{
						ke.setTyhjenee(false);
						s.setK�yt�ss�(false);
						s.setK�ytt�j�(null);
						ke.resetVaraaja();
						break;
					}
				}
			}
		}
		pumppu.lopetaPumppaaminen();
	}
}
