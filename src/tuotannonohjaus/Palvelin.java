package tuotannonohjaus;
import java.rmi.*;
import java.rmi.registry.*;

public class Palvelin {
	public static void main(String[] args){
		// Luodaan laitoksen osat
		Ruuvikuljetin a = new Ruuvikuljetin(true);
		Siilo[] b = {new Siilo(), new Siilo(), new Siilo(), new Siilo()};
		Ruuvikuljetin[] c = {new Ruuvikuljetin(false), new Ruuvikuljetin(false)};
		Juomakeitin[] d = {new Juomakeitin(), new Juomakeitin(), new Juomakeitin()};
		Pumppu[] e = {new Pumppu(false), new Pumppu(false)};
		Kypsytyssäiliö[] f = new Kypsytyssäiliö[10];
		for(int i = 0; i < 10; i++){
			f[i] = new Kypsytyssäiliö();
		}
		Pumppu[] g = {new Pumppu(true), new Pumppu(true)};
		try{
			Laitos laitos = new Laitos(a, b, c, d, e, f, g);
			Registry registry = LocateRegistry.createRegistry(2020);
			Naming.rebind("//127.0.0.1:2020/laitos", laitos);
			System.out.println("Serveri käynnistetty.");
		}catch(Exception expe){
			System.out.println("Error: "+expe);
		}
	}
}
