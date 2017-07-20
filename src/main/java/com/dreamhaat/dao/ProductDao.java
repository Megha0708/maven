package com.dreamhaat.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;

import com.dreamhaat.model.Product;

@Repository
public class ProductDao
{
   @Autowired
   private SessionFactory sf;
   

 public void insert(Product p) 
 {
	Session session=sf.openSession();
	System.out.println("Insert Method call for Product-Details");
	Transaction t = session.getTransaction();
	t.begin();
	session.save(p);
	session.flush();
	t.commit();
	session.close();
	
}
 

	public String Retrive()
	{
	Session connection=sf.openSession();
	Transaction tx=connection.getTransaction();
	tx.begin();

	 List listdata = connection.createQuery("FROM Product").list();
	 Gson gson = new Gson();
	 String jsonNames = gson.toJson(listdata);
	 tx.commit();
	 connection.close();
  return jsonNames;

	}
	
	public String Retrive1(int cid)
	{
	Session connection=sf.openSession();
	Transaction tx=connection.getTransaction();
	tx.begin();

	 Query qry = connection.createQuery("FROM Product p where p.pid= :java4s");
	 qry.setParameter("java4s",cid);
	 List listdata=qry.list();
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
		Product ob=(Product)session.get(Product.class, cid);
		System.out.println("This is ID"+ " "+ob.getName());
		session.delete(ob);
		session.flush();
		tx.commit();
		session.close();
		System.out.println("Delete Method Called");
}
	
	
	public Product UpdateProduct(Integer id) {
		Session session =sf.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Product ob=(Product)session.get(Product.class, id);
		tx.commit();
		session.close();
		return ob;
	}
	
	public void NowUpdateProduct(int cid,String cname,float cprize,int cstock,String cdesc,int cat_id, int sup_id, String supplier) {
		Session session =sf.openSession();
		Transaction tx=session.getTransaction();
		tx.begin();
		Product ob=(Product)session.get(Product.class, cid);
		ob.setName(cname);
		ob.setPrice(cprize);
        ob.setStock(cstock);
       ob.setDescription(cdesc);
       ob.setCat_id(cat_id);
       ob.setSup_id(sup_id);
       ob.setSupplier(supplier);
		session.update(ob);
		tx.commit();
		session.close();
		System.out.println("Update Method Called");
	
	}
	
	//For Display Click big images
	public Product DisplayImage(int ccid)
	{
	Session session=sf.openSession();
	session.beginTransaction();
	Product ok=(Product)session.get(Product.class,ccid);
	session.close();
	return ok;
		
		
	}
	
}