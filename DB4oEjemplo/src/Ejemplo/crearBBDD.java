package Ejemplo;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class crearBBDD {
	final static String DBEmp = "C:/users/21443251/workspace/DBEmp.yap";
	public static void main(String[] args) {
		
				ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),DBEmp);
				
				Departamento d1 = new Departamento("Accounting","Madrid","10");
				Departamento d2 = new Departamento("Marketing","Madrid","20");
				Departamento d3 = new Departamento("Operations","Madrid","30");
				db.store(d1);db.store(d2);db.store(d3);
				
				/*Empleado e1= new Empleado("1","10","Alfonso Alonso",1200);
				Empleado e2= new Empleado("2","20","Miguel Alonso",1300);
				Empleado e3= new Empleado("3","30","Jaime Alonso",1400);
				Empleado e4= new Empleado("4","30","Miguel Alonso",1400);
				db.store(e1);db.store(e2);db.store(e3);db.store(e4);
				db.close();*/
				System.out.println("db cerrada");
				
			}


	}


