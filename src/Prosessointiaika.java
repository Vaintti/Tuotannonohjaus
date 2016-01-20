
public class Prosessointiaika implements Runnable {
	private final int AIKA;
	private Juomakeitin j;
	public Prosessointiaika(Juomakeitin ju){
		AIKA = 20000;
		this.j = ju;
	}
	
	public void run(){
		try {
		    Thread.sleep(AIKA);
		    j.lopetus();
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
	}

	//run metodi katso mallia summaajasta(sivu26) ja hajoyhteydestä (rivi 102)
	//dalay 20000 millisekuntia.
}
