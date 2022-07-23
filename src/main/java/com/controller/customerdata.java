package com.controller;



import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.*;
import com.entity.customer;
import com.model.customermanager;

@ManagedBean(name="cus",eager=true)
public class customerdata<RequestDispatcher> {
	String fname;
	String lname;
	String mname;
	String nation;
	String email;
	String password;
    String res;
    List<customer> L;
    public List<customer> getL() {
		try {
			L = cm.read();
		}
    	catch(Exception e) {
    		res = e.getMessage();
    	}
    	
    	return L;
	}
	public void setL(List<customer> l) {
		L = l;
	}
	@EJB(lookup = "java:global/datatable/customerroll!com.model.customermanager")
    customermanager cm;
    List<customer> list;
	
    
    
    
	public List<customer> getList() {
		try {
			list = cm.read();
		}
		catch(Exception e) {
			res = e.getMessage();
			
		}
		
		return list;
	}





	public void setList(List<customer> list) {
		this.list = list;
	}





	public String getFname() {
		return fname;
	}





	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getLname() {
		return lname;
	}





	public void setLname(String lname) {
		this.lname = lname;
	}





	public String getMname() {
		return mname;
	}





	public void setMname(String mname) {
		this.mname = mname;
	}





	public String getNation() {
		return nation;
	}





	public void setNation(String nation) {
		this.nation = nation;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}
	public String getRes() {
		return res;
	}
	public void setRes(String res) {
		this.res = res;
	}
           
           public String save() {
        	   try {
        		   customer c = new customer();
        		   c.setFname(fname);
        		   c.setMname(mname);
        		   c.setLname(lname);
        		   c.setNation(nation);
        		   c.setEmail(email);
        		   c.setPassword(password);
        		   res = cm.save(c);
        		   return "login.xhtml";
            	   
        	   }
        	   catch(Exception e) {
        		   
        		   res = e.getMessage();
        	   }
        	  return null;
			
           }           
         public void login() throws Exception {
        	    customer c = new customer();
        		c.setEmail(email);
        		c.setPassword(password);
        		
        		boolean p = cm.login(c);
        		     if(p)
        		     res = c.getFname(); 
        		     else
        		    	 res="failed";
        	  
         }
}