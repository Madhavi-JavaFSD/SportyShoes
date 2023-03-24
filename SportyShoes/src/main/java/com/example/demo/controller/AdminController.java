
package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest; import
javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.Customer;
import
com.example.demo.service.AdminDAO;
@Controller
public class AdminController {

	@Autowired AdminDAO dao;
	Logger log=Logger.getAnonymousLogger();

	@RequestMapping("/") public ModelAndView displaypage(HttpServletRequest	request,HttpServletResponse response) 
	{ 
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp"); return mv; 
	}

	@RequestMapping("/addAdmin") 
	public ModelAndView insertControl(HttpServletRequest request,HttpServletResponse response) 
	{

		ModelAndView mv=new ModelAndView(); 
		Admin a = new Admin();
		log.info("in addAdmin");
		//a.setEmpno(Integer.parseInt(request.getParameter("adminID")));
		a.setAdminName(request.getParameter("adminName"));
		a.setAdminEmail(request.getParameter("adminEmail"));
		a.setAdminPassword(request.getParameter("adminPassword"));
		Admin ep = dao.addAdmin(a); 
		if(ep != null) 
		{ 
			mv.setViewName("display.jsp"); 
		} 
		return mv;
	}

	@RequestMapping("/getAllAdmin") public ModelAndView displayAll(HttpServletRequest request,HttpServletResponse response) 
	{
		log.info("in getAllAdmin");
		ModelAndView mv = new ModelAndView();
		List<Admin> list = dao.getAllAdmin();
		mv.setViewName("displayres.jsp"); 
		mv.addObject("list",list); return mv; 
	}
	@GetMapping("/checkIfAdmin")
	public ModelAndView checkIfAdmin(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		String sAdminEmail = request.getParameter("adminEmail");
		String sAdminPass = request.getParameter("adminPass");
		if(sAdminEmail != null && sAdminEmail.length()>0)
		{
			if(sAdminPass != null && sAdminPass.length()>0)
			{
				log.info("Admin name in checkIfAdmin--" + sAdminEmail);
				log.info("Admin password in checkIfAdmin--" + sAdminPass);
				Admin adminNow = dao.findByEmail(sAdminEmail);
				if(adminNow != null) {
					log.info("Admin present name--" + adminNow.getAdminName());
					log.info("Admin present id--" + adminNow.getAdminID());
					boolean isPasswordCorrect= dao.checkPassword(sAdminEmail,sAdminPass);
					if(isPasswordCorrect)
					{
						log.info("isPasswordCorrect---" +isPasswordCorrect);
						HttpSession session=request.getSession();
						session.setAttribute("sessionAdminEmail",sAdminEmail);
						session.setAttribute("sessionAdminPass",sAdminPass);
						mv.setViewName("AdminHomePage.jsp");
					}
					else
					{
						request.setAttribute("ErrorText", "Incorrect Username or Password.Please try again!");
						mv.setViewName("ErrorMsg.jsp");
					}
				}
				else
				{
					request.setAttribute("ErrorText", "You are not a registered customer. Please click on 'Register' "
							+ "and enter your details to create an account with Sporty Shoes.");
					mv.setViewName("ErrorMsg.jsp");
				}
			}
			else {
				request.setAttribute("ErrorText", "Please enter both Username and Password to start!");
				mv.setViewName("ErrorMsg.jsp");
			}			
		}
		else {
			request.setAttribute("ErrorText", "Please enter both Username and Password to start!");
			mv.setViewName("ErrorMsg.jsp");
		}
		return mv;	
	}
	@GetMapping("/adminLogout")
	public ModelAndView customerLogout(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session=request.getSession();
		session.invalidate();
		log.info("Admin Logged out");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;		
	}
}
