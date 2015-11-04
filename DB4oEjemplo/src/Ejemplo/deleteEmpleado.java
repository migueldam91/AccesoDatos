package Ejemplo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class deleteEmpleado {
	final static String DBEMP = "C:/users/21443251/workspace/DBEmp.yap";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado(null,null,null,0);
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBEMP);
		ObjectSet<Empleado> result = db.queryByExample(empleado);
		
		if(result.size()==0){
			System.out.println("No existe tal registro");
		}else{
			while(result.hasNext()){
				Empleado p1 = result.next();
				db.delete(p1);
				System.out.println("Borrado "+p1.getName());
			}
		}
		db.close();
		
	}
}
