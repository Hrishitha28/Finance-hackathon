package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.entity.customer;

@Stateless
public class customerroll implements customermanager{
    
	String url = "jdbc:mysql://localhost:3306/project";
	String user = "root";
	String password = "2000031074";
	Connection con = null;
	PreparedStatement ps = null;
	@Override
	public String save(customer c) throws Exception {
		con = DriverManager.getConnection(url,user,password);
		ps = con.prepareStatement("insert into finance values(?,?,?,?,?,?)");
		ps.setString(1,c.getFname());
		ps.setString(2,c.getMname());
		ps.setString(3,c.getLname());
		ps.setString(4,c.getNation());
		ps.setString(5,c.getEmail());
		ps.setString(6,c.getPassword());
	    ps.execute();
		con.close();
		return "successfully register";
	}
	@Override
	public List<customer> read() throws Exception {
		con = DriverManager.getConnection(url,user,password);
		ps = con.prepareStatement("select * from finance where email = ?");
		ResultSet rs = ps.executeQuery();
		List<customer> L = new ArrayList<customer>();
		while(rs.next()) {
			customer c = new customer();
			c.setFname(rs.getString(1));
			c.setMname(rs.getString(2));
			c.setLname(rs.getString(3));
			c.setNation(rs.getString(4));
			c.setEmail(rs.getString(5));
			c.setPassword(rs.getString(6));
			L.add(c);
		}
		con.close();
		return L;
	}
	@Override
	public boolean login(customer c) throws Exception {
		con = DriverManager.getConnection(url,user,password);
		ps = con.prepareStatement("Select email from  finance where email = ? and password = ?");
		ps.setString(1,c.getEmail());
		ps.setString(2, c.getPassword());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next())  
		{   
		    c.setFname(rs.getString(1)); 
			return true;
		}
		return false;
	}
	
	

}
