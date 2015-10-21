import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class showPeople {
	final static String DBPer = "C:/users/21443251/workspace/DBPer.yap";
	
	public static void main (String [] args){
		Persona persona = new Persona(null,null);
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBPer);
		ObjectSet<Persona> result = db.queryByExample(persona);
		
		if (result.size() ==0){
			System.out.println("no hay registros");
		}else{
			while(result.hasNext()){
				Persona p = result.next();
				System.out.println(p.getName()+"\t"+p.getCity());
			}
			db.close();
		}
	}
}
