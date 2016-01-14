import java.rmi.Naming;

public class JuomamestariPalvelin implements Runnable {
	
	private String nimi;
	
	public JuomamestariPalvelin(String n){
		nimi = n;
	}
	
	public void run() {
		try{
			JuomamestariImplementaatio juomamestari = new JuomamestariImplementaatio(nimi);
			Naming.rebind(nimi, juomamestari);
		}catch(Exception e){
			System.out.println("Error "+e);
		}
	}
}
