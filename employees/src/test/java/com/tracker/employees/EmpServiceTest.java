package com.tracker.employees;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tracker.employees.exceptions.ServiceNotFoundException;
import com.tracker.employees.model.Employee;
import com.tracker.employees.service.EmpService;

@SpringBootTest
public class EmpServiceTest {
	
	
	@Autowired
	EmpService empService;

	@Test
	public void findAllEmployeesTest() {
		List<Employee> e = empService.findAllEmployees();
		Assertions.assertFalse(e.isEmpty());
	}
	
	@Test
	public void findEmployeeByIDTest() throws ServiceNotFoundException {
		List<Employee> e = empService.findEmployeeByID(1);
		Assertions.assertFalse(e.isEmpty());
	}
	
	@Test
	public void addEmployeeTest() {
		Employee e = new Employee(4545,"dummy", 0L, "dummy");
		empService.addEmployee(e);
		
	}
}
