package Ejemplo;

public class Empleado {
	
	private int emp_number, dept_number;
	private String name;
	private double salary;
	
	
	public Empleado (String name){
		this.name = name;
	}
	public Empleado(int emp_number, int dept_number, String name, double salary) {
		super();
		this.emp_number = emp_number;
		this.dept_number = dept_number;
		this.name = name;
		this.salary = salary;
	}

	public int getEmp_number() {
		return emp_number;
	}

	public void setEmp_number(int emp_number) {
		this.emp_number = emp_number;
	}

	public int getDept_number() {
		return dept_number;
	}

	public void setDept_number(int dept_number) {
		this.dept_number = dept_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	

}
