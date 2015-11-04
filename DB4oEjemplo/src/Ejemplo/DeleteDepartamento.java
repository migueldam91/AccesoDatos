package Ejemplo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;


public class DeleteDepartamento {
	final static String DBEMP = "C:/users/21443251/workspace/DBEmp.yap";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Departamento departamento= new Departamento(null,null,null);
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBEMP);
		ObjectSet<Departamento> result = db.queryByExample(departamento);
		
		if(result.size()==0){
			System.out.println("No existe tal registro");
		}else{
			while(result.hasNext()){
				Departamento p1 = result.next();
				db.delete(p1);
				System.out.println("Borrado "+p1.getDname());
			}
		}
		db.close();
		
	}
}
