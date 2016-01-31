package tuotannonohjaus;
import java.util.ArrayList;

public class Ruuvisiirto implements Runnable {
	// Attribuutit
	private Ruuvikuljetin kuljetin;
	private ArrayList<Siilo> siilot;
	private ArrayList<Juomakeitin> juomakeittimet;
	private final int SIIRTONOPEUS = 200;
	int m��r�;

	// Konstruktori siilot t�ytt�v�lle kuljettimelle
	public Ruuvisiirto(Ruuvikuljetin kul, ArrayList<Siilo> s) {
		siilot = s;
		this.kuljetin = kul;
	}

	// Konstruktori juomakeittimet t�ytt�v�lle kuljettimelle
	public Ruuvisiirto(Ruuvikuljetin kul, int m, ArrayList<Siilo> s, ArrayList<Juomakeitin> j) {
		siilot = s;
		juomakeittimet = j;
		this.kuljetin = kul;
		m��r� = m;
	}

	public void run() {
		System.out.println("Ruuvisiirto aloitettu.");
		// Jos t�ytet��n siiloja
		if(juomakeittimet == null) {
			for(Siilo x : siilot) {
				int katto = x.getT�ytt�katto();
				while(true) {
					try {
						Thread.sleep(100);
						if(x.getT�ytt�()+SIIRTONOPEUS/10 <= katto) {
							x.setT�ytt�(x.getT�ytt�()+SIIRTONOPEUS/10);
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
			int siirretty = 0;
			for(Siilo x : siilot) {
				while(x.getT�ytt�()>0 && siirretty < m��r�) {
					for(Juomakeitin y : juomakeittimet) {
						try {Thread.sleep(100);}catch(Exception e) {e.printStackTrace();}
						if(x.getT�ytt�() >= SIIRTONOPEUS/10 && y.getRaaka()+SIIRTONOPEUS/10 <= y.getRaakaMax()) {
							x.setT�ytt�(x.getT�ytt�()-SIIRTONOPEUS/10);
							y.setRaaka(y.getRaaka()+SIIRTONOPEUS/10);
							siirretty += SIIRTONOPEUS/10;
						}
						else {
							if(x.getT�ytt�() > y.getRaakaMax()-y.getRaaka()) {
								x.setT�ytt�(x.getT�ytt�()-(y.getRaakaMax()-y.getRaaka()));
								y.setRaaka(y.getRaakaMax());
							}
							else {
								y.setRaaka(y.getRaaka()+x.getT�ytt�());
								x.setT�ytt�(0);
							}
						}

					}
				}
			}
		}
		this.kuljetin.poistaK�yt�st�();
	}
}
