package com.anwar.ibcms.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anwar.ibcms.Models.Basic_info;

public interface BasicInfoJPA extends JpaRepository<Basic_info, Long>{
	@Query("select acc_bal from Basic_info where id = 1")
	public double currentaccountbalance();
	
	@Query("select b from Basic_info b where id = 1")
	public Basic_info fullobject();
	
}
