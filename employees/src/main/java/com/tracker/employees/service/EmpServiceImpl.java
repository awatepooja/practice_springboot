package com.tracker.employees.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tracker.employees.exceptions.ServiceNotFoundException;
import com.tracker.employees.model.Employee;
import com.tracker.employees.repo.EmpRepository;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	public EmpRepository empRepo;

	@Override
	public List<Employee> findAllEmployees() {

		return empRepo.findAll();
	}

	@Override
	public List<Employee> findEmployeeByID(int id) throws ServiceNotFoundException {

		List<Employee> employeeList = findAllEmployees();

		List<Employee> emp = employeeList.stream().filter(e -> e.getEmpID() == id).collect(Collectors.toList());
		if (!emp.equals(null) && emp != null && !emp.isEmpty()) {
			return emp;
		}

		else {
			throw new ServiceNotFoundException();
		}

	}
	/*
	 * @Override public Employee findEmployeeById(int id) {
	 * 
	 * Optional<Employee> empDetails = empRepo.findById(id); return
	 * empDetails.get(); }
	 */

	@Override
	public void deleteEmployeeById(int id) {

		empRepo.deleteById(id);

	}

	@Override
	public void addEmployee(Employee e) {

		empRepo.save(e);
	}

}
