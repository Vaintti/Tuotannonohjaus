import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Palvelin {
	public static void main(String[] args){
		// Luodaan laitoksen osat
		Ruuvikuljetin a = new Ruuvikuljetin(true);
		Siilo[] b = {new Siilo(), new Siilo(), new Siilo(), new Siilo()};
		Ruuvikuljetin[] c = {new Ruuvikuljetin(false), new Ruuvikuljetin(false)};
		Juomakeitin[] d = {new Juomakeitin(), new Juomakeitin(), new Juomakeitin()};
		Pumppu[] e = {new Pumppu(), new Pumppu()};
		Kypsytyssäiliö[] f = new Kypsytyssäiliö[10];
		for(int i = 0; i < 10; i++){
			f[i] = new Kypsytyssäiliö();
		}
		Pumppu[] g = {new Pumppu(), new Pumppu()};
		try{
			// Luodaan osista laitos
			/**if(System.getSecurityManager()==null){
				System.setSecurityManager(new RMISecurityManager());
			}**/
			Laitos laitos = new Laitos(a, b, c, d, e, f, g);
			Registry registry = LocateRegistry.createRegistry(2020);
			Naming.rebind("//localhost:2020/Laitos", laitos);
			System.out.println("Serveri käynnistetty.");
		}catch(Exception expe){
			System.out.println("Error: "+expe);
		}
	}
}
