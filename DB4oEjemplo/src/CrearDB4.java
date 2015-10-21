import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;


public class CrearDB4 {

	final static String DBPer = "C:/users/21443251/workspace/DBPer.yap";
	
	public static void main(String[] args) {
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBPer);
		
		/*Persona p1 = new Persona("Manolo","Bombay");
		Persona p2 = new Persona("Manolo","Bombay");
		Persona p3 = new Persona("Manolo","Bombay");
		Persona p4 = new Persona("Manolo","Bombay");
		
		
		db.store(p1);
		db.store(p2);
		db.store(p3);
		db.store(p4);*/
		Persona p1 = new Persona("Toligo","Bangladesh");
		db.store(p1);
		
		db.close();
		
		
	}

}
