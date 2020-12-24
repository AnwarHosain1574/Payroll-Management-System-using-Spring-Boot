package com.anwar.ibcms.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anwar.ibcms.Models.Grade;

public interface GradeJPA extends JpaRepository<Grade, Long>{
	@Query("select grade_name from Grade where id = ?1")
	public String gradename(long id);
}
