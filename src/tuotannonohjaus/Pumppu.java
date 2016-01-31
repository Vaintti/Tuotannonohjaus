package tuotannonohjaus;

import java.util.*;

public class Pumppu {
	// Siirtonopeus litraa sekunnissa
	private ArrayList<Kypsytyssäiliö> säiliöt;
	private ArrayList<Juomakeitin> keittimet;
	private String[] käyttäjä;
	private boolean pumppaa;

	public Pumppu(boolean p) {
		pumppaa = false;
	}
	
	public void start(ArrayList<Kypsytyssäiliö> k) {
		pumppaa = true;
	}
	public void start(ArrayList<Juomakeitin> j, ArrayList<Kypsytyssäiliö> k) {
		System.out.println("Siirron pitäisi alkaa");
		pumppaa = true;
		(new Thread(new Pumppusiirto(this, k, j))).start();
	}
	public String[] getKäyttäjä() {
		return this.käyttäjä;
	}
	public void lopetaPumppaaminen() {
		this.pumppaa = false;
	}
	public boolean pumppaako() {
		return this.pumppaa;
	}
}
