package tuotannonohjaus;

public class Prosessointiaika implements Runnable {
	private final int AIKA;
	private Juomakeitin j;
	public Prosessointiaika(Juomakeitin ju){
		AIKA = 20000;
		this.j = ju;
	}
	
	public void run(){
		try {
			System.out.println("Prosessointi alkaa");
		    Thread.sleep(AIKA);
		    System.out.println("Prosessoinnin pitäisi loppua");
		    this.j.lopetus();
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}