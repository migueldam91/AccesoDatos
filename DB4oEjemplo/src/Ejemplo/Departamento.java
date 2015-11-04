package Ejemplo;

public class Departamento {
	private String dname, city,dept_number;

	
	public Departamento(){
		
	}
	public Departamento(String dname){
		this.dname = dname;
	}
	
	public Departamento(String dname, String city, String dept_number) {
		super();
		this.dname = dname;
		this.city = city;
		this.dept_number = dept_number;
	}
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDept_number() {
		return dept_number;
	}
	public void setDept_number(String dept_number) {
		this.dept_number = dept_number;
	}

	
	

}
