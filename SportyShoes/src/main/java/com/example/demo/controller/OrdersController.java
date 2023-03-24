package com.example.demo.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Customer;
import com.example.demo.model.Orders;
import com.example.demo.model.Shoe;
import com.example.demo.service.CustomerDAO;
import com.example.demo.service.OrdersDAO;
import com.example.demo.service.ShoeDAO;

@Controller
public class OrdersController {

	@Autowired
	OrdersDAO orderDAO;
	@Autowired
	CustomerDAO custDAO;
	@Autowired
	ShoeDAO shoeDAO;
	Logger log = Logger.getAnonymousLogger();

	@RequestMapping("/addOrder")
	public ModelAndView addOrder(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		log.info("shoePrice in insertControl ---" + request.getParameter("shoePrice"));
		int nOrderedQuantity = Integer.parseInt(request.getParameter("shoeQuantity"));
		log.info("shoeQuantity in insertControl ---" + nOrderedQuantity);
		log.info("passShoeID in insertControl ---" + request.getParameter("shoeIDText"));
		log.info("shoeID in insertControl ---" + request.getParameter("shoeID"));
		if(request.getParameter("bankID") == null || request.getParameter("bankID") == "")
		{
			request.setAttribute("ErrorText", "Please enter Bank ID as 1 or 2");
			mv.setViewName("ErrorMsg.jsp");
		}
		else
		{
			int nBankID = Integer.parseInt(request.getParameter("bankID"));

			if(nBankID == 1 || nBankID == 2) 
			{
				Orders newOrder = new Orders();
				log.info("in addOrders");		

				HttpSession session=request.getSession();
				if(session.getAttribute("sessionCustEmail") != null)
				{
					String sCustEmail = session.getAttribute("sessionCustEmail").toString();

					if(sCustEmail != null && sCustEmail.length() > 0)
					{
						log.info("sCustEmail--" + sCustEmail);
						Customer cust = custDAO.findByEmail(sCustEmail);
						if(cust != null)
						{
							log.info("cust in addOrder--" + cust.getCustID());
							newOrder.setCustRef(cust);

							int nShoeID = Integer.parseInt(request.getParameter("shoeIDText"));
							Shoe selectedShoe = shoeDAO.getShoeById(nShoeID);
							if(selectedShoe != null) 
							{
								newOrder.setShoeRef(selectedShoe);

								int nAvailableShoes = selectedShoe.getShoeQuantity();
								if(nAvailableShoes >= nOrderedQuantity)
								{
									int nShoePrice = Integer.parseInt(request.getParameter("shoePrice"));
									newOrder.setShoePrice(nShoePrice);
									newOrder.setOrderQuantity(Integer.parseInt(request.getParameter("shoeQuantity")));
									newOrder.setPurchaseDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
									newOrder.setTotalAmountPaid(nOrderedQuantity*nShoePrice);
									Orders ep = orderDAO.addOrder(newOrder);
									if (ep != null) {
										shoeDAO.updateShoeQuantity(selectedShoe, nAvailableShoes-nOrderedQuantity);
										String sShoePurchased = "Thank you for shopping with Sporty Shoes!<br> Your have purchased " + request.getParameter("shoeQuantity")
										+ " no. of " + request.getParameter("shoeNameText") + " shoes.";
										request.setAttribute("ShoePurchased", sShoePurchased);
										mv.setViewName("CustShoePurchased.jsp");
									}
									else {
										request.setAttribute("ErrorText", "Purchase Unsuccessfull. Please try again later.");
										mv.setViewName("ErrorMsg.jsp");
									}
								}
								else
								{
									request.setAttribute("ErrorText", "The number of shoes available for purchase is:- " + nAvailableShoes + 
											".Please select the shown quantity to go through with purchase. ");
									mv.setViewName("ErrorMsg.jsp");
								}
							}
							else
							{
								request.setAttribute("ErrorText", "Internal Error.Please contact Admin.");
								mv.setViewName("ErrorMsg.jsp");
								log.info("Shoe with the provided ID not found.");
							}
						}
						else {
							request.setAttribute("ErrorText", "Internal Error.Please contact Admin.");
							mv.setViewName("ErrorMsg.jsp");
							log.info("Customer with the provided ID not found.");
						}
					}	
				}
				else
				{
					log.info("Customer not logged in.");
					request.setAttribute("ErrorText", "Customer not logged in.");
					mv.setViewName("index.jsp");
				}
			
			}
			else {
				request.setAttribute("ErrorText", "Please enter Bank ID as 1 or 2");
				mv.setViewName("ErrorMsg.jsp");
			}
		}

		return mv;
	}
	@RequestMapping("/getAllOrders")
	public ModelAndView displayAll(HttpServletRequest request, HttpServletResponse response) {
		log.info("in getAllOrders");
		ModelAndView mv = new ModelAndView();
		List<Orders> list = orderDAO.getAllOrder();
		mv.setViewName("AdminPurchaseReport.jsp");
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("/getAllOrders2")
	public ModelAndView getAllOrders2(HttpServletRequest request, HttpServletResponse response) {
		log.info("in getAllOrders2");
		ModelAndView mv = new ModelAndView();
		List<Orders> list = orderDAO.getAllOrder();
		log.info("---list--" + list.size());
		mv.setViewName("AdminFilterPurchaseReport.jsp");
		mv.addObject("list", list);
		return mv;
	}
	@RequestMapping("/getFilteredOrders")
	public ModelAndView getFilteredOrders(HttpServletRequest request, HttpServletResponse response) {
		log.info("in getFilteredOrders");
		ModelAndView mv = new ModelAndView();	
		String date1 = request.getParameter("From_Date");
		String date2 = request.getParameter("To_Date");
		log.info("date1--" + java.sql.Date.valueOf(date1));
		log.info("date2--" + java.sql.Date.valueOf(date2));
		List<Orders> list = orderDAO.filterOrders(java.sql.Date.valueOf(date1), java.sql.Date.valueOf(date2));
		mv.addObject("filteredList", list);
		mv.setViewName("AdminFilteredReport.jsp");
		return mv;
	}
}
