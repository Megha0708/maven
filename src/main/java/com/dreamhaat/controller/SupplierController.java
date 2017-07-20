package com.dreamhaat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dreamhaat.dao.SupplierDao;
import com.dreamhaat.model.Supplier;

@Controller
public class SupplierController 
{

	@Autowired
	 SupplierDao sd;
	
	@RequestMapping(value="/supplierpage", method=RequestMethod.GET)
	public ModelAndView showsupplierdetails()
	{
		ModelAndView mvc = new ModelAndView("supreg","supplier",new Supplier());
		String suppliers = sd.Retrive();
		mvc.addObject("mylist", suppliers);
		return mvc;
		
	}
	
	
	@RequestMapping(value="/Insert", method=RequestMethod.POST)
	public ModelAndView addSupplier(Supplier s)
	{
		ModelAndView mvc1 = new ModelAndView("supreg","supplier",new Supplier());
		System.out.println(s.getId());
		sd.insert(s);

		String suppliers = sd.Retrive();

		mvc1.addObject("mylist", suppliers);
		
		return mvc1;
		
	}
	
}
