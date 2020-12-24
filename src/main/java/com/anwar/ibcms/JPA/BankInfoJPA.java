package com.anwar.ibcms.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anwar.ibcms.Models.BankInfo;

public interface BankInfoJPA extends JpaRepository<BankInfo, Long>{
	
	@Query("select b from BankInfo b where emp_id = ?1")
	public BankInfo findbyempid(String idno);

}
