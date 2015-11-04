package model;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	      HibernateHelper hibernateHelper =new HibernateHelper();
	      System.out.println("Inserto un departamento nuevo");       
	      hibernateHelper.addDepartment(40, "Technology","Berlin");
	      
	      

	}

}

