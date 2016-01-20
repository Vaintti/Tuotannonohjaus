import java.util.ArrayList;

public class Ruuvisiirto implements Runnable {
	// Attribuutit
	private ArrayList<Siilo> siilot;
	private ArrayList<Juomakeitin> juomakeittimet;
	private final int SIIRTONOPEUS = 200;
	
	// Konstruktori siilot t�ytt�v�lle kuljettimelle
	public Ruuvisiirto(ArrayList<Siilo> s) {
		siilot = s;
	}
	
	// Konstruktori juomakeittimet t�ytt�v�lle kuljettimelle
	public Ruuvisiirto(ArrayList<Siilo> s, ArrayList<Juomakeitin> j) {
		siilot = s;
		juomakeittimet = j;
	}
	
	public void run() {
		// Jos t�ytet��n siiloja
		if(juomakeittimet == null) {
			for(Siilo x : siilot) {
				int t�ytt� = x.getT�ytt�();
				int katto = x.getT�ytt�katto();
				while(true) {
					try {
						Thread.sleep(100);
						if(x.getT�ytt�()+SIIRTONOPEUS/10 <= katto) {
							x.setT�ytt�(t�ytt�+SIIRTONOPEUS/10);
						}
						else {
							x.setT�ytt�(katto);
							break;
						}
					}catch(Exception e) {
						System.out.println(e);
					}
				}
			}
		}
		// Jos siirret��n siiloista juomakeittimiin
		else {
			for(Siilo x : siilot) {
				int xt�ytt� = x.getT�ytt�();
				while(x.getT�ytt�()>0) {
					for(Juomakeitin y : juomakeittimet) {
						int yt�ytt� = y.getRaaka();
						try {
							Thread.sleep(100);
							if(x.getT�ytt�() >= SIIRTONOPEUS/10 && y.getRaaka()+SIIRTONOPEUS/10 <= y.getRaakaMax()) {
								x.setT�ytt�(x.getT�ytt�()-SIIRTONOPEUS/10);
								y.setRaaka(y.getT�ytt�()+SIIRTONOPEUS/10);
							}
						}catch(Exception e) {
							System.out.println(e);
						}
					}
				}
			}
		}
	}
}
