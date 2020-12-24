package com.anwar.ibcms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anwar.ibcms.JPA.BankInfoJPA;
import com.anwar.ibcms.JPA.EmployeeJPA;
import com.anwar.ibcms.JPA.GradeJPA;
import com.anwar.ibcms.JPA.SalaryInfoJPA;
import com.anwar.ibcms.Models.BankInfo;
import com.anwar.ibcms.Models.Employee;
import com.anwar.ibcms.Models.Grade;
import com.anwar.ibcms.Models.SalaryInfo;

@Controller
public class EmployeeController {
	
	@Autowired
	private GradeJPA gradejpa;
	
	@Autowired
	private EmployeeJPA empjpa;
	
	@Autowired
	private SalaryInfoJPA salaryjpa;
	
	@Autowired
	private BankInfoJPA bankjpa;
	//Home Directory
	@RequestMapping("/employee")
	public String index(Model model)
	{
		List<Grade> gradelist = gradejpa.findAll();
		model.addAttribute("gradelist",gradelist);
		
		Employee emp = new Employee();
		model.addAttribute("empobj",emp);
		
		BankInfo bankobj = new BankInfo();
		model.addAttribute("bankobj",bankobj);
		return "pages/employee/index";
	}
	
	@PostMapping("/employee/save")
	public String save(Model model, @ModelAttribute("") Employee emp,
			@Param("grade") long grade,
			@Param("bankname") String bankname,
			@Param("bankbranchname") String bankbranchname,
			@Param("acctype") String acctype,
			@Param("accountno") String accountno)
	{
		emp.setGrade(grade);
		
		//Unique Id Generator
		String maxid = empjpa.maxid();
		long lastno = 0;
		if(maxid==null) lastno = 0;
		else lastno = Long.parseLong(maxid);
		String idno = String.format("%04d", lastno+1);
		emp.setIdno(idno);
		empjpa.save(emp);

		//update salary Info
		SalaryInfo salary = new SalaryInfo();
		long basic = 5000 * (7-grade);
		double house_rent = basic * 0.2;
		double medical_alw = basic * 0.15;
		double total = basic+house_rent+medical_alw;
		salary.setBasic(basic);
		salary.setHouse_rent(house_rent);
		salary.setMedical_alw(medical_alw);
		salary.setEmp_id(idno);
		salary.setTotal(total);
		salary.setGrade(grade);
		salaryjpa.save(salary);
		
		//Bank Information Update
		
		BankInfo bank = new BankInfo();
		bank.setBank_name(bankname);
		bank.setBranch_name(bankbranchname);
		bank.setCurrent_balance(0);
		bank.setAcc_name(emp.getName());
		bank.setEmp_id(idno);
		bank.setAcc_number(accountno);
		bank.setAcc_type(acctype);
		bankjpa.save(bank);
		
		
		System.out.println("Employee Information Updated and Salary Information Updated");
		return "redirect:/";
	}
	
	@RequestMapping("/employee/edit/{id}")
	public String cusedit(@PathVariable(name="id") String id, Model model)
	{
		List<Grade> gradelist = gradejpa.findAll();
		model.addAttribute("gradelist",gradelist);
		
		Employee empobj = empjpa.searchforedit(id);
		model.addAttribute("empobj",empobj);
		return "pages/employee/index";
	}
	
	@RequestMapping("/employee/delete/{id}")
	public String cusedit(@PathVariable(name="id") long id, Model model)
	{
		Employee empobj = empjpa.findById(id).get();		
		String empid = empobj.getIdno();		
		SalaryInfo salaryobj = salaryjpa.idwiseinfo(empid);		
		salaryjpa.delete(salaryobj);		
		empjpa.delete(empobj);
		return "redirect:/";
	}
	

}
