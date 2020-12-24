package com.anwar.ibcms.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salary_info")
public class SalaryInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="grade")
	private long grade;
	
	@Column(name="emp_id")
	private String emp_id;	
	
	@Column(name="basic")
	private long basic;
	
	@Column(name="house_rent")
	private double house_rent;
	
	@Column(name="medical_alw")
	private double medical_alw;
	
	@Column(name="total")
	private double total;
	
	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBasic() {
		return basic;
	}

	public void setBasic(long basic) {
		this.basic = basic;
	}

	public double getHouse_rent() {
		return house_rent;
	}

	public void setHouse_rent(double house_rent) {
		this.house_rent = house_rent;
	}

	public double getMedical_alw() {
		return medical_alw;
	}

	public void setMedical_alw(double medical_alw) {
		this.medical_alw = medical_alw;
	}

	public long getGrade() {
		return grade;
	}

	public void setGrade(long grade) {
		this.grade = grade;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	

}
