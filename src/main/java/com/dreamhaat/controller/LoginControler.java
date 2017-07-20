package com.dreamhaat.controller;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamhaat.dao.ProductDao;

import com.dreamhaat.model.Cart;

@Controller
public class LoginControler 
{
	@Autowired
	ProductDao cdaao;
	public LoginControler()
	{}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/loginSuccessful")
	public String login_session_attributes(HttpSession session,Model model)
	{
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
	
	

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		String page="";
		String role="ROLE_USER";
		int size=0;
		
		System.out.println("Login :"+username);
		
		for (GrantedAuthority authority : authorities) 
		{
			if(authority.getAuthority().equals(role))
			{
				
				String mylist3=cdaao.Retrive();
				model.addAttribute("mylist3",mylist3);
				session.setAttribute("Userid", username);
		
				page="UserProductView";
				List<Cart> ob = new ArrayList<Cart>();
				session.setAttribute("UserLoggedIn",true);
				size=ob.size();
				session.setAttribute("mycart",ob);
				session.setAttribute("count",size);
				System.out.println("My Session	:"+session.getId());
		    }
			else 
		    {
			session.setAttribute("Administrator", "true");
			page="Login";
			}
		}
		return page;
		
	}
	
	
	@RequestMapping("/Login")
	public String showlogin() 
	{
	System.out.println("Hiii Login");
	return "Login";
	}
	
	
	
	@RequestMapping("/userproductview")
	public String show() 
	{
	System.out.println("Hiii Show");
	return "UserProductView";
	}
	
	
	
	
	@RequestMapping("/Admin")
	public String Admin() 
	{
	System.out.println("Hiii Admin");
	return "AdminHeader";
	}
	
	
	
	@RequestMapping("/Suplier")
	public String Supplier() 
	{
	System.out.println("Hiii Supplier");
	return "SupplierView";
	}
	
	
	
	@RequestMapping("/Products")
	public String pro() 
	{
	System.out.println("Hiii Supplier");
	return "productreg";
	}
	
	
	
	@RequestMapping(value = "/perform_logout")
	public String homelogout() 
	{
	return "Login";
	}
	
}
