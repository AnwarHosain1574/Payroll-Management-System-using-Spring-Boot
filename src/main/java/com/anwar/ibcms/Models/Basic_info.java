package com.anwar.ibcms.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="basic_info")
public class Basic_info {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name = "basic")
	private long basic;
	
	@Column(name = "acc_bal")
	private double acc_bal;

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

	public double getAcc_bal() {
		return acc_bal;
	}

	public void setAcc_bal(double acc_bal) {
		this.acc_bal = acc_bal;
	}

}
