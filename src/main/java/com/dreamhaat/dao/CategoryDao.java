package com.dreamhaat.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamhaat.model.Category;
import com.google.gson.Gson;

@Repository
public class CategoryDao 
{

	@Autowired
	private SessionFactory sf;
	   

	 public void insert(Category c) 
	 {
		Session session=sf.openSession();
		
		Transaction t = session.getTransaction();
		t.begin();
		session.save(c);
		session.flush();
		t.commit();
		session.close();
		
	}
	 
	 public String Retrive()
		{
			Session connection=sf.openSession();
			Transaction tx=connection.getTransaction();
			tx.begin();
		
			 List listdata = connection.createQuery("FROM Category").list();
			 Gson gson = new Gson();
			 String jsonNames = gson.toJson(listdata);
			 tx.commit();
			 connection.close();
		     return jsonNames;

		}

	 public void Delete(Integer cid) {
			Session session =sf.openSession();
			Transaction tx=session.getTransaction();
			tx.begin();
			Category ob=(Category)session.get(Category.class, cid);
			session.delete(ob);
			tx.commit();
			session.close();
			System.out.println("Delete Method Called");
	}
		
	 
	 
}
