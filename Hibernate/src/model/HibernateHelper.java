package model;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateHelper {
	private SessionFactory sesion;
	   public HibernateHelper(){         
	          sesion = SessionFactoryUtil.getSessionFactory();
	   }
	   public void addDepartment(int id, String name, String city){
	         Session session = sesion.openSession();
	         Transaction tx = session.beginTransaction();         
	         Departamento departamento = new Departamento(id,name,city, new HashSet<Empleado>(0));       
	         session.save(departamento);       
	         tx.commit();
	         session.close();
	   }

}

