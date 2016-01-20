import java.util.ArrayList;

public class Ruuvisiirto implements Runnable {
	// Attribuutit
	private ArrayList<Siilo> siilot;
	private ArrayList<Juomakeitin> juomakeittimet;
	private final int SIIRTONOPEUS = 200;
	
	// Konstruktori siilot täyttävälle kuljettimelle
	public Ruuvisiirto(ArrayList<Siilo> s) {
		siilot = s;
	}
	
	// Konstruktori juomakeittimet täyttävälle kuljettimelle
	public Ruuvisiirto(ArrayList<Siilo> s, ArrayList<Juomakeitin> j) {
		siilot = s;
		juomakeittimet = j;
	}
	
	public void run() {
		// Jos täytetään siiloja
		if(juomakeittimet == null) {
			for(Siilo x : siilot) {
				int täyttö = x.getTäyttö();
				int katto = x.getTäyttökatto();
				while(true) {
					try {
						Thread.sleep(100);
						if(x.getTäyttö()+SIIRTONOPEUS/10 <= katto) {
							x.setTäyttö(täyttö+SIIRTONOPEUS/10);
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
			for(Siilo x : siilot) {
				while(x.getTäyttö()>0) {
					for(Juomakeitin y : juomakeittimet) {
						try {
							Thread.sleep(100);
							
						}catch(Exception e) {
							System.out.println(e);
						}
					}
				}
			}
		}
	}
}
