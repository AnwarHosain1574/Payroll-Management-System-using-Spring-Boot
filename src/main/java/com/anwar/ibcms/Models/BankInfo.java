package com.anwar.ibcms.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank_info")
public class BankInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name = "acc_name")
	private String acc_name;
	
	@Column(name = "acc_number")
	private String acc_number;
	
	@Column(name = "acc_type")
	private String acc_type;
	
	@Column(name = "current_balance")
	private double current_balance;
	
	@Column(name = "bank_name")
	private String bank_name;
	
	@Column(name = "branch_name")
	private String branch_name;
	
	@Column(name = "emp_id")
	private String emp_id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAcc_name() {
		return acc_name;
	}

	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}

	public String getAcc_number() {
		return acc_number;
	}

	public void setAcc_number(String acc_number) {
		this.acc_number = acc_number;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public double getCurrent_balance() {
		return current_balance;
	}

	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
	

}
