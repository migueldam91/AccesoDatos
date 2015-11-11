package model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HibernateHelper hibernateHelper = new HibernateHelper();
		/*
		 * System.out.println("Inserto un departamento nuevo");
		 * hibernateHelper.addDepartment(60, "Operations","London");
		 */

		/*
		 * Departamento dep = hibernateHelper.getDepartamento(50);
		 * System.out.println("Departamento 50 en "+
		 * dep.getCiudad()+"\t se llama " +dep.getDnombre()); Set<Empleado>
		 * empleadosDep= dep.getEmpleados();
		 * 
		 * Iterator<Empleado> iterador = empleadosDep.iterator();
		 * while(iterador.hasNext()) iterador.next().getClass();
		 */

		/*
		 * System.out.println("Mostrar empleados departamento: \n");
		 * hibernateHelper.showDepEmp(10);
		 */

		// hibernateHelper.deleteDepartment(60);

		// hibernateHelper.updateDepartment(50, "LONDON");

		
		//Consulta de departamentos mediante list
		/*List<Departamento> lista = hibernateHelper.getDepartment2();

		Iterator<Departamento> iter = lista.iterator();

		Departamento dep = null;
		while (iter.hasNext()) {
			dep = iter.next();
			System.out.println(dep.getNumDept() + " " + dep.getDnombre() + " "
					+ dep.getCiudad());
		}

		
		*/
		//Consulta de departamentos mediante fetch
		
		//hibernateHelper.showDeps();
		
		//hibernateHelper.showUniqueDep("IT");
		
		//hibernateHelper.averageSalario();
		
		System.out.println("Fin del programa");
		System.exit(0);
	}

}
