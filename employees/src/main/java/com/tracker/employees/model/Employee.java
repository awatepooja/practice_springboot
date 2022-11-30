package com.tracker.employees.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
	
	public Employee() {
		super();
	}

	public Employee(int empID, String empName, Long salary, String designation) {
		
		this.empID = empID;
		this.empName = empName;
		this.salary = salary;
		this.designation = designation;
	}

	@Id
	private int empID;

	@Column
	public String empName;

	@Column
	public Long salary;

	@Column
	public String designation;

	@Override
	public String toString() {
		return "Employee [id=" + empID + ", empName=" + empName + ", salary=" + salary + ", designation=" + designation
				+ "]";
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
