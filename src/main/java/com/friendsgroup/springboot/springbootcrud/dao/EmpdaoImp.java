package com.friendsgroup.springboot.springbootcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.friendsgroup.springboot.springbootcrud.entity.Employee;

@Repository
public class EmpdaoImp implements Empdao {
	
	private EntityManager entitymanager;
	
	@Autowired
	public EmpdaoImp(EntityManager theentitymanager){
		
		entitymanager=theentitymanager;
	}

	@Override
	public List<Employee> findall() {
		
		//create session
		Session currentsession=entitymanager.unwrap(Session.class);
		
		//create query
		Query<Employee> thequery=currentsession.createQuery("from Employee",Employee.class);
		
		//execute query
		
		List<Employee> employees=thequery.getResultList();
		
		return employees;
	}

	@Override
	public Employee findbyid(int theid) {
		
		Session currentsession=entitymanager.unwrap(Session.class);
		
		Employee theemployee=currentsession.get(Employee.class, theid);
		
		
		return theemployee;
	}

	@Override
	public void save(Employee theemployee) {
		Session currentsession=entitymanager.unwrap(Session.class);
		
		currentsession.saveOrUpdate(theemployee);
		
		
	}

	@Override
	public void deletebyid(int theid) {
     
		Session currentsession=entitymanager.unwrap(Session.class);
		
		Query thequery=currentsession.createQuery("delete from Employee where id=:employeeid");
		
		thequery.setParameter("employeeid", theid);
		
		thequery.executeUpdate();
		
		
	}
	
	
	
	

}
