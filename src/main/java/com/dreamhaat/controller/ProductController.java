package com.dreamhaat.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dreamhaat.dao.CategoryDao;
import com.dreamhaat.dao.ProductDao;
import com.dreamhaat.dao.SupplierDao;
import com.dreamhaat.model.Product;

@Controller
public class ProductController 
{

	@Autowired
	 ProductDao pd;
	
	@Autowired
	SupplierDao sd;
	
	@Autowired
	CategoryDao cd;
	
	@RequestMapping(value="/productpage", method=RequestMethod.GET)
	public ModelAndView showProductdetails()
	{
	
		int data=1;
		ModelAndView mvc = new ModelAndView("productreg","product",new Product());
		String products = pd.Retrive();
		String categories = cd.Retrive();
		String suppliers = sd.Retrive();
		mvc.addObject("mylist1", categories);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("mylist3", products);
		mvc.addObject("checkk",data);
		return mvc;
		
	}
	
	
	@RequestMapping(value="/Insertproduct", method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product")Product product,BindingResult result)
	{
		ModelAndView mvc1 = new ModelAndView("productreg","product",new Product());
		System.out.println(product.getPid());
		
		pd.insert(product);
		

		
		
		String path="C:\\DT Project\\DreamHaat\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getPid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=product.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
              			fos.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		 int data=1;
		 String categories = cd.Retrive();
		
		String suppliers = sd.Retrive();
		
		String products = pd.Retrive();
	
		 mvc1.addObject("checkk",data);
		mvc1.addObject("mylist3", products);
		mvc1.addObject("mylist1", categories);
		mvc1.addObject("mylist2", suppliers);
		return mvc1;
		
	}
	@RequestMapping(value="/productDescription", method=RequestMethod.GET)
	public ModelAndView showProduct(@RequestParam("pid")int cid)
	{
		
       int data=3;
		ModelAndView mvc1 = new ModelAndView("productreg","product",new Product());
		String pocc=pd.Retrive1(cid);
		mvc1.addObject("poc",pocc);
		mvc1.addObject("checkk",data);
	   return mvc1;
	}
	
	@RequestMapping(value="/plzUpdatedproduct", method=RequestMethod.GET)
	public ModelAndView plzUpdatedProduct(@RequestParam("pid")int cid)
	{
		Product poc=pd.UpdateProduct(cid);
       int data=2;
		ModelAndView mvc1 = new ModelAndView("productreg","product",poc);
		String categories = cd.Retrive();
		String suppliers = sd.Retrive();
		String products=pd.Retrive();
		mvc1.addObject("mylist3",products);
		mvc1.addObject("mylist1", categories);
		mvc1.addObject("mylist2", suppliers);
		mvc1.addObject("checkk",data);
	   return mvc1;
	}
	
	@RequestMapping(value="/Deleteproduct", method=RequestMethod.GET)
	public ModelAndView DeleteProduct(@RequestParam("pid")int id)
	{
	    int data=1;
		pd.Delete(id);
		ModelAndView mvc1 = new ModelAndView("productreg","product",new Product());
		String products=pd.Retrive();
		String categories = cd.Retrive();
		String suppliers = sd.Retrive();
		mvc1.addObject("mylist1", categories);
		mvc1.addObject("mylist2", suppliers);
		mvc1.addObject("mylist3",products);
		mvc1.addObject("checkk",data);

		return mvc1;
		
	}
	
	@RequestMapping(value="/plzNowUpdatedproducts", method=RequestMethod.POST)
	public ModelAndView plzNowUpdatedProducts(HttpServletRequest request)
	{
		  String cid=request.getParameter("pid");                                                 
		String cname=request.getParameter("name");
		String cprice=request.getParameter("price");
		String cstock=request.getParameter("stock");    
        String cdesc=request.getParameter("description");
        String ccat_id=request.getParameter("cat_id");
        String csup_id=request.getParameter("sup_id");
        String csupplier=request.getParameter("supplier");
        
		int data=1;
		int cid1=Integer.parseInt(cid);
		float price=Float.parseFloat(cprice);
		int stock=Integer.parseInt(cstock);
		int cat_id=Integer.parseInt(ccat_id);
		int sup_id=Integer.parseInt(csup_id);
		
		pd.NowUpdateProduct(cid1,cname,price,stock,cdesc,cat_id,sup_id,csupplier);
		ModelAndView mvc = new ModelAndView("productreg","product",new Product());
		String products=pd.Retrive();
		String categories = cd.Retrive();
		String suppliers = sd.Retrive();
		mvc.addObject("mylist3",products);
		mvc.addObject("mylist1", categories);
		mvc.addObject("mylist2", suppliers);
		mvc.addObject("checkk",data);
	   return mvc;
	}
	
	@RequestMapping(value = "DisplayProduct", method = RequestMethod.GET)
	public ModelAndView showProductAdmin() 
	{
		
		
		ModelAndView mvc = new ModelAndView("UserProductView","product",new Product());
		
		

		String products = pd.Retrive();
		
	
		mvc.addObject("mylist3", products);
		return mvc;
	}
	
}
