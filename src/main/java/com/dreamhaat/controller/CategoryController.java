package com.dreamhaat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dreamhaat.dao.CategoryDao;
import com.dreamhaat.model.Category;

@Controller
public class CategoryController 
{

	@Autowired
	CategoryDao cd;
	
	@RequestMapping(value="/categoryregister",method=RequestMethod.GET)
	public ModelAndView showCategoryDetails()
	{
		ModelAndView mv=new ModelAndView("categoryreg","category",new Category());
		String categeries=cd.Retrive();
		mv.addObject("mylist",categeries);
		return mv;
		
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public ModelAndView addCategory(Category c)
	{
		ModelAndView mv=new ModelAndView("categoryreg","category",new Category());
		System.out.println(c.getId());
		cd.insert(c);
		boolean data=false;
		String categeries=cd.Retrive();
		mv.addObject("checkk",data);
		mv.addObject("mylist",categeries);
		return mv;
		
	}
	
	
}
