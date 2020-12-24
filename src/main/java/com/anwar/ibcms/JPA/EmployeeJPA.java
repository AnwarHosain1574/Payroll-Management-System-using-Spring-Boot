package com.anwar.ibcms.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anwar.ibcms.Models.Employee;

public interface EmployeeJPA extends JpaRepository<Employee, Long>{
	
	@Query("select max(id) from Employee")
	public String maxid();
	
	@Query("select e from Employee e where e.idno = ?1")
	public Employee searchforedit(String id);

}
