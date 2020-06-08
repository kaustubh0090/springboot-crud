package com.friendsgroup.springboot.springbootcrud.dao;

import java.util.List;

import com.friendsgroup.springboot.springbootcrud.entity.Employee;

public interface Empdao {
	
	public List<Employee> findall();
	public Employee findbyid(int theid);
	public void save(Employee theemployee);
	public void deletebyid(int theid);
	
	
	
	

}
