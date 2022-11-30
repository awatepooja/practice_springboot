package com.tracker.employees.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tracker.employees.model.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	/*
	 * @Query("select e from employee e where e.empID = :id") public
	 * Optional<Employee> findById( @Param("id") int id);
	 */	
	

}
