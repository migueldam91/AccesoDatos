package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateHelper {
	private SessionFactory sesion;

	public HibernateHelper() {
		sesion = SessionFactoryUtil.getSessionFactory();
	}

	public void addDepartment(int id, String name, String city) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Departamento departamento = new Departamento(id, name, city,
				new HashSet<Empleado>(0));
		session.save(departamento);
		tx.commit();
		session.close();
	}

	public Departamento getDepartamento(int id) {

		Session session = sesion.openSession();
		Departamento dep = null;
		if (id != -1) {
			dep = (Departamento) session.get(Departamento.class, id);
		}
		if (dep == null) {
			dep = new Departamento();
		}

		session.close();

		return dep;
	}

	public void showDepEmp(int id) {
		Session session = sesion.openSession();
		// Obtener empleado
		// Departamento dep = (Departamento) session.get(Departamento.class,
		// id);
		Departamento dep = null;
		dep = (Departamento) session.get(Departamento.class, id);
		if (dep != null) {
			System.out.println("Cod: " + dep.getNumDept() + ", nombre: "
					+ dep.getDnombre() + ", ciudad: " + dep.getCiudad());
			// Obtener una lista de empleados del departamento
			Set<Empleado> listaemp = dep.getEmpleados();
			// Copiamos la lista a un iterador
			Iterator<Empleado> it = listaemp.iterator();
			System.out.println("Lista de empleados");
			// Iterador recorre set para mostrar empleados
			while (it.hasNext()) {
				Empleado emp = new Empleado();
				emp = it.next();
				System.out.println(emp.getNumEmp() + " " + emp.getNombre());
			}
		} else {
			System.out.println("no existe ese departamento");
		}

		session.close();
	}

	public void deleteDepartment(int id) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Departamento dep = (Departamento) session.get(Departamento.class, id);
		if (dep != null) {
			System.out.println("departamento borrado");
			session.delete(dep);
			System.out.println("Borrado departamento");
			tx.commit();
		} else {
			System.out.println("No existe el departamento " + id);
		}

		session.close();
	}

	public void updateDepartment(int id, String nomCity, String nomDept) {
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		Departamento dep = (Departamento) session.get(Departamento.class, id);

		if (dep == null) {
			System.out.println("No existe tal departamento");
		} else {
			dep.setCiudad(nomCity);
			session.update(dep);
		}
		System.out.println("Cambio de la ciudad " + dep.getCiudad());

		tx.commit();
		session.close();
	}

	public List<Departamento> getDepartment2() {
		// abrimos sesion
		Session session = sesion.openSession();
		// Creamos lista
		List<Departamento> deps;
		// crea consulta
		Query query = session.createQuery("from Departamento");
		// almacena el resultado
		deps = query.list();
		// cierra sesion
		session.close();

		return deps;
	}

	public void showDeps() {
		Session session = sesion.openSession();
		Departamento dep = new Departamento();
		Query q = session.createQuery("from Departamento");
		q.setFetchSize(10);
		Iterator iter = q.iterate();
		while (iter.hasNext()) {
			dep = (Departamento) iter.next();
			System.out.println(dep.getNumDept() + " " + dep.getDnombre() + " "
					+ dep.getCiudad());
		}
		session.close();
	}
	
	public void showUniqueDep(String nomDept){
		Session session = sesion.openSession();
		Departamento dep =  (Departamento) session.createQuery("from Departamento where dnombre =?")
				.setString(0, nomDept).uniqueResult();
		
		System.out.println(dep.getNumDept()+" "+dep.getDnombre()+" "+dep.getCiudad());
		session.close();
	}
	//Dummy method
	public void averageSalario(){
		Session session = sesion.openSession();
		Query cons = session.createQuery("select avg(salario) from Empleado");
	   	Double media = (Double) cons.uniqueResult();
	   	System.out.println("Media:"+media);
	   	session.close();
	}
	
	//proyecto con todos estos métodos y una interfaz gráfica.
	
	//Falta insert,update,delete!!!! lo ven viernes 13

}
