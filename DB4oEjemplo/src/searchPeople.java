import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class searchPeople {
	final static String DBPer = "C:/users/21443251/workspace/DBPer.yap";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona persona = new Persona("Toligo",null);
		
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBPer);
		ObjectSet<Persona> result = db.queryByExample(persona);
		
		//cuando el campo de búsqueda puede arrojar más de un registro.
		if (result.size() ==0){
			System.out.println("no hay registros con nombre "+ persona.getName());
		}else{
			System.out.println("Los resultados con "+persona.getName()+" son: "+result.size());
			while(result.hasNext()){
				Persona p = result.next();
				//update de registros, aprovecha que el result da los datos que se pondrian en el where
				p.setCity("BOMBAY");
				System.out.println(p.getName()+"\t"+p.getCity());
				db.store(p);
			}
			
		}
		
		//para campo de búsqueda único (ids, etc..) hacer el sysout directamente.
		
		if(result.size()==0){
			System.out.println("no hay registros con nombre "+ persona.getName());
		}else{
			System.out.println(result.get(0).getName()+"\t"+result.get(0).getCity());
		}
		db.close();
	}

}
