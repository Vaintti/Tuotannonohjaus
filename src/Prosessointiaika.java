
public class Prosessointiaika implements Runnable {
	private final int AIKA;
	private boolean running;
	
	public Prosessointiaika(){
		AIKA = 20000;
	}
	
	public void run(){
		running = true;
		try {
		    Thread.sleep(AIKA);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	public void sammuta(){
		running = false;
	}
	public boolean Runnig(){
		return running;
	}

	//run metodi katso mallia summaajasta(sivu26) ja hajoyhteydestä (rivi 102)
	//dalay 20000 millisekuntia.
}
