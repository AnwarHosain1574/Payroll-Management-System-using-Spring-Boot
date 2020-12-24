package com.anwar.ibcms.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anwar.ibcms.Models.SalaryInfo;

public interface SalaryInfoJPA extends JpaRepository<SalaryInfo, Long>{
	
	@Query("select s from SalaryInfo s where s.emp_id = ?1")
	public SalaryInfo idwiseinfo(String idno);
	
	@Query("select sum(total) from SalaryInfo")
	public double totalsalary();
	
	@Query("select total from SalaryInfo where emp_id = ?1")
	public double owntotalsalary(String idno);
	
	
}
