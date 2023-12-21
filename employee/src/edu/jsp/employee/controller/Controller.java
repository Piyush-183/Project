package edu.jsp.employee.controller;

import java.util.ArrayList;
import java.util.List;

import edu.jsp.employee.model.Employee;

public class Controller {

	private List<Employee> employees = new ArrayList<>();
	
	public Employee saveEmployee(Employee employee) {
		if(employee!=null) {
			employees.add(employee);
			return employee;
		} else {
			return null;
		}
	}
	
	public Employee deleteEmployee(Employee target) {
		if (target !=null) {
			for(Employee employee : employees) {
				if(employee.getId() == target.getId()) {
					employees.remove(employee);
					return employee;
				}
			}
			
			return null;
			
		} else {
			return null;
		}
	}
	  
	public List<Employee> getAllEmp(){
		return employees;
	}
	
	public Employee getEmp(int id) {
		if (id>0) {
			for (Employee employee : employees) {
				if (employee.getId()==id) {
					return employee;
				} 
			}
			return null;
		} else {
			return null;
		}
	}
	
	
	
}
