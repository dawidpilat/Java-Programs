package pl.company.java;
import java.util.ArrayList;
import java.util.List;

import pl.company.java.domain.Employee;



public class EmployeeDAO {

	static List<Employee> employees = new ArrayList<Employee>();
	
	public void add(Employee employee) {
		employees.add(employee);
	}
	
	
	public void delete(Employee employee) {
		employees.remove(employee);
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public List<Employee> sort() {
		return employees;
	}
	
}
