package com.anwar.ibcms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anwar.ibcms.JPA.BasicInfoJPA;
import com.anwar.ibcms.Models.Basic_info;

@Controller
public class BasicInfoController {
	
	@Autowired
	private BasicInfoJPA basicjpa;
	
	//Basic Setup Directory
	@RequestMapping("/basic-information")
	public String index(Model model)
	{
		long id = 1;
		Basic_info basic = basicjpa.findById(id).get();
		model.addAttribute("basicobj",basic);
		return "pages/employee/basic";
	}
	
	@PostMapping("/basic/save")
	public String save(Model model, @ModelAttribute("")Basic_info basicinfo)
	{
		basicjpa.save(basicinfo);
		return "redirect:/basic-information";
	}

}
