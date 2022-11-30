package com.tracker.employees.service;

import java.util.List;

import com.tracker.employees.exceptions.ServiceNotFoundException;
import com.tracker.employees.model.Employee;

public interface EmpService {
	
	public List<Employee> findAllEmployees();
	
	public void addEmployee(Employee e);

	public void deleteEmployeeById(int id);
	
	public List<Employee> findEmployeeByID(int id) throws ServiceNotFoundException;
}
