package com.anwar.ibcms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.anwar.ibcms.JPA.BasicInfoJPA;
import com.anwar.ibcms.JPA.EmployeeJPA;
import com.anwar.ibcms.JPA.SalaryInfoJPA;
import com.anwar.ibcms.Models.Basic_info;
import com.anwar.ibcms.Models.Employee;

@Controller
public class PagesController {
	
	@Autowired
	private SalaryInfoJPA salaryjpa;
	
	@Autowired
	private BasicInfoJPA basicjpa;

	@Autowired
	private EmployeeJPA empjpa;
	
	//Home Directory
	@RequestMapping(value = {"/","/home"})
	public String index(Model model)
	{
		return "pages/index";
	}
	
	@RequestMapping("/company-information")
	public String company(Model model)
	{
		double companycurbal = basicjpa.currentaccountbalance();

		model.addAttribute("restofbal",companycurbal);
		return "pages/company/index";
	}
	
	@RequestMapping("/remaining-balance")
	public String remaining(Model model)
	{
		return "pages/company/remaining";
	}
	

}
