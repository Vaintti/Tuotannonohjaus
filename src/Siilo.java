
public class Siilo {
	
	private String raakaaine;
	private int täyttöaste;
	private String käyttäjä;
	private boolean täyttyy;
	private boolean tyhjenee;
	private int täyttökatto;
	
	public Siilo(){
		raakaaine = "mallas";
		käyttäjä = null;
		täyttöaste = 0;
		täyttyy = false;
		tyhjenee = false;
		täyttökatto = 10000;
	}
	
	public int getTäyttö(){
		return täyttöaste;
	}
	
	public void setKäyttäjä(String k){
		if(käyttäjä==null){
			käyttäjä=k;
		}
	}
	public String getKäyttäjä(){
		return käyttäjä;
	}
	public void poistaKäyttäjä(){
		käyttäjä=null;
	}
	
	public void täyttö(){
		if (täyttyy == false && tyhjenee == false){
			täyttyy = true;	
			}
		}
	public void tyhjennys(){
		if (täyttyy == false && tyhjenee == false){
			tyhjenee = true;	
			}
		}
	public void toiminnanLopetus(){
		tyhjenee = false;
		täyttyy = false;	
	}
	
	
}
