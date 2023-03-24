package com.example.demo.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customer;
import com.example.demo.model.Shoe;
import com.example.demo.service.CustomerDAO;

@Controller
public class CustomerController {

	@Autowired
	CustomerDAO dao;
	Logger log = Logger.getAnonymousLogger();

	@RequestMapping("/getAllCustomer")
	public ModelAndView displayAll(HttpServletRequest request, HttpServletResponse response) {
		log.info("in getAllCustomer");
		ModelAndView mv = new ModelAndView();
		List<Customer> list = dao.getAllcust();
		mv.setViewName("AdminDisplayCustomers.jsp");
		mv.addObject("list", list);
		return mv;
	}
	@GetMapping("/getCustomerByname")
	public ModelAndView findbyname(HttpServletRequest request, HttpServletResponse response){
		log.info("Cust name in controller--" + request.getParameter("customerName"));
		//return dao.findbyname(name);
		ModelAndView mv = new ModelAndView();
		List<Customer> list = dao.findbyname(request.getParameter("customerName"));
		mv.setViewName("AdminDisplayCustomers.jsp");
		mv.addObject("list", list);
		return mv;	
	}
	@RequestMapping("/addCustomer")
	public ModelAndView insertControl(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		Customer a = new Customer();
		log.info("---in addCustomer---");
		String sCustEmail = request.getParameter("custEmail");
		String sCustPass = request.getParameter("custPass");
		String sCustName = request.getParameter("custName");
		if(sCustName != null && sCustName.length()>0)
		{
			if(sCustEmail != null && sCustEmail.length()>0)
			{
				if(sCustPass != null && sCustPass.length()>0)
				{
					Customer cust = dao.findByEmail(sCustEmail);
					if(cust != null)
					{
						request.setAttribute("ErrorText", "The email ID- " + sCustEmail + " is already registered. "
								+ "Please try to register with a different email ID.");
						mv.setViewName("ErrorMsg.jsp");
					}
					else
					{
						a.setCustName(sCustName);
						a.setCustEmail(sCustEmail);
						a.setCustPassword(sCustPass);
						Customer ep = dao.addcust(a);
						if (ep != null) {
							HttpSession session=request.getSession();
							session.setAttribute("sessionCustEmail",sCustEmail);
							session.setAttribute("sessionCustPass",sCustPass);
							mv.setViewName("CustHomePage.jsp");
						}
						else {
							request.setAttribute("ErrorText", "Customer could not be added to the database.<br>Please try again later");
							mv.setViewName("ErrorMsg.jsp");
						}		
					}									
				}
				else
				{
					request.setAttribute("ErrorText", "Please enter all 3- Username,Email and Password to register!");
					mv.setViewName("ErrorMsg.jsp");
				}
			}
			else
			{
				request.setAttribute("ErrorText", "Please enter all 3- Username,Email and Password to register!");
				mv.setViewName("ErrorMsg.jsp");
			}
		}
		else
		{
			request.setAttribute("ErrorText", "Please enter all 3- Username,Email and Password to register!");
			mv.setViewName("ErrorMsg.jsp");
		}		
		return mv;
	}
	@GetMapping("/checkIfCustomer")
	public ModelAndView checkIfCustomer(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		String sCustEmail = request.getParameter("custEmail");
		String sCustPass = request.getParameter("custPass");
		if(sCustEmail != null && sCustEmail.length()>0)
		{
			if(sCustPass != null && sCustPass.length()>0)
			{
				log.info("Cust name in checkIfCustomer--" + sCustEmail);
				log.info("Cust password in checkIfCustomer--" + sCustPass);
				Customer cust = dao.findByEmail(sCustEmail);
				if(cust != null) {
					log.info("customer present name--" + cust.getCustName());
					log.info("customer present id--" + cust.getCustID());
					boolean isPasswordCorrect= dao.checkPassword(sCustEmail,sCustPass);
					if(isPasswordCorrect)
					{
						log.info("isPasswordCorrect" +isPasswordCorrect);
						HttpSession session=request.getSession();
						session.setAttribute("sessionCustEmail",sCustEmail);
						session.setAttribute("sessionCustPass",sCustPass);
						mv.setViewName("CustHomePage.jsp");
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
	@GetMapping("/customerLogout")
	public ModelAndView customerLogout(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session=request.getSession();
		session.invalidate();
		log.info("Customer Logged out");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("CustLoginRegister.jsp");
		return mv;
		
	}
}
