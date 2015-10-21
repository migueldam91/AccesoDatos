import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class removePeople {
	final static String DBPer = "C:/users/21443251/workspace/DBPer.yap";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona = new Persona(null,"Bangladesh");
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBPer);
		ObjectSet<Persona> result = db.queryByExample(persona);
		
		if(result.size()==0){
			System.out.println("No existe tal registro");
		}else{
			while(result.hasNext()){
				Persona p1 = result.next();
				db.delete(p1);
				System.out.println("Borrado "+p1.getName());
			}
		}
		db.close();
		
	}

}
