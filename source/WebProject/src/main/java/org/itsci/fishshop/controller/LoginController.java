 package org.itsci.fishshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.itsci.fishshop.model.Register;
import org.itsci.fishshop.dao.LoginManager;

 @Controller
public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
    public String loadindex() {
        return "index";
    }
	
	@RequestMapping(value="/account", method=RequestMethod.GET)
    public String loadaccount(HttpServletRequest request, Model md, HttpSession session) {
		
        return "index";
    }
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loadLoginPage() {
		return "index";
	}
	
	@RequestMapping(value="/Admin", method=RequestMethod.GET)
    public String loadadmin() {
        return "Admin";
    }

	@RequestMapping(value="/loadlogin", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request, Model md, HttpSession session) {
		String Email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		
		Register lb = new Register (0,"","","",Email,Password,"");
		LoginManager  sm = new LoginManager();
		lb = sm.verifyLogin(lb);
		if(lb != null) {
			md.addAttribute("res", lb.getEmail());
			session.setAttribute("User", lb);
			session.setAttribute("Email",lb.getEmail());
			return "index";
		}else {
			session.setAttribute("login","ข้อมูลผู้ใช้งานไม่ตรงกัน");
			return "Login";
		}
		
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String loadlogoutPage(HttpServletRequest request,HttpSession session) {
		session.removeAttribute("user");
		session.removeAttribute("Admin");
		return "index";
	}
	
	
}

