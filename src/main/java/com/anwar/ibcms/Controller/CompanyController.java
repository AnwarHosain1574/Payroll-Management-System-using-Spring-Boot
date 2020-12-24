package com.anwar.ibcms.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anwar.ibcms.JPA.BankInfoJPA;
import com.anwar.ibcms.JPA.BasicInfoJPA;
import com.anwar.ibcms.JPA.EmployeeJPA;
import com.anwar.ibcms.JPA.GradeJPA;
import com.anwar.ibcms.JPA.SalaryInfoJPA;
import com.anwar.ibcms.Models.BankInfo;
import com.anwar.ibcms.Models.Basic_info;
import com.anwar.ibcms.Models.Employee;
import com.anwar.ibcms.Models.HelperModel;
import com.anwar.ibcms.Models.SalaryInfo;

@Controller
public class CompanyController {
	
	@Autowired
	private SalaryInfoJPA salaryjpa;
	
	@Autowired
	private BasicInfoJPA basicjpa;
	
	@Autowired
	private EmployeeJPA empjpa;
	
	@Autowired
	private BankInfoJPA bankjpa;
	
	@Autowired
	private GradeJPA gradejpa;
	
	@RequestMapping("/salary-transfer")
	public String remaining(RedirectAttributes redirectAttributes)
	{
		double companycurbal = basicjpa.currentaccountbalance();
		double totalempsalary = salaryjpa.totalsalary();
		
		double restofbal = companycurbal - totalempsalary;
		if(restofbal>=0)
		{
			List<Employee> emplist = empjpa.findAll();
			
			double summationofall = 0;
			
			//Salary Transfer
			for(int i = 0; i<emplist.size(); i++)
			{
				System.out.println("Number of emp: "+emplist.size());
				String idno = emplist.get(i).getIdno();
				BankInfo bank = bankjpa.findbyempid(idno);
				double ownsal = salaryjpa.owntotalsalary(idno);
				bank.setCurrent_balance(ownsal);
				bankjpa.save(bank);
				summationofall+=ownsal;
				System.out.println("Own Salary: "+ownsal);
			}
			
			companycurbal = companycurbal-summationofall;
			//Company Balance Update
			Basic_info basic = basicjpa.fullobject();
			basic.setAcc_bal(companycurbal);
			basicjpa.save(basic);
			
			redirectAttributes.addFlashAttribute("message", "success");
		}else {
			redirectAttributes.addFlashAttribute("message", "error");
		}
		
		//redirectAttributes.addFlashAttribute("message", "Salary Transfered Successful.");
		return "redirect:/company-information";
	}
	
	@RequestMapping("/salary-sheet")
	public String salarysheet(Model model)
	{
		List<Employee> emplist = empjpa.findAll();
		
		List<SalaryInfo> salaryinfo = new ArrayList<SalaryInfo>();
		
		for(int i = 0; i<emplist.size(); i++)
		{
			salaryinfo.add(salaryjpa.idwiseinfo(emplist.get(i).getIdno()));
		}
		
		List<HelperModel> list = new ArrayList<HelperModel>();
		for(int i = 0; i<emplist.size(); i++)
		{
			HelperModel hlpmodel = new HelperModel();
			hlpmodel.setId(emplist.get(i).getIdno());
			hlpmodel.setName(emplist.get(i).getName());
			hlpmodel.setRank(gradejpa.gradename(emplist.get(i).getGrade()));
			hlpmodel.setSalary(salaryinfo.get(i).getTotal());
			list.add(hlpmodel);
		}
		
		
		model.addAttribute("emplist",list);
		return "pages/company/salarysheet";
	}

}
