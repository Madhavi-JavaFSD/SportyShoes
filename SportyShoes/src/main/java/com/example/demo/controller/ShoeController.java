package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Shoe;
import com.example.demo.service.ShoeDAO;

@Controller
public class ShoeController {

	@Autowired
	ShoeDAO dao;
	Logger log = Logger.getAnonymousLogger();

	/*
	 * @RequestMapping("/") public ModelAndView displaypage(HttpServletRequest
	 * request,HttpServletResponse response) { ModelAndView mv=new ModelAndView();
	 * mv.setViewName("index.jsp"); return mv; }
	 */

	@RequestMapping("/getAllShoe")
	public ModelAndView displayAll(HttpServletRequest request, HttpServletResponse response) {
		log.info("in getAllShoe");
		ModelAndView mv = new ModelAndView();
		List<Shoe> list = dao.getAllShoe();
		mv.setViewName("AdminModifyShoe.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/addShoe")
	public ModelAndView insertControl(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView();
		Shoe a = new Shoe();
		log.info("in addShoe");
		// a.setEmpno(Integer.parseInt(request.getParameter("ShoeID")));
		a.setShoeName(request.getParameter("shoeName"));
		log.info("ShoePrice--" + request.getParameter("shoePrice"));
		a.setShoePrice(Integer.parseInt(request.getParameter("shoePrice")));
		a.setShoeQuantity(Integer.parseInt(request.getParameter("shoeQuantity")));
		Shoe ep = dao.addShoe(a);
		if (ep != null) {
			mv.setViewName("AdminDisplayShoesButton.jsp");
		}
		return mv;
	}

	@RequestMapping("/modifyShoe")
	public ModelAndView displayToModify(HttpServletRequest request, HttpServletResponse response) {
		log.info("in modifyShoe");
		ModelAndView mv = new ModelAndView();
		List<Shoe> list = dao.getAllShoe();
		mv.setViewName("AdminModifyShoe.jsp");
		mv.addObject("list", list);
		return mv;
	}
	@GetMapping("/editShoe")
	public ModelAndView editShoe(HttpServletRequest request, HttpServletResponse response){
		
		log.info("Shoe name in editShoe controller--" + request.getParameter("passShoeID"));
		//return dao.findbyname(name);
		ModelAndView mv = new ModelAndView();
		Shoe selectedShoe = dao.getShoeById(Integer.parseInt(request.getParameter("passShoeID")));
		List<Shoe> list = new ArrayList<Shoe>();
		list.add(selectedShoe);
		if(list != null && list.size()>0)
		{
			mv.setViewName("AdminEditShoe.jsp");
			mv.addObject("list", list);
		}
		else {
			request.setAttribute("ErrorText", "No Records Found");
			mv.setViewName("ErrorMsg.jsp");
		}
		return mv;	
	}

	@RequestMapping("/updateShoe")
	public ModelAndView updateShoe(HttpServletRequest request, HttpServletResponse response) {
		log.info("in updateShoe---");
		log.info("passShoeID in controller ---" + request.getParameter("passShoeID"));
		log.info("shoeID in controller ---" + request.getParameter("shoeID"));
		//pass shoe ID from view to controller, then call AdminEditShoe.jsp (pass shoe ID as parameter), 
		//show the previous values in the text box, let the user edit the vales, click on 'Submit',
		//call editShoe action in controller and call updateShoe in dao from there.
		ModelAndView mv = new ModelAndView();
		String sShoeID = null;
		try {
			sShoeID = request.getParameter("shoeID");
		}
		catch(Exception e)
		{
			log.info("Exception:" + e.toString());
		}
		if(sShoeID!= null && sShoeID.length()>0)
		{
			int oldShoeID = Integer.parseInt(sShoeID);
			Shoe newShoe = dao.getShoeById(oldShoeID);
			newShoe.setShoeName(request.getParameter("shoeName"));
			newShoe.setShoePrice(Integer.parseInt(request.getParameter("shoePrice")));
			newShoe.setShoeQuantity(Integer.parseInt(request.getParameter("shoeQuantity")));		
			Shoe ep = dao.updateShoe(oldShoeID, newShoe); 
			if (ep != null) {
				List<Shoe> list = dao.getAllShoe();
				mv.setViewName("AdminModifyShoe.jsp");
				mv.addObject("list", list);
			}
		}	
		else {
			request.setAttribute("ErrorText", "No Records Found");
			mv.setViewName("ErrorMsg.jsp");
		}
		return mv;
	}
	@RequestMapping("/deleteShoe")
	public ModelAndView deleteShoe(HttpServletRequest request, HttpServletResponse response) {
		log.info("in deleteShoe---");
		log.info("Shoe ID in delete controller 3---" + request.getParameter("passShoeID"));
		ModelAndView mv = new ModelAndView();
		int oldShoeID = Integer.parseInt(request.getParameter("passShoeID"));
		if (dao.deleteShoe(oldShoeID)) {
			List<Shoe> list = dao.getAllShoe();
			mv.setViewName("AdminModifyShoe.jsp");
			mv.addObject("list", list);
		}
		return mv;		
	}

	/*
	 * @GetMapping("/getShoeByname/{name}") public ModelAndView
	 * findbyname(@PathVariable("name") String name){
	 * log.info("Shoe name in controller--" + name); //return dao.findbyname(name);
	 * ModelAndView mv = new ModelAndView(); List<Shoe> list = dao.findbyname(name);
	 * mv.setViewName("AdminModifyShoe.jsp"); mv.addObject("list", list); return mv;
	 * }
	 */
	@GetMapping("/getShoeByname")
	public ModelAndView findbyname(HttpServletRequest request, HttpServletResponse response){
		log.info("Shoe name in controller--" + request.getParameter("shoeName"));
		//return dao.findbyname(name);
		ModelAndView mv = new ModelAndView();
		List<Shoe> list = dao.findbyname(request.getParameter("shoeName"));
		mv.setViewName("AdminModifyShoe.jsp");
		mv.addObject("list", list);
		return mv;	
	}
	@RequestMapping("/getAllShoeForCustomer")
	public ModelAndView displayShoesForCustomer(HttpServletRequest request, HttpServletResponse response) {
		log.info("in displayShoesForCustomer");
		ModelAndView mv = new ModelAndView();
		List<Shoe> list = dao.getAllShoe();
		mv.setViewName("CustDisplayShoe.jsp");
		mv.addObject("list", list);
		return mv;
	}
	@GetMapping("/getShoeBynameForCust")
	public ModelAndView findbynameForCust(HttpServletRequest request, HttpServletResponse response){
		log.info("Shoe name in controller for getShoeBynameForCust--" + request.getParameter("shoeName"));
		//return dao.findbyname(name);
		ModelAndView mv = new ModelAndView();
		List<Shoe> list = dao.findbyname(request.getParameter("shoeName"));
		mv.setViewName("CustDisplayShoe.jsp");
		mv.addObject("list", list);
		return mv;	
	}
	
	@GetMapping("/findShoeByID")
	public ModelAndView findShoeByID(HttpServletRequest request, HttpServletResponse response){
		log.info("Shoe name in findShoeByID controller--" + request.getParameter("passShoeID"));
		//return dao.findbyname(name);
		ModelAndView mv = new ModelAndView();
		Shoe selectedShoe = dao.getShoeById(Integer.parseInt(request.getParameter("passShoeID")));
		List<Shoe> list = new ArrayList<Shoe>();
		list.add(selectedShoe);
		if(list != null && list.size()>0)
		{
			mv.setViewName("CustPayPage.jsp");
			mv.addObject("list", list);
		}
		else {
			request.setAttribute("ErrorText", "No Records Found");
			mv.setViewName("ErrorMsg.jsp");
		}
		return mv;	
	}
	
}
