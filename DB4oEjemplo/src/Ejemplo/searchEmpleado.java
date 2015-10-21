package Ejemplo;


import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class searchEmpleado {
	
	final static String DBEmp = "C:/users/21443251/workspace/DBEmp.yap";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Empleado empleado = new Empleado("Miguel Alonso");
		Departamento departamento;
		departamento =new Departamento(null);
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBEmp);
		ObjectSet<Empleado> result = db.queryByExample(empleado);
		
		
		ObjectSet<Departamento> resultd;
		
		
		//cuando el campo de búsqueda puede arrojar más de un registro.
		if (result.size() ==0){
			System.out.println("no hay registros con nombre "+ empleado.getName());
		}else{
			resultd= db.queryByExample(departamento);
			for(int i =0 ; i<resultd.size();i++)
				if(result.get(0).getDept_number()==resultd.get(i).getDept_number())
					departamento=resultd.get(i);
			
			System.out.println("Departamento "+departamento.getDname());
			
			while(result.hasNext()){
				Empleado emp = result.next();
				System.out.println(emp.getDept_number()+"\t"+emp.getName()+"\t"+emp.getSalary());
				db.store(emp);
			}
			
		}
		db.close();
		
		//para campo de búsqueda único (ids, etc..) hacer el sysout directamente.
		/*
		if(result.size()==0){
			System.out.println("no hay registros con nombre "+ emp.getName());
		}else{
			System.out.println(result.get(0).getName()+"\t"+result.get(0).emp());
		}
		db.close();*/
	}

}
