package tuotannonohjaus;
import java.util.ArrayList;

public class Ruuvisiirto implements Runnable {
	// Attribuutit
	private Ruuvikuljetin kuljetin;
	private ArrayList<Siilo> siilot;
	private ArrayList<Juomakeitin> juomakeittimet;
	private final int SIIRTONOPEUS = 200;
	int määrä;
	
	// Konstruktori siilot täyttävälle kuljettimelle
	public Ruuvisiirto(Ruuvikuljetin kul, ArrayList<Siilo> s) {
		siilot = s;
		this.kuljetin = kul;
	}
	
	// Konstruktori juomakeittimet täyttävälle kuljettimelle
	public Ruuvisiirto(Ruuvikuljetin kul, int m, ArrayList<Siilo> s, ArrayList<Juomakeitin> j) {
		siilot = s;
		juomakeittimet = j;
		this.kuljetin = kul;
		määrä = m;
	}
	
	public void run() {
		System.out.println("Ruuvisiirto aloitettu.");
		// Jos täytetään siiloja
		if(juomakeittimet == null) {
			System.out.println(siilot);
			for(Siilo x : siilot) {
				int täyttö = x.getTäyttö();
				int katto = x.getTäyttökatto();
				while(true) {
					try {
						System.out.println(x.getTäyttö());
						Thread.sleep(100);
						if(x.getTäyttö()+SIIRTONOPEUS/10 <= katto) {
							x.setTäyttö(x.getTäyttö()+SIIRTONOPEUS/10);
						}
						else {
							x.setTäyttö(katto);
							break;
						}
					}catch(Exception e) {
						System.out.println(e);
					}
				}
			}
		}
		// Jos siirretään siiloista juomakeittimiin
		else {
			int siirretty = 0;
			int siirto = 10;
			for(Siilo x : siilot) {
				while(x.getTäyttö()>0 && siirretty+siirto <= määrä) {
					for(Juomakeitin y : juomakeittimet) {
						try {
							Thread.sleep(100);
							if(x.getTäyttö() >= SIIRTONOPEUS/10 && y.getRaaka()+SIIRTONOPEUS/10 <= y.getRaakaMax()) {
								x.setTäyttö(x.getTäyttö()-SIIRTONOPEUS/10);
								y.setRaaka(y.getRaaka()+SIIRTONOPEUS/10);
								siirretty += SIIRTONOPEUS/10;
							}
							else {
								if(x.getTäyttö() > y.getRaakaMax()-y.getRaaka()) {
									x.setTäyttö(x.getTäyttö()-(y.getRaakaMax()-y.getRaaka()));
									y.setRaaka(y.getRaakaMax());
								}
								else {
									y.setRaaka(y.getRaaka()+x.getTäyttö());
									x.setTäyttö(0);
								}
							}
						}catch(Exception e) {
							System.out.println(e);
						}
					}
				}
			}
		}
		this.kuljetin.poistaKäytöstä();
	}
}
