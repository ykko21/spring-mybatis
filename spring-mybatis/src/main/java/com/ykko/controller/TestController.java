package com.ykko.controller;

import java.sql.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ykko.entity.Department;
import com.ykko.entity.Employee;
import com.ykko.entity.Request;
import com.ykko.entity.Response;
import com.ykko.service.CompositeService;
import com.ykko.service.EmployeeService;

@RestController
@RequestMapping(value="test", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {
	
	private static final Logger logger = LogManager.getLogger(TestController.class);
	private String template = "Hello, %s!";
	
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private CompositeService compositeService;
	
	public TestController() {
		if(logger.isDebugEnabled()) {
			logger.debug("*** TestController created! ***");
		}
	}
	
	//http://localhost:8080/spring-mybatis/test/g1
	@GetMapping("/g1")
	public Response g1() {
		return new Response("1",200,"g1");
	}
	
	//http://localhost:8080/spring-mybatis/test/g2?name=ykko
	@GetMapping("/g2")
	public Response g2(@RequestParam(value="name", defaultValue="World") String name) {
		String val = String.format(template, name);			
		return new Response("1",200,val);
	}
	
	//http://localhost:8080/spring-mybatis/test/employee/7369
	@GetMapping("/employee/{id}")
	public Response getEmployee(@PathVariable int id) {
		logger.debug("id: " + id);
		try {
			Employee emp = empService.findByEmpNo(id);
			if(emp != null) {
				ObjectMapper o2j = new ObjectMapper();
				String jsonString = o2j.writeValueAsString(emp);
				return new Response("1",200,jsonString);
			}
			else {
				return new Response("1",404,"{}");
			}
		}
		catch(Exception e) {
			logger.error("",e);
			return new Response("1",200,e.getMessage());	
		}
	}
	
	//http://localhost:8080/spring-mybatis/test/employee
	@PostMapping("/employee")
	public Response save() {
		try {
			//Employee(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno)
			Employee emp = new Employee(
					7935, "Peter", "Engineer", 7902, new Date(System.currentTimeMillis()), 1000, 0, 20);
			empService.insert(emp);
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(emp);
			return new Response("1",200,"OK");
			
		}
		catch(Exception e) {
			logger.error("",e);
			return new Response("1",200,e.getMessage());	
		}
	}
	
	//http://localhost:8080/spring-mybatis/test/tx
	@PostMapping("/tx")
	public Response tx() {
		try {
			//Employee(int empno, String ename, String job, int mgr, Date hiredate, int sal, int comm, int deptno)
			
			Department dept = new Department(50,"IT", "NJ");
			Employee emp = new Employee(
					7936, "John", "Engineer", 7902, new Date(System.currentTimeMillis()), 1000, 0, 20);			
					
			compositeService.insertDeptEmp(dept, emp);
			return new Response("1",200,"OK");
			
		}
		catch(Exception e) {
			logger.error("",e);
			return new Response("1",200,e.getMessage());	
		}
	}	
	
	
	
		
	@PostMapping("/p2")
	public Response p2(@RequestBody String payload) {		
		return new Response("1",200, payload);
	}
}
