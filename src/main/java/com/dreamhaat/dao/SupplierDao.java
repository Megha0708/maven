package com.dreamhaat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamhaat.model.Supplier;
import com.google.gson.Gson;

@Repository
public class SupplierDao
{
   @Autowired
   private SessionFactory sf;
   

 public void insert(Supplier s) 
 {
	Session session=sf.openSession();
	System.out.println("Insert Method call for Supplier-Details");
	Transaction t = session.getTransaction();
	t.begin();
	session.save(s);
	session.flush();
	t.commit();
	session.close();
	
}
 
 public String Retrive()
	{
		Session connection=sf.openSession();
		Transaction tx=connection.getTransaction();
		tx.begin();
	
		 List listdata = connection.createQuery("FROM Supplier").list();
		 Gson gson = new Gson();
		 String jsonNames = gson.toJson(listdata);
		 tx.commit();
		 connection.close();
	     return jsonNames;

	}
}