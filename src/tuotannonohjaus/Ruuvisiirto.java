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
		int siirretty = 0;
		if(juomakeittimet != null) {
			System.out.println("Siilot: "+siilot+" Keittimet: "+juomakeittimet);
			for(Juomakeitin s: juomakeittimet) {
				for(Siilo ke : siilot) {

					while(siirretty < m��r�) {
						try{Thread.sleep(100);}catch(Exception e){System.out.println(e);};
						if(ke.getT�ytt�() >= SIIRTONOPEUS/10){
							if(s.getRaaka() <= s.getRaakaMax()-SIIRTONOPEUS/10) {
								siirretty += SIIRTONOPEUS/10;
								ke.setT�ytt�(ke.getT�ytt�()-SIIRTONOPEUS/10);
								s.setRaaka(s.getRaaka()+SIIRTONOPEUS/10);
								s.setT�yttyy(true);
								ke.setK�yt�ss�(true);
							}
							else{
								siirretty += (s.getRaakaMax()-s.getRaaka());
								ke.setT�ytt�(ke.getT�ytt�()-(s.getRaakaMax()-s.getRaaka()));
								s.setRaaka(s.getRaakaMax());
								s.setT�yttyy(false);
								ke.setK�yt�ss�(false);
								ke.setK�ytt�j�(null);
								ke.setK�yt�ss�(false);
								break;
							}
						}
						else if(ke.getT�ytt�() > 0) {
							if(s.getRaakaMax()-s.getRaaka() >= ke.getT�ytt�()) {
								siirretty +=ke.getT�ytt�();
								s.setRaaka(s.getRaaka()+ke.getT�ytt�());
								ke.setT�ytt�(0);;
								s.setT�yttyy(false);
								ke.setK�yt�ss�(false);
								ke.setK�ytt�j�(null);
								ke.setK�yt�ss�(false);
								System.out.println("Ruuvisiirto 3");
							}
							else{
								siirretty += (s.getRaakaMax()-s.getRaaka());
								ke.setT�ytt�(ke.getT�ytt�()-(s.getRaakaMax()-s.getRaaka()));
								s.setRaaka(s.getRaakaMax());
								s.setT�yttyy(false);
								ke.setK�yt�ss�(false);
								ke.setK�ytt�j�(null);
								ke.setK�yt�ss�(false);
								System.out.println("Ruuvisiirto 4");
								break;
							}
						}
						else{
							System.out.println("Ruuvisiirto 5");
							ke.setK�yt�ss�(false);
							s.setT�yttyy(false);
							ke.setK�ytt�j�(null);
							ke.setK�yt�ss�(false);
							break;
						}
					}
				}
			}
			for(Juomakeitin s : juomakeittimet) {
				for(Siilo ke : siilot) {
					s.setT�yttyy(false);
					ke.setK�yt�ss�(false);
					ke.setK�ytt�j�(null);
					ke.setK�yt�ss�(false);
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
						xi.setK�yt�ss�(true);
					}
					else if(xi.getT�ytt�() < xi.getT�ytt�katto()) {
						xi.setT�ytt�(xi.getT�ytt�katto());
						xi.setK�yt�ss�(false);
						System.out.println("Ruuvisiirto xi 2");
						break;
					}
					else{
						xi.setK�yt�ss�(false);
						xi.setK�ytt�j�(null);
						xi.setK�yt�ss�(false);
						break;
					}
				}
			}
			for(Siilo xi : siilot) {
				xi.setK�yt�ss�(false);
				xi.setK�ytt�j�(null);
				xi.setK�yt�ss�(false);
			}
			kuljetin.poistaK�yt�st�();
		}
	}
}
