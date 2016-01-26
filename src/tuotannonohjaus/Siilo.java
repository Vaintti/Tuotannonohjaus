package tuotannonohjaus;

public class Siilo {
	
	private String raakaaine;
	private final int T�YTT�KATTO;
	private int t�ytt�aste;
	private String k�ytt�j�;
	private boolean k�yt�ss�;	
	
	public Siilo(){
		raakaaine = "mallas";
		k�ytt�j� = null;
		t�ytt�aste = 0;
		k�yt�ss� = false;
		T�YTT�KATTO = 10000;
	}
	//T�yt�n kysely ja asetus
	public int getT�ytt�(){
		return t�ytt�aste;
	}
	public void setT�ytt�(int i){
		t�ytt�aste = i;
	}
	//Maksimi tilavuuden kysely
	public int getT�ytt�katto(){
		return T�YTT�KATTO;
	}
	//k�ytt�j�n asetus, kysely ja poisto
	public void setK�ytt�j�(String k){
		if(k�ytt�j�==null){
			k�ytt�j�=k;
		}
	}
	public String getK�ytt�j�(){
		return k�ytt�j�;
	}
	public void poistaK�ytt�j�(){
		k�ytt�j�=null;
	}
	//k�yt�ss� lipun get ja set
	public void setK�yt�ss�(boolean k){
		k�yt�ss� = k;
		}
	public boolean getK�yt�ss�(){
		return k�yt�ss�;
	}
}
