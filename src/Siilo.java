
public class Siilo {
	
	private String raakaaine;
	private int t�ytt�aste;
	private String k�ytt�j�;
	private boolean t�yttyy;
	private boolean tyhjenee;
	private int t�ytt�katto;
	
	public Siilo(){
		raakaaine = "mallas";
		k�ytt�j� = null;
		t�ytt�aste = 0;
		t�yttyy = false;
		tyhjenee = false;
		t�ytt�katto = 10000;
	}
	
	public int getT�ytt�(){
		return t�ytt�aste;
	}
	
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
	
	public void t�ytt�(){
		if (t�yttyy == false && tyhjenee == false){
			t�yttyy = true;	
			}
		}
	public void tyhjennys(){
		if (t�yttyy == false && tyhjenee == false){
			tyhjenee = true;	
			}
		}
	public void toiminnanLopetus(){
		tyhjenee = false;
		t�yttyy = false;	
	}
	
	
}
