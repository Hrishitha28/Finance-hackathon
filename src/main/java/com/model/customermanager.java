package com.model;

import java.util.List;


import javax.ejb.Remote;

import com.entity.customer;

@Remote
public interface customermanager {
    public String save(customer c) throws Exception;
    public List<customer> read() throws Exception;
    public boolean login(customer c) throws Exception;
}
