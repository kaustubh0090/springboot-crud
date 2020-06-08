package com.friendsgroup.springboot.springbootcrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendsgroup.springboot.springbootcrud.dao.Empdao;
import com.friendsgroup.springboot.springbootcrud.entity.Employee;
import com.friendsgroup.springboot.springbootcrud.service.EmployeeService;

@RestController
@RequestMapping("/test")
public class EmployeeRestController {

	public EmployeeService empservice;

	@Autowired
	public EmployeeRestController(EmployeeService theempservice) {

		empservice = theempservice;
	}

	// To Print employee record
	@GetMapping("/emplist")
	public List<Employee> employeelist() {

		return empservice.findall();

	}

	// To Print employee record with employeeid
	@GetMapping("/employee/{theid}")
	public Employee getbyid(@PathVariable int theid) {

		Employee theemployee = empservice.findbyid(theid);

		return theemployee;

	}

	// To Save Employee Record
	@PostMapping("/employee")
	public Employee addemployee(@RequestBody Employee theemployee) {

		theemployee.setId(0);

		empservice.save(theemployee);

		return theemployee;

	}

	// To update Employee Record
	@PutMapping("/employee")
	public Employee updateEmp(@RequestBody Employee theemployee) {

		empservice.save(theemployee);
		return theemployee;
	}

	// To delete Employee record by id
	@DeleteMapping("/employee/{theid}")
	public String deletebyid(@PathVariable int theid) {

		empservice.deletebyid(theid);

		return "employee delete with id " + theid;

	}
}