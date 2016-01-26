package tuotannonohjaus;

public class Siilo {
	
	private String raakaaine;
	private final int TÄYTTÖKATTO;
	private int täyttöaste;
	private String käyttäjä;
	private boolean käytössä;	
	
	public Siilo(){
		raakaaine = "mallas";
		käyttäjä = null;
		täyttöaste = 0;
		käytössä = false;
		TÄYTTÖKATTO = 10000;
	}
	//Täytön kysely ja asetus
	public int getTäyttö(){
		return täyttöaste;
	}
	public void setTäyttö(int i){
		täyttöaste = i;
	}
	//Maksimi tilavuuden kysely
	public int getTäyttökatto(){
		return TÄYTTÖKATTO;
	}
	//käyttäjän asetus, kysely ja poisto
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
	//käytössä lipun get ja set
	public void setKäytössä(boolean k){
		käytössä = k;
		}
	public boolean getKäytössä(){
		return käytössä;
	}
}
