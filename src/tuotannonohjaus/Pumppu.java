package tuotannonohjaus;

import java.util.*;

public class Pumppu {
	// Siirtonopeus litraa sekunnissa
	private ArrayList<Kypsytyss�ili�> s�ili�t;
	private ArrayList<Juomakeitin> keittimet;
	private String[] k�ytt�j�;
	private boolean pumppaa;

	public Pumppu(boolean p) {
		pumppaa = false;
	}
	
	public void start(ArrayList<Kypsytyss�ili�> k) {
		pumppaa = true;
	}
	public void start(ArrayList<Juomakeitin> j, ArrayList<Kypsytyss�ili�> k) {
		System.out.println("Siirron pit�isi alkaa");
		pumppaa = true;
		(new Thread(new Pumppusiirto(this, k, j))).start();
	}
	public String[] getK�ytt�j�() {
		return this.k�ytt�j�;
	}
	public void lopetaPumppaaminen() {
		this.pumppaa = false;
	}
	public boolean pumppaako() {
		return this.pumppaa;
	}
}
