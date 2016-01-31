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
		if(juomakeittimet != null) {
			System.out.println("Siilot: "+siilot+" Keittimet: "+juomakeittimet);
			for(Juomakeitin s: juomakeittimet) {
				for(Siilo ke : siilot) {

					while(true) {
						try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
						if(ke.getT�ytt�() >= SIIRTONOPEUS/10){
							if(s.getRaaka() <= s.getRaakaMax()-SIIRTONOPEUS/10) {
								ke.setT�ytt�(ke.getT�ytt�()-SIIRTONOPEUS/10);
								s.setRaaka(s.getRaaka()+SIIRTONOPEUS/10);
							}
							else{
								ke.setT�ytt�(ke.getT�ytt�()-(s.getRaakaMax()-s.getRaaka()));
								s.setRaaka(s.getRaakaMax());
								break;
							}
						}
						else if(ke.getT�ytt�() > 0) {
							if(s.getRaakaMax()-s.getRaaka() >= ke.getT�ytt�()) {
								s.setRaaka(s.getRaaka()+ke.getT�ytt�());
								ke.setT�ytt�(0);;
							}
							else{
								ke.setT�ytt�(ke.getT�ytt�()-(s.getRaakaMax()-s.getRaaka()));
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
			
			kuljetin.poistaK�yt�st�();
		}
		else{
			for(Siilo xi : siilot){
				while(true) {
					try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
					if(xi.getT�ytt�() <= xi.getT�ytt�katto()-SIIRTONOPEUS/10){
						xi.setT�ytt�(xi.getT�ytt�()+SIIRTONOPEUS/10);
					}
					else if(xi.getT�ytt�() < xi.getT�ytt�katto()) {
						xi.setT�ytt�(xi.getT�ytt�katto());
						break;
					}
					else{
						break;
					}
				}
			}
			kuljetin.poistaK�yt�st�();
		}
	}
}
