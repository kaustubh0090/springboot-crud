package com.friendsgroup.springboot.springbootcrud.service;

import java.util.List;

import com.friendsgroup.springboot.springbootcrud.entity.Employee;

public interface EmployeeService {
	
	
	
	public List<Employee> findall();
	public Employee findbyid(int theid);
	public void save(Employee theemployee);
	public void deletebyid(int theid);
	
	
	
	
	

}
