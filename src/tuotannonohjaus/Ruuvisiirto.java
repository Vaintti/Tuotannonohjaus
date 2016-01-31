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
		if(juomakeittimet != null) {
			System.out.println("Siilot: "+siilot+" Keittimet: "+juomakeittimet);
			for(Juomakeitin s: juomakeittimet) {
				for(Siilo ke : siilot) {

					while(true) {
						try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
						if(ke.getTäyttö() >= SIIRTONOPEUS/10){
							if(s.getRaaka() <= s.getRaakaMax()-SIIRTONOPEUS/10) {
								ke.setTäyttö(ke.getTäyttö()-SIIRTONOPEUS/10);
								s.setRaaka(s.getRaaka()+SIIRTONOPEUS/10);
							}
							else{
								ke.setTäyttö(ke.getTäyttö()-(s.getRaakaMax()-s.getRaaka()));
								s.setRaaka(s.getRaakaMax());
								break;
							}
						}
						else if(ke.getTäyttö() > 0) {
							if(s.getRaakaMax()-s.getRaaka() >= ke.getTäyttö()) {
								s.setRaaka(s.getRaaka()+ke.getTäyttö());
								ke.setTäyttö(0);;
							}
							else{
								ke.setTäyttö(ke.getTäyttö()-(s.getRaakaMax()-s.getRaaka()));
								s.setRaaka(s.getRaakaMax());
								break;
							}
						}
						else{
							break;
						}
					}
				}
			}
			
			kuljetin.poistaKäytöstä();
		}
		else{
			for(Siilo xi : siilot){
				while(true) {
					try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
					if(xi.getTäyttö() <= xi.getTäyttökatto()-SIIRTONOPEUS/10){
						xi.setTäyttö(xi.getTäyttö()+SIIRTONOPEUS/10);
					}
					else if(xi.getTäyttö() < xi.getTäyttökatto()) {
						xi.setTäyttö(xi.getTäyttökatto());
						break;
					}
					else{
						break;
					}
				}
			}
			kuljetin.poistaKäytöstä();
		}
	}
}
