package Ejemplo;

public class Empleado {
	
	private String name, emp_number, dept_number;;
	private double salary;
	
	
	public Empleado (String name){
		this.name = name;
	}
	public Empleado(String emp_number, String dept_number, String name, double salary) {
		super();
		this.emp_number = emp_number;
		this.dept_number = dept_number;
		this.name = name;
		this.salary = salary;
	}



	public String getEmp_number() {
		return emp_number;
	}
	public void setEmp_number(String emp_number) {
		this.emp_number = emp_number;
	}
	public String getDept_number() {
		return dept_number;
	}
	public void setDept_number(String dept_number) {
		this.dept_number = dept_number;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	
	

}
