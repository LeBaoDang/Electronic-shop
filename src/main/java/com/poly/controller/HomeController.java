package com.poly.controller;


import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.poly.entitys.Account;
import com.poly.service.AccountService;
import com.poly.service.AuthorityService;
import com.poly.service.RoleService;

@Controller
public class HomeController {
	
	@Autowired 
	AccountService accountser;
	
	@Autowired
	AuthorityService authoSer;
	
	@Autowired
	RoleService roleSer;
	
	
	@RequestMapping({"/","/home/index"})
	public String home() {
		return "redirect:/product/list";
	}

	@RequestMapping({"/admin","/admin/home/index"})
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
	
	@GetMapping("/register")
	public String doGetRegister(Model model) {
		model.addAttribute("userRequest",new Account());
		return "security/register";
	}
	
	@PostMapping("/register")
	public String doPostRegister(@ModelAttribute("userRequest") Account userRequest) {
		try {
			Account userResponse = accountser.save(userRequest);
			if(ObjectUtils.isNotEmpty(userResponse)) {
				return "redirect:/home/index";
			} else {
				return "redirect:/register";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/register";
		}
	}
}
