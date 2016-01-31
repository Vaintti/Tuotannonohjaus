package tuotannonohjaus;

import java.util.ArrayList;

public class Tyhjennys implements Runnable {
	ArrayList<Kypsytyssäiliö> säiliöt;
	
	public Tyhjennys (ArrayList<Kypsytyssäiliö> k) {
		this.säiliöt = k;
	}
	
	public void run() {
		for(Kypsytyssäiliö s : säiliöt) {
			while(true) {
				
			}
		}
	}
}
