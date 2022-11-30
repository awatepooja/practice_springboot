package com.tracker.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tracker.employees.exceptions.ServiceNotFoundException;
import com.tracker.employees.model.Employee;
import com.tracker.employees.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	EmpService empService;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(required = false) String title) {
		try {
			return new ResponseEntity<>(empService.findAllEmployees(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/employee/{id}")
	public ResponseEntity<List<Employee>> getEmployeeById(@PathVariable("id") int empId) {
		try {
			List<Employee> emp = empService.findEmployeeByID(empId);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (ServiceNotFoundException e) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int empId) {
		empService.deleteEmployeeById(empId);
		return new ResponseEntity<String>("Deleted", HttpStatus.OK);
	}

	@PutMapping("/employee/add")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		try {
			empService.addEmployee(emp);
			return new ResponseEntity<>("Employee added with ID " + emp.getEmpID(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
