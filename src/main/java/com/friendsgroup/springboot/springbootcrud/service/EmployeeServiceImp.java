package com.friendsgroup.springboot.springbootcrud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendsgroup.springboot.springbootcrud.dao.Empdao;
import com.friendsgroup.springboot.springbootcrud.entity.Employee;


@Service
public class EmployeeServiceImp implements EmployeeService {
	
	
	private Empdao empdao;
	
	@Autowired
	public EmployeeServiceImp(Empdao theempdao){
		empdao=theempdao;
		
	}
	
	

	@Override
	@Transactional
	public List<Employee> findall() {
		
		return empdao.findall();
	}

	@Override
	@Transactional
	public Employee findbyid(int theid) {
		
		return empdao.findbyid(theid);
	}

	@Override
	@Transactional
	//save employee servicde api
	public void save(Employee theemployee) {
		
		empdao.save(theemployee);
	}

	@Override
	@Transactional
	public void deletebyid(int theid) {
		
		empdao.deletebyid(theid);
	}
	
	


}
