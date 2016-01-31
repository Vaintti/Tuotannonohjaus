package tuotannonohjaus;

public class Kypsytyss�ili� {
	
	private String juoma;
	private final int tilavuus = 10000;
	private boolean k�yt�ss�;
	private String[] k�ytt�j�;
	private int t�ytt�aste;
	
public String getJuoma() {
		return juoma;
	}
	public Kypsytyss�ili�() {
		juoma = "olut";
		k�yt�ss� = false;
		k�ytt�j� = null;
		t�ytt�aste = 0;
	}
	public void setJuoma(String juoma) {
		this.juoma = juoma;
	}
	public int getTilavuus() {
		return tilavuus;
	}
	
	public boolean isK�yt�ss�() {
		return k�yt�ss�;
	}
	public void setK�yt�ss�(boolean k�yt�ss�) {
		this.k�yt�ss� = k�yt�ss�;
	}
	public String[] getK�ytt�j�() {
		return k�ytt�j�;
	}
	public void setK�ytt�j�(String[] k�ytt�j�) {
		this.k�ytt�j� = k�ytt�j�;
	}
	public int getT�ytt�aste() {
		return t�ytt�aste;
	}
	public void setT�ytt�aste(int t�ytt�aste) {
		this.t�ytt�aste = t�ytt�aste;
	}
	
}
